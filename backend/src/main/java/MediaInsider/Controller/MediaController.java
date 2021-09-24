package MediaInsider.Controller;

import MediaInsider.Model.MediaObject;
import MediaInsider.Model.MediaType;
import MediaInsider.Storage.DB.IDBStorage;
import MediaInsider.Storage.IStorage;
import MediaInsider.Storage.Storage;
import MediaInsider.Utils.JSONService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@CrossOrigin
@RequestMapping("media")
@RestController
public class MediaController {
    @Autowired
    private IDBStorage repo;
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("scopes.xml");
    IStorage storage;

    @PostConstruct
    private void setRepo() {
        storage = ((Storage) applicationContext.getBean("getStorage")).getStorage(repo);
    }


    @GetMapping()
    public ResponseEntity<List<MediaObject>> getMediaList() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(storage.getMediaObjects());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<MediaObject>> getMediaObjectByName(@PathVariable("name") String name) {
        List<MediaObject> result = storage.getMediaObjectByName(name);
        if (result != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MediaObject> getMediaObjectByID(@PathVariable("id") String id) {
        MediaObject result = storage.getMediaObjectByID(Long.parseLong(id));
        if (result != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<MediaObject>> getMediaObjectsByTyp(@PathVariable("type") MediaType type) {
        List<MediaObject> result = storage.getMediaObjectsByTyp(type);
        if (result != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @GetMapping("/exist/id/{id}")
    public ResponseEntity<Boolean> isExistById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(storage.isExist(id));
    }

    @GetMapping("/exist/name/{name}")
    public ResponseEntity<Boolean> isExistByName(@PathVariable("name") String name) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(storage.isExist(name));
    }

    @PostMapping()
    public ResponseEntity<List<MediaObject>> insertNewMedia(@RequestBody MediaObject mo) {
        storage.insertOrUpdate(mo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(storage.getMediaObjects());
    }


    @PostMapping("/find")
    public ResponseEntity<List<MediaObject>> findInMedia(@RequestBody Object searchQuery) {
        List<Object> searchObjects = JSONService.toSearchObjects(searchQuery);
        List<MediaObject> result = storage.getMediaObjectsByObjectList(searchObjects);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }


    @DeleteMapping("/name/{name}")
    public void deleteObjectByName(@PathVariable("name") String name) {
        storage.deleteMediaObjectByName(name);
    }

    @DeleteMapping("/id/{id}")
    public void deleteMediaObjectByID(@PathVariable("id") Long id) {
        storage.deleteMediaObjectByID(id);
    }

}
