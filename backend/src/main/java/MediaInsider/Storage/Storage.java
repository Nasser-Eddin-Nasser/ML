package MediaInsider.Storage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class Storage {
    @Bean
    @Scope("singleton")
    public  IStorage getStorage() {
        return new LocalStorage();
    }
}
