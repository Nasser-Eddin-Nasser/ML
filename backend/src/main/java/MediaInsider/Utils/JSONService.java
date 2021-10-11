package MediaInsider.Utils;

import MediaInsider.Model.SearchObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSONService {

    public static List<Object> toSearchObjects(Object jo) throws JSONException {
        List<Object> result = new ArrayList<Object>();
        JSONObject.testValidity(jo);
        String jsonString = JSONObject.valueToString(jo);
        JSONObject obj = new JSONObject(jsonString);
        Iterator<String> keys = obj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = obj.get(key);
            result.add(value);
        }
        return result;
    }

    public static SearchObject toSearchObjectsWithJackson(String searchQuery) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(searchQuery, SearchObject.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
