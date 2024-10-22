package ru.gb.aspect.recover;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class RecoverAspect {

  /*
  оно не работает. Только finally  показыает, что программа его видит,
  но в чем его работа заключается  не понятно. Я пыталась...
   */

    private final RecoverProperties properties;

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.
            log4j.LogManager.getLogger(Recover.class);

    public RecoverAspect(RecoverProperties properties) {
        this.properties = properties;
    }

    @Pointcut("@annotation(ru.gb.aspect.recover.Recover)") // method
    public void recoverMethodsPointcut() {}



    @Around(value = "recoverMethodsPointcut()")
    public Object aroundTimesheetServiceMethods(ProceedingJoinPoint pjp) throws Throwable{

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
       // Object target = pjp.getTarget();
        Method method = methodSignature.getMethod();

        try {
            return pjp.proceed();
        } catch (Throwable e) {

           log.atLevel(properties.getLevel()).log("TimesheetService#  {} {}",  e.getMessage(), e.getClass());
         return  method.getDefaultValue();

        }
//        finally {
//            log.atLevel(properties.getLevel()).log("TimesheetService#  {} ",  method.getGenericReturnType());
//        }

    }

}
