package pl.javastart.beans.producers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fileMessageProducer")
public class FileMessageProducer implements MessageProducer {
    public String getMessage() {
        return  "File message prooducer: " +System.currentTimeMillis();
    }
}
