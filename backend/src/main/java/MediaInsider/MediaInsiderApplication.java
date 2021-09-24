package MediaInsider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class MediaInsiderApplication {
    public static final boolean DB_Connection = true;
    public static final int Storage_Dummies_Number = 20;
    public static void main(String[] args) {
        SpringApplication.run(MediaInsiderApplication.class, args);
    }
}
