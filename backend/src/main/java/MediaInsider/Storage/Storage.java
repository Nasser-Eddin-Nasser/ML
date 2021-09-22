package MediaInsider.Storage;

import MediaInsider.Storage.DB.IDBStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

import static MediaInsider.MediaInsiderApplication.DB_Connection;

@EnableJpaRepositories("IDBStorage")
public class Storage {
    @Bean
    @Scope("singleton")
    public IStorage getStorage(IDBStorage repo) {
        if (DB_Connection)
            return new DBStorage(repo);
        return new LocalStorage();
    }
}
