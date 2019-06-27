package pl.javastart.springaop.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before("execution(* pl.javastart.springaop.service.BookRepository.*(..))")
    public void logInfoBefore() {
        System.out.println("Log Before");
    }

    @After("execution(* pl.javastart.springaop.service.BookRepository.*(..))")
    public void logInfoAfter(){
        System.out.println("Log After");
    }

    @AfterThrowing("execution(* pl.javastart.springaop.service.BookRepository.*(..))")
    public void afterThrowing()
    {
        System.out.println("After  Throwing");
    }

    @AfterReturning("execution(* pl.javastart.springaop.service.BookRepository.*(..))")
    public void afterReturning(){
        System.out.println("After Returning");
    }
}
