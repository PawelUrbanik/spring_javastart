package pl.javastart.springaop.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectUtil {

    @Pointcut("execution(* pl.javastart.springaop.service.BookRepository.*(..))")
    public void allBookRepositoryMethods() {};
}
