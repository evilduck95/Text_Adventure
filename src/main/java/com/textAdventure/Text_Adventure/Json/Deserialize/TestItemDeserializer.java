package com.textAdventure.Text_Adventure.Json.Deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.textAdventure.Text_Adventure.TestItem;

import java.io.IOException;

public class TestItemDeserializer extends StdDeserializer<TestItem> {

    public TestItemDeserializer(Class<?> vc) {
        super(vc);
    }

    //TODO: Configure some sort of flow to use this? Or i'm doing it wrong, find out next week on 'JAVA @ HOME'!
    @Override
    public TestItem deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        int num = (Integer) ((IntNode) node.get("num")).numberValue();
        String str = node.get("str").asText();

        return new TestItem(num, str);
    }
}
