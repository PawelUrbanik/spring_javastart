package pl.javastart.springvalidatorcustomconstraits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javastart.springvalidatorcustomconstraits.model.Message;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class MessageService {

    private Validator validator;

    @Autowired
    public MessageService(Validator validator){
        this.validator= validator;
    }

    public boolean verifyMessage(Message message)
    {
        Set<ConstraintViolation<Message>> errors = validator.validate(message);
        if (!errors.isEmpty())
        {
            errors.forEach(err->System.out.println(err.getMessage()));
            return false;
        }
        else return true;
    }

}
