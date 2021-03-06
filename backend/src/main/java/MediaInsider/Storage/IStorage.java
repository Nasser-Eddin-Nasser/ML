package MediaInsider.Storage;

import MediaInsider.Model.MediaObject;
import MediaInsider.Model.MediaType;
import MediaInsider.Model.SearchObject;

import java.util.List;

public interface IStorage {
    public List<MediaObject> getMediaObjectByName(String name);

    public MediaObject getMediaObjectByID(long id);

    public List<MediaObject> getMediaObjects();

    public List<MediaObject> getMediaObjectsByObjectList(List<Object> objects);

    public List<MediaObject> getMediaObjectsByOSearchObject(SearchObject object);

    public List<MediaObject> getMediaObjectsByAuthor(String author);

    public List<MediaObject> getMediaObjectsByTyp(MediaType type);

    public void deleteMediaObjectByID(long id);

    public void deleteMediaObjectByName(String name);

    public void insertOrUpdate(MediaObject mediaObject);

    public boolean isExist(long id);

    public boolean isExist(String name);

    public boolean isExist(MediaObject mediaObject);
}
