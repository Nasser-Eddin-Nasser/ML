package MediaInsider.Model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ModelDeserializer extends StdDeserializer<MediaObject> {

    public ModelDeserializer() {
        super(MediaObject.class);
    }

    final String DATETIME_FORMAT = "dd-MM-yyyy HH:mm";
    LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));

    @Override
    public MediaObject deserialize(JsonParser json, DeserializationContext context)
            throws IOException, JsonProcessingException {
        long id;
        String name;
        MediaType type;
        String description;
        Date uploadDate;
        String uploadBy;
        String author;

        TreeNode tn = json.readValueAsTree();
        if (tn.get("id") != null) {
            id = Long.parseLong(tn.get("id").toString());
        } else {
            id = 000;
        }
        if (tn.get("name") != null) {
            name = (tn.get("name").toString());
        } else {
            name = "";
        }
        if (tn.get("type") != null) {
            type = MediaType.forValue(tn.get("type").toString());
        } else {
            type = MediaType.Unknown;
        }
        if (tn.get("description") != null) {
            description = (tn.get("description").toString());
        } else {
            description = "";
        }
        if (tn.get("uploadDate") != null) {
            try {
                uploadDate = new SimpleDateFormat(DATETIME_FORMAT).parse(tn.get("uploadDate").toString());
            } catch (ParseException e) {
                // ignore
                uploadDate = new Date();
            }
        } else {
            uploadDate = new Date();
        }

        if (tn.get("uploadBy") != null) {
            uploadBy = (tn.get("uploadBy").toString());
        } else {
            uploadBy = "";
        }
        if (tn.get("author") != null) {
            author = (tn.get("author").toString());
        } else {
            author = "";
        }
        return new MediaObject(id, name, type, description, uploadDate, uploadBy, author);
    }

}