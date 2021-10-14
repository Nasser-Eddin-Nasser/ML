package MediaInsider.Model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ModelSerializer extends StdSerializer<MediaObject> {
    public ModelSerializer() {
        this(null);
    }

    public ModelSerializer(Class<MediaObject> t) {
        super(t);
    }

    @Override
    public void serialize(MediaObject value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("name", value.getName().replaceAll("\"", ""));
        gen.writeStringField("type", value.getType().toString());
        gen.writeStringField("description", value.getDescription().replaceAll("\"", ""));
        gen.writeStringField("uploadDate", value.getUploadDate().toString());
        gen.writeStringField("uploadBy", value.getUploadBy().replaceAll("\"", ""));
        gen.writeStringField("author", value.getAuthor().replaceAll("\"", ""));
        gen.writeEndObject();
    }
}
