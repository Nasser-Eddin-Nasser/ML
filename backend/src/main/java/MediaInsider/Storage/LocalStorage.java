package MediaInsider.Storage;

import MediaInsider.Model.MediaObject;
import MediaInsider.Model.MediaType;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LocalStorage implements IStorage {
    private List<MediaObject> mediaObjectsList;

    public LocalStorage() {
        mediaObjectsList = new LinkedList<MediaObject>();
        this.insertDummy(10);
    }

    private void insertDummy(int count) {
        for (int i = 0; i < count; i++) {
            this.insertOrUpdate(new MediaObject(i, "name-" + i, MediaType.getRandom(), "description ", new Date(), "upload", "author-" + i));
        }
    }


    @Override
    public List<MediaObject> getMediaObjectByName(String name) {
        return mediaObjectsList.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public MediaObject getMediaObjectByID(long id) {
        return mediaObjectsList.stream().filter(x -> x.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<MediaObject> getMediaObjects() {
        return mediaObjectsList;
    }

    @Override
    public List<MediaObject> getMediaObjectsByAuthor(String author) {
        return mediaObjectsList.stream().filter(x -> x.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public List<MediaObject> getMediaObjectsByTyp(MediaType type) {
        return mediaObjectsList.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

    @Override
    public void deleteMediaObjectByID(long id) {
        if (isExist(id)) {
            mediaObjectsList.removeIf(x -> x.getId() == id);
        }
    }

    @Override
    public void deleteMediaObjectByName(String name) {
        if (isExist(name)) {
            mediaObjectsList.removeIf(x -> x.getName().equals(name));
        }
    }

    @Override
    public void insertOrUpdate(MediaObject mediaObject) {
        if (isExist(mediaObject)) {
            deleteMediaObjectByID(mediaObject.getId());
            insertOrUpdate(mediaObject);
        } else {
            mediaObjectsList.add(mediaObject);
        }

    }

    @Override
    public boolean isExist(long id) {
        boolean result = false;
        for (MediaObject mo : mediaObjectsList) {
            if (mo.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean isExist(String name) {
        boolean result = false;
        for (MediaObject mo : mediaObjectsList) {
            if (mo.getName().equals(name)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean isExist(MediaObject mediaObject) {
        boolean result = false;
        for (MediaObject mo : mediaObjectsList) {
            if (Objects.isNull(mo.getId())) {
                if (mo.getName() == mediaObject.getName()) {
                    result = true;
                    break;
                }
            } else if (mo.getId() == mediaObject.getId()) {
                result = true;
                break;
            }
        }
        return result;
    }
}
