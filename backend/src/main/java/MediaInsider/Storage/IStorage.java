package MediaInsider.Storage;

import MediaInsider.Model.MediaObject;
import MediaInsider.Model.MediaType;

import java.util.List;

public interface IStorage {
    public MediaObject getMediaObjectByName(String name);

    public MediaObject getMediaObjectByID(long id);

    public List<MediaObject> getMediaObjects();

    public List<MediaObject> getMediaObjectsByAuthor(String author);

    public List<MediaObject> getMediaObjectsByTyp(MediaType type);

    public void deleteMediaObjectByID(long id);

    public void deleteMediaObjectByName(String name);

    public void insertOrUpdate(MediaObject mediaObject);

    public boolean isExist(long id);

    public boolean isExist(String name);

    public boolean isExist(MediaObject mediaObject);
}
