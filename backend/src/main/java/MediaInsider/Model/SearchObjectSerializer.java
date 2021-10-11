package MediaInsider.Model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class SearchObjectSerializer extends StdSerializer<SearchObject> {
    protected SearchObjectSerializer(Class<SearchObject> t) {
        super(t);
    }

    @Override
    public void serialize(SearchObject value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObjectField("searchKey1", value.getSearchKey1());
        gen.writeObjectField("searchKey2", value.getSearchKey2());
        gen.writeObjectField("searchKey3", value.getSearchKey3());
    }
}
