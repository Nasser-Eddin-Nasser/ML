package MediaInsider.Storage;

import MediaInsider.Model.MediaObject;
import MediaInsider.Model.MediaType;
import MediaInsider.Storage.DB.IDBStorage;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static MediaInsider.MediaInsiderApplication.Storage_Dummies_Number;


public class DBStorage implements IStorage {
    private IDBStorage repo;

    public DBStorage(IDBStorage repo) {
        this.repo = repo;
        insertDummy(Storage_Dummies_Number);
    }

    private void insertDummy(int count) {
        for (int i = 0; i < count; i++) {
//            this.insertOrUpdate(new MediaObject(i, "name-" + i, MediaType.getRandom(), "Celebrating anniversary paragraphs we copy. Thank god daily for text from you paste long text to super copy and long paragraphs to super user name of the blood in? From seesaw account and long text to copy paste them; your writing in! Can log in prison with paste text. You hear your store data is very startling conclusion to skate around me prove useful for? Wake me and paste it ", new Date(), "upload", "author-" + i));
            this.insertOrUpdate(new MediaObject(i, "name-" + i, MediaType.getRandom(), "Celebrating", new Date(), "upload", "author-" + i));
        }
    }

    @Override
    public List<MediaObject> getMediaObjectByName(String name) {
        return repo.getMediaByName(name);
    }

    @Override
    public MediaObject getMediaObjectByID(long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<MediaObject> getMediaObjects() {
        return repo.findAll();
    }

    @Override
    public List<MediaObject> getMediaObjectsByObjectList(List<Object> objects) {
        LinkedHashSet<MediaObject> result = new LinkedHashSet<MediaObject>();
        for (Object item : objects) {
            if (item instanceof Number) {
                long id = Long.parseLong(item.toString());
                try {
                    MediaObject mo = repo.findById(id).get();
                    if (mo != null) result.add(mo);
                } catch (NoSuchElementException e) {
                    //ignored
                }
            } else {
                result.addAll(repo.findByString(item.toString()));
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    @Override
    public List<MediaObject> getMediaObjectsByAuthor(String author) {
        return repo.getMediaByName(author);
    }

    @Override
    public List<MediaObject> getMediaObjectsByTyp(MediaType type) {
        return repo.getMediaListByType(type.toString());
    }

    @Override
    public void deleteMediaObjectByID(long id) {
        if (isExist(id)) repo.deleteById(id);
    }

    @Override
    public void deleteMediaObjectByName(String name) {
        if (isExist(name))
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
