package io.ensa.green_morocco.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.example.aopboot.Example.doSomeThing())")
    @Pointcut("execution(* io.ensa.green_morocco.service.*.get*(..))")
    public void loggingPointcut() { }

    @Around("loggingPointcut()")
    public Object afficherTrace( ProceedingJoinPoint joinpoint) throws Throwable {
        String nomMethode = joinpoint.getTarget().getClass().getSimpleName() + "."
                + joinpoint.getSignature().getName();
        Object obj =joinpoint.proceed();
        logger.info(nomMethode);
        return obj;
    }
}


