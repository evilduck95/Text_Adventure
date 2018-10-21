package com.textAdventure.Text_Adventure.Transformers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

// Maps JSON to object using header.

public class JsonToObjectTransformer extends AbstractTransformer {

    @Override
    protected Message<Object> doTransform(Message<?> message) throws Exception {
        Class<?> objectType = Class.forName(message.getHeaders().get("objectType").toString());
        String objectJson = ((JsonNode) message.getPayload()).asText();
        ObjectMapper mapper = new ObjectMapper();
        Object parsedObject = mapper.readValue(objectJson, objectType);

        return MessageBuilder
                .withPayload(parsedObject)
                .copyHeaders(message.getHeaders())
                .build();

    }
}
