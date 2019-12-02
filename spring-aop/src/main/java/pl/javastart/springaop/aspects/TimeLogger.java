package pl.javastart.springaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Aspect
@Component
public class TimeLogger {

    @Around("pl.javastart.springaop.aspects.AspectUtil.allBookRepositoryMethods()")
    public Object measureExecTime(ProceedingJoinPoint pjp )throws Throwable{
        Instant before = Instant.now();
        try{
            Object result = pjp.proceed();
            System.out.printf("Log before %s wit arguments: %s/n", pjp.getSignature(), Arrays.toString(pjp.getArgs()));
            return result;
        }finally {
            Instant after = Instant.now();
            Duration execTime = Duration.between(before, after);
            System.out.printf("%s execution took %d ms\n", pjp.toShortString(), execTime.toMillis());
        }
    }
}
