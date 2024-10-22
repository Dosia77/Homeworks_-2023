package ru.gb.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;
import ru.gb.client.ProjectResponse;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ProjectPageService {

    private final DiscoveryClient discoveryClient;

    public ProjectPageService(DiscoveryClient discoveryClient) {

        this.discoveryClient = discoveryClient;
    }

    private RestClient restClient() {
        List<ServiceInstance> instances = discoveryClient.getInstances("TIMESHEET-REST");
        int instancesCount = instances.size();
        int instanceIndex = ThreadLocalRandom.current().nextInt(0, instancesCount);

        ServiceInstance instance = instances.get(instanceIndex);
        String uri = "http://" + instance.getHost() + ":" + instance.getPort();
        System.out.println("URI = " + uri);
        return RestClient.create(uri);
    }

    public List<ProjectResponse> findAll() {
        List<ProjectResponse> projects = null;
        int attempts = 5;
        while (attempts-- > 0) {
            try {
                projects = restClient().get()
                        .uri("/projects")
                        .retrieve()
                        .body(new ParameterizedTypeReference<List<ProjectResponse>>() {
                        });
                break;
            } catch (HttpServerErrorException e) {
                // ignore
            }
        }
        if (projects == null) {
            throw new RuntimeException("oops");
        }

        return projects;
    }

    public Optional<ProjectResponse> findById(Long id) {
        try {
            ProjectResponse project = restClient().get()
                    .uri("/projects/" + id)
                    .retrieve()
                    .body(ProjectResponse.class);

            assert project != null;
            return Optional.of(project);

        } catch (HttpClientErrorException.NotFound e) {
            return Optional.empty();
        }
    }

}
