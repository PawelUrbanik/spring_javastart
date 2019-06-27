package pl.javastart.spring5di.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.javastart.spring5di.config.DatabaseSource;

import java.util.List;

@Component
public class NamesRepository {

    private DatabaseSource ds;

    @Autowired
    public NamesRepository(DatabaseSource ds)
    {
        this.ds = ds;
    }

    public List<String> getAll(){
        return ds.getDatabase();
    }
}
