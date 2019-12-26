package pl.javastart.springmvcscopes.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.LinkedList;
import java.util.List;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartComponent {

    private List<String> products;

    public ShoppingCartComponent()
    {
        this.products = new LinkedList<>();
    }

    public List<String> getProducts() {
        return products;
    }

    public void addProduct(String product)
    {
        products.add(product);
    }

    @PostConstruct
    public void afterContruct(){
        System.out.println("Created: " + this);
    }

    @PreDestroy
    public void beforeDestroy(){

        System.out.println("Destroyed: " + this);
    }
}
