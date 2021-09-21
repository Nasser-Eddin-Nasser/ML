package MediaInsider.Controller;

import MediaInsider.Model.MediaObject;
import MediaInsider.Storage.IStorage;
import MediaInsider.Storage.Storage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/controller")
@RestController
public class MediaController {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("scopes.xml");
    IStorage storage = ((Storage) applicationContext.getBean("getStorage")).getStorage();

    @CrossOrigin
    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<MediaObject>> getMediaList() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(storage.getMediaObjects());
    }

    @CrossOrigin
    @GetMapping("/name")
    @ResponseBody
    public ResponseEntity<MediaObject> getMediaObjectByName(@RequestParam("name") String name) {
        MediaObject result = storage.getMediaObjectByName(name);
        if (result != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @CrossOrigin
    @GetMapping("/id")
    @ResponseBody
    public ResponseEntity<MediaObject> getMediaObjectByID(@RequestParam("id") Long id) {
        MediaObject result = storage.getMediaObjectByID(id);
        if (result != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }

    @CrossOrigin
    @GetMapping("/exist/id")
    @ResponseBody
    public ResponseEntity<Boolean> isExistById(@RequestParam("id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(storage.isExist(id));
    }

    @CrossOrigin
    @GetMapping("/exist/name")
    @ResponseBody
    public ResponseEntity<Boolean> isExistByName(@RequestParam("name") String name) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(storage.isExist(name));
    }

    @PostMapping()
    public void insertNewMedia(@RequestBody MediaObject mo) {
        storage.insertOrUpdate(mo);
    }

    @DeleteMapping("/name")
    @ResponseBody
    public void deleteObjectByName(@RequestParam("name") String name) {
        storage.deleteMediaObjectByName(name);
    }

    @DeleteMapping("/id")
    @ResponseBody
    public void deleteMediaObjectByID(@RequestParam("id") Long id) {
        storage.deleteMediaObjectByID(id);
    }

}
