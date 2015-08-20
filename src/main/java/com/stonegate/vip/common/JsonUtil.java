package com.stonegate.vip.common;

import org.apache.commons.lang.time.FastDateFormat;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;

public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private JsonUtil() {
    }

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance(DATE_PATTERN);

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.CANONICALIZE_FIELD_NAMES, true);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleModule module = new SimpleModule("DateTimeModule", Version.unknownVersion());
        module.addSerializer(Timestamp.class, new JsonSerializer<Timestamp>() {
            @Override
            public void serialize(Timestamp date, JsonGenerator jsonGenerator, SerializerProvider provider)
                    throws IOException {
                jsonGenerator.writeString(date != null ? DATE_FORMAT.format(date) : "null");
            }
        });

        objectMapper.registerModule(module);
    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    public static String toString(Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            logger.error("JsonUtil.toString error", e);
            return null;
        }
    }

    public static <T> T parseJson(String json, Class<T> tClass) throws IOException {
        return objectMapper.readValue(json, tClass);
    }
}
