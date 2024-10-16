package ru.gb.aspect.logging;

//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Slf4j // Slf4j - Simple logging facade for java
@Aspect
//@RequiredArgsConstructor
public class LoggingAspect {

  private static final org.apache.logging.log4j.Logger log = org.apache.logging.
          log4j.LogManager.getLogger(LoggingAspect.class);

  private final LoggingProperties properties;

    public LoggingAspect(LoggingProperties properties) {

      this.properties = properties;
    }

    @Pointcut("@annotation(ru.gb.aspect.logging.Logging)") // method
  public void loggingMethodsPointcut() {}

  @Pointcut("@within(ru.gb.aspect.logging.Logging)") // class
  public void loggingTypePointcut() {}

  @Around(value = "loggingMethodsPointcut() || loggingTypePointcut()")
  public Object loggingMethod(ProceedingJoinPoint pjp) throws Throwable {
    String methodName = pjp.getSignature().getName();
    log.atLevel(properties.getLevel()).log("Before -> TimesheetService#{}", methodName);
    if(properties.isPrintArgs()){
      log.atLevel(properties.getLevel()).log("Before -> TimesheetService#{}", methodName);
    }
   // log.atLevel(properties.getLevel()).log("Before -> TimesheetService#{}", methodName);

    try {
     return pjp.proceed();
    } finally {
      log.atLevel(properties.getLevel()).log("After -> TimesheetService#{}", methodName);
     if(properties.isPrintArgs()){
        log.atLevel(properties.getLevel()).log("Before -> TimesheetService# {} = {}",  pjp.getArgs()[0].getClass(), pjp.getArgs()[0]);
     }
    }
  }

}
