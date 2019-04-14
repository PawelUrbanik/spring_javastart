package pl.javastart.beans.producers;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

public interface MessageProducer {

    public String getMessage();
}
