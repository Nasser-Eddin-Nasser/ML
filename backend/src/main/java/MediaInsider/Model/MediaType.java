package MediaInsider.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MediaType {
    CD,DVD,Book,EBook,Unknown;

      private static final MediaType[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    public static MediaType getRandom()  {
        return  (MediaType) VALUES[RANDOM.nextInt(SIZE)];
    }

}
