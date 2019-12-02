package pl.javastart.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import pl.javastart.springaop.model.Book;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Before("pl.javastart.springaop.aspects.AspectUtil.allBookRepositoryMethods())")
    public void logInfoBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        //System.out.printf("Log Before %s with args %s\n", joinPoint.getSignature(), Arrays.toString(args));
    }

    @After("pl.javastart.springaop.aspects.AspectUtil.allBookRepositoryMethods()")
    public void logInfoAfter(){
        System.out.println("Log After");
    }

    @AfterThrowing(pointcut = "pl.javastart.springaop.aspects.AspectUtil.allBookRepositoryMethods()",
    throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error)
    {
        System.out.printf("Method %s fifnished with error %s \n", joinPoint.getSignature(), error.getMessage());
    }


    @AfterReturning(pointcut = "execution(* pl.javastart.springaop.service.BookRepository.get(..)) && args(isbn)",
    returning = "result")
    public void logSucces(JoinPoint joinPoint, String isbn, Book result)
    {
        System.out.printf("Method get() succesfully returned value %s for isbn %s \n", result, isbn);
    }
}
