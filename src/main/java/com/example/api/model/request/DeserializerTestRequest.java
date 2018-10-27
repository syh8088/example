package com.example.api.model.request;

import static com.fasterxml.jackson.core.JsonToken.START_ARRAY;
import static com.fasterxml.jackson.core.JsonToken.VALUE_STRING;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DeserializerTestRequest {
    @JsonDeserialize(using = TestDeserializer.class)
    private List<String> names;

    static class TestDeserializer extends JsonDeserializer<List<String>> {
        @Override
        public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonToken jt = p.getCurrentToken();
            if (jt == START_ARRAY) {
                return p.readValueAs(List.class);
            } else if (jt == VALUE_STRING) {
                return Arrays.asList(p.getValueAsString());
            }
            throw new UnsupportedOperationException("Cannot update object");
        }
    }
}
