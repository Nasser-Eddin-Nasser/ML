package MediaInsider.Storage;

import MediaInsider.Model.MediaObject;
import MediaInsider.Model.MediaType;
import MediaInsider.Model.SearchObject;
import MediaInsider.Storage.DB.IDBStorage;

import java.util.*;
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

            this.insertOrUpdate(new MediaObject(i, "Harry Portter-" + i, MediaType.getRandom(), "Harry Potter is a series of seven fantasy novels written by British author J. K. Rowling. The novels chronicle the lives of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley, all of whom are students at Hogwarts School of Witchcraft and Wizardry.", new Date(), "Novel ", "J. K. Rowling-" + i));
//            this.insertOrUpdate(new MediaObject(i, "name-" + i, MediaType.getRandom(), "Celebrating", new Date(), "upload", "author-" + i));
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
    public List<MediaObject> getMediaObjectsByOSearchObject(SearchObject object) {

        List<MediaObject> result = new ArrayList<MediaObject>(3);
        MediaObject mo1 = getMediaFromObject(object.getSearchKey1());
        if (!Objects.isNull(mo1.getId()))
            result.add(mo1);
        MediaObject mo2 = getMediaFromObject(object.getSearchKey2());
        if (!Objects.isNull(mo2.getId()) && mo2.getId() != mo1.getId())
            result.add(mo2);
        MediaObject mo3 = getMediaFromObject(object.getSearchKey3());
        if (!Objects.isNull(mo3.getId()) && (mo3.getId() != mo1.getId() && mo3.getId() != mo2.getId()))
            result.add(mo3);
        return result;
    }

    private MediaObject getMediaFromObject(Object sk) {
        MediaObject result = new MediaObject();
        if (sk instanceof Number) {
            long id = Long.parseLong(sk.toString());
            try {
                result = repo.findById(id).get();

            } catch (NoSuchElementException e) {
                //ignored
            }
        } else {
            result = repo.findByString(sk.toString()).get(0);
        }
        return result;
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
