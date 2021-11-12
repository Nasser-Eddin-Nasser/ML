package MediaInsider.Model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public enum MediaType {
    CD, DVD, Book, EBook, Unknown;

    private static final MediaType[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static MediaType getRandom() {
        return (MediaType) VALUES[RANDOM.nextInt(SIZE)];
    }

    @JsonCreator
    public static MediaType forValue(String value) {
        Optional<MediaType> result = Arrays.stream(VALUES).filter(x -> x.toValue().equals(value.replaceAll("\"", ""))).findFirst();
        return result.isEmpty() ? MediaType.Unknown : result.get();
    }

    @JsonValue
    public String toValue() {
        for (MediaType type : VALUES) {
            if (type == this) {
                return type.toString();
            }
        }
        return MediaType.Unknown.toString(); // or fail
    }

}
