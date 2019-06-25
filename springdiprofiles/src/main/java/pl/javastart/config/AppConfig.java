package pl.javastart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.javastart.config.profile.DevProfile;
import pl.javastart.config.profile.ProdProfile;
import pl.javastart.config.profile.ProdProfile;
import pl.javastart.config.DatabaseSource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    @DevProfile
    public DatabaseSource getH2Datasource(){
        return (()-> Arrays.asList("KasiaTest","JolaTest","PawełTest"));
    }

    @Bean
    @Profile("default")
    public DatabaseSource getDefaultDatasource(){
        return (() -> Arrays.asList("KasiaDefault","JolaDefault","PawełDefault"));
    }

    @Bean
    @ProdProfile
    public DatabaseSource getMySQLDataSource(){
        return new DatabaseSource() {
            @Override
            public List<String> getDatabase() {
                try {
                    Path filePtah = new File(getClass().getResource("/data.txt").toURI()).toPath();
                    List<String> allLines = Files.readAllLines(filePtah);
                    return allLines;
                } catch (IOException| URISyntaxException e)
                {
                    e.printStackTrace();
                }
                return new ArrayList<>();
            }
        };
    }
}
