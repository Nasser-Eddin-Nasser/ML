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
        gen.writeStringField("type", value.getType().toString());
        gen.writeStringField("description", value.getDescription());
        gen.writeStringField("uploadDate", value.getUploadBy());
        gen.writeStringField("uploadBy", value.getAuthor());
        gen.writeStringField("author", value.getAuthor());
        gen.writeEndObject();
    }
}
