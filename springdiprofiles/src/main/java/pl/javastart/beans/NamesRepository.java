package pl.javastart.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.javastart.config.DatabaseSource;
import pl.javastart.config.profile.DevProfile;

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
