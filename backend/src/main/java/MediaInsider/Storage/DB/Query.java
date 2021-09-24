package MediaInsider.Storage.DB;

public class Query {
    public static final String getMediaByName =
            "SELECT * FROM media WHERE name = ?1";

    public static final String getMediaListByAuthor =
            "SELECT * FROM media WHERE author = ?1";

    public static final String getMediaListByType =
            "SELECT * FROM media WHERE type = ?1";

    public static final String deleteByName = "DELETE FROM media WHERE name= ?1";

    public static final String existsByName = "SELECT EXISTS(SELECT * FROM media where name=?1)";

    public static final String findByString = "SELECT * FROM media where name LIKE %?1% OR type LIKE %?1% OR description LIKE %?1% OR author LIKE %?1%";

}


//    OR type LIKE %?1% OR description LIKE %?1% OR author LIKE %?1%)