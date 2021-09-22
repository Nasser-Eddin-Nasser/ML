package MediaInsider.Storage;

import MediaInsider.Model.MediaObject;
import MediaInsider.Model.MediaType;
import MediaInsider.Storage.DB.IDBStorage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DBStorage implements IStorage {
    private IDBStorage repo;

    public DBStorage(IDBStorage repo) {
        this.repo = repo;
        insertDummy(10);
    }

    private void insertDummy(int count) {
        for (int i = 0; i < count; i++) {
            this.insertOrUpdate(new MediaObject("name-" + i, MediaType.getRandom(), "description ", new Date(), "upload", "author-" + i));
        }
    }

    @Override
    public List<MediaObject> getMediaObjectByName(String name) {
        return repo.getMediaByName(name);
    }

    @Override
    public MediaObject getMediaObjectByID(long id) {
        return repo.getById(id);
    }

    @Override
    public List<MediaObject> getMediaObjects() {
        return repo.findAll();
    }

    @Override
    public List<MediaObject> getMediaObjectsByAuthor(String author) {
        return repo.getMediaByName(author);
    }

    @Override
    public List<MediaObject> getMediaObjectsByTyp(MediaType type) {
        return repo.getMediaListByType(type);
    }

    @Override
    public void deleteMediaObjectByID(long id) {
        repo.deleteById(id);
    }

    @Override
    public void deleteMediaObjectByName(String name) {
        repo.deleteByName(name);
    }

    @Override
    public void insertOrUpdate(MediaObject mediaObject) {
        repo.saveAndFlush(mediaObject);
    }

    @Override
    public boolean isExist(long id) {
        return repo.existsById(id);
    }

    @Override
    public boolean isExist(String name) {
        return repo.existByName(name);
    }

    @Override
    public boolean isExist(MediaObject mediaObject) {
        return this.isExist(mediaObject.getId()) && this.isExist(mediaObject.getName());
    }
}
