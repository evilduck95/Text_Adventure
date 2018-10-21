package com.textAdventure.Text_Adventure.Transformers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.transformer.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.io.IOException;

// Transforms payload to JsonNode.

@Configuration
public class JsonParseTransformer implements Transformer {

    @Override
    public Message<?> transform(Message<?> message) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode payloadJson = null;
        try {
            payloadJson = mapper.readTree(new String((byte[]) message.getPayload()));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return MessageBuilder
                .withPayload(payloadJson)
                .copyHeaders(message.getHeaders())
                .build();
    }

}
