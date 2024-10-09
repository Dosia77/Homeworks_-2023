package ru.gb.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ru.gb.service.TimesheetService;

import java.lang.reflect.Method;

@Aspect
@Component
public class RecoverAspect {

    // TimesheetService service;

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.
            log4j.LogManager.getLogger(Recover.class);

    @Pointcut("@annotation(ru.gb.aspect.Recover)") // method
    public void recoverMethodsPointcut() {}



    @Around(value = "recoverMethodsPointcut()")
    public Object aroundTimesheetServiceMethods(ProceedingJoinPoint pjp)throws Throwable {

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Object target = pjp.getTarget();
        Method method = methodSignature.getMethod();

        try {
            return pjp.proceed();
        } catch (Throwable e) {
            log.info("TimesheetService#  {} {}",  e.getMessage(), e.getClass());
            // Я не очень поняла куда он это должен вернуть? два метода, что возвращают это findAll
            // и indById там, в любом случае, возвращает страницу 404. Либо надо делать специально страницу.
            // Где там можно вернуть null?
         return  method.getDefaultValue();

        }
    }

}
