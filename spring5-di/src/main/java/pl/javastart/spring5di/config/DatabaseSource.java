package pl.javastart.spring5di.config;

import java.util.List;

public interface DatabaseSource {
    List<String> getDatabase();
}
