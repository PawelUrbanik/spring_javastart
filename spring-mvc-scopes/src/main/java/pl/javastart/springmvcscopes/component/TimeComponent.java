package pl.javastart.springmvcscopes.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TimeComponent {

    private Long time;

    public TimeComponent() {
        this.time = System.currentTimeMillis();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @PostConstruct
    public void afterCreated(){
        System.out.println("Created: " + this);
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Destroyed: " + this);
    }
}
