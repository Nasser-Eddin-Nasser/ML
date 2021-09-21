package MediaInsider;

import MediaInsider.Model.MediaObject;
import MediaInsider.Model.MediaType;
import MediaInsider.Storage.IStorage;
import MediaInsider.Storage.LocalStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@SpringBootApplication
public class MediaInsiderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MediaInsiderApplication.class, args);
    }
}
