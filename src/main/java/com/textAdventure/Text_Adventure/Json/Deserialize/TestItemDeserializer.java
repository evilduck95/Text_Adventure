package com.textAdventure.Text_Adventure.Json.Deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.textAdventure.Text_Adventure.TestItem;

import java.io.IOException;

public class TestItemDeserializer extends JsonDeserializer<TestItem> {

    //TODO: Configure some sort of flow to use this? Or i'm doing it wrong, find out next week on 'JAVA @ HOME'!
    @Override
    public TestItem deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode node = objectCodec.readTree(jsonParser);

        System.out.println(String.format("Deserializing JSON: %s", node.toString()));

        final int num = node.get("num").asInt();
        final String str = node.get("str").asText();

        return new TestItem(num, str);
    }
}
