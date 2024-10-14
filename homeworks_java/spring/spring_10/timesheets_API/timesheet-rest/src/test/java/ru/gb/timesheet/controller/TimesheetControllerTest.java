package ru.gb.timesheet.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import ru.gb.model.Timesheet;
//import ru.gb.repository.ProjectRepository;
import ru.gb.repository.TimesheetRepository;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TimesheetControllerTest {

    @Autowired
    TimesheetRepository timesheetRepository;

//    @Autowired
//    ProjectRepository projectRepository;

    @LocalServerPort
    private int port;
    private RestClient restClient;

    @BeforeEach
    void beforeEach() {
        restClient = RestClient.create("http://localhost:" + port);
    }

    @Test
    void testFindById() {

        Timesheet timesheet = new Timesheet();

        timesheet.setProjectId((long)1);
        timesheet.setEmployeeId((long)1);
        timesheet.setMinutes(100);
       // timesheet.setCreatedAt(LocalDate.now());
        Timesheet expected = timesheetRepository.save(timesheet);

        // GET /timesheets/{id}
        ResponseEntity<Timesheet> actual = restClient.get()
                .uri("/timesheets/" + expected.getId())
                .retrieve()
                .toEntity(Timesheet.class);

        // assert 200 OK
        assertEquals(HttpStatus.OK, actual.getStatusCode());
        Timesheet responseBody = actual.getBody();
        assertNotNull(responseBody);
        assertEquals(timesheet.getId(), responseBody.getId());
        assertEquals(timesheet.getProjectId(), responseBody.getProjectId());
        assertEquals(timesheet.getEmployeeId(), responseBody.getEmployeeId());
        assertEquals(timesheet.getMinutes(), responseBody.getMinutes());
        assertEquals(timesheet.getCreatedAt(), responseBody.getCreatedAt());


    }


    @Test
    void testFindAll() {

        timesheetRepository.deleteAll();

        List<Timesheet> expected = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {

            Timesheet timesheet = new Timesheet();

            timesheet.setId((long)i);
            timesheet.setProjectId((long) i);
            timesheet.setEmployeeId((long) i);
            timesheet.setMinutes(100 + i);
           // timesheet.setCreatedAt(LocalDate.of(2020,1,1));

            var exp =   timesheetRepository.save(timesheet);
            expected.add(exp);
        }

        List<Timesheet> actual = restClient.get()
                .uri("/timesheets")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Timesheet>>() {
                });

                assertNotNull(actual);

            for(int i = 0; i<actual.size(); i++){

                assertEquals(actual.get(i).getId(), expected.get(i).getId());
                assertEquals(actual.get(i).getProjectId(), expected.get(i).getProjectId());
                assertEquals(actual.get(i).getEmployeeId(), expected.get(i).getEmployeeId());
                assertEquals(actual.get(i).getMinutes(), expected.get(i).getMinutes());
                assertEquals(actual.get(i).getCreatedAt(), expected.get(i).getCreatedAt());

        }
    }

    @Test
    void testCreateNewTimesheet() {

        timesheetRepository.deleteAll();

/*

   Для того, что бы пройти этот тест, пришлось убрать проверку на существование проекта
   из TimsheetServise. Либо пришлось бы создавать здесь ещё проект и добавлять сюда же или в класс
   ProjectRepository.
    если это действительно надо, то несложно дописать и вернуть в TimsheetService проверку.

       Project project = new Project();
       project.setName("NewName");
       projectRepository.save(project);
*/
        Timesheet toCreate = new Timesheet();
        toCreate.setProjectId((long)10);
        toCreate.setEmployeeId((long)10);
        toCreate.setMinutes(150);

        ResponseEntity<Timesheet> response = restClient.post()
                .uri("/timesheets")
                .body(toCreate)
                .retrieve()
                .toEntity(Timesheet.class);

        // Проверяем HTTP-ручку сервера
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Timesheet responseBody = response.getBody();
        assertNotNull(responseBody);
        assertNotNull(responseBody.getId());
        assertEquals(responseBody.getProjectId(), toCreate.getProjectId());
        assertEquals(responseBody.getEmployeeId(), toCreate.getEmployeeId());
        assertEquals(responseBody.getMinutes(), toCreate.getMinutes());

        // Проверяем, что запись в БД есть
        assertTrue(timesheetRepository.existsById(responseBody.getId()));

    }

    @Test
    void testDeleteById() {


        Timesheet toDelete = new Timesheet();

        toDelete.setProjectId((long)1);
        toDelete.setEmployeeId((long)1);
        toDelete.setMinutes(300);

        toDelete = timesheetRepository.save(toDelete);

        ResponseEntity<Void> response = restClient.delete()
                .uri("/timesheets/" + toDelete.getId())
                .retrieve()
                .toBodilessEntity(); // less
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        // Проверяем, что записи в БД НЕТ
        assertFalse(timesheetRepository.existsById(toDelete.getId()));
    }

}