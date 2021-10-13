package MediaInsider.Model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;


@Configuration
public class MediaObjectMapper {

    @Bean
    @ConditionalOnProperty(value = "spring.jackson.date-format", matchIfMissing = true, havingValue = "none")
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {

        return new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder builder) {
//                builder.simpleDateFormat(DATETIME_FORMAT);
//                builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT)));
                builder.deserializerByType(MediaObject.class, new ModelDeserializer());
                builder.serializerByType(MediaObject.class, new ModelSerializer());
            }
        };
    }

}
