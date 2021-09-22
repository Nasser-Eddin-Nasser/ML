package MediaInsider.Storage.DB;

import MediaInsider.Model.MediaObject;
import MediaInsider.Model.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static MediaInsider.Storage.DB.Query.*;

@Repository
public interface IDBStorage extends JpaRepository<MediaObject, Long> {
    MediaObject getById(Long id);

    List<MediaObject> findAll();

    @Query(value = getMediaByName, nativeQuery = true)
    List<MediaObject> getMediaByName(String name);

    MediaObject saveAndFlush(MediaObject mo);

    @Query(value = getMediaListByAuthor, nativeQuery = true)
    List<MediaObject> getMediaListByAuthor(String name);

    @Query(value = getMediaListByType, nativeQuery = true)
    List<MediaObject> getMediaListByType(MediaType mediaType);

    @Override
    void deleteById(Long id);

    @Query(value = deleteByName, nativeQuery = true)
    void deleteByName(String name);

    @Override
    boolean existsById(Long id);

    @Query(value = existsByName, nativeQuery = true)
    boolean existByName(String name);

}
