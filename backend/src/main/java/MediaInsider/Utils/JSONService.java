package MediaInsider.Utils;

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
//            System.out.println(value.getClass());
            result.add(value);
        }
        return result;
    }


}
