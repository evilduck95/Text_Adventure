package com.textAdventure.Text_Adventure.Transformers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.transformer.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.io.IOException;

@Configuration
public class JsonParseTransformer implements Transformer {

    @Override
    public Message<?> transform(Message<?> message) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode payloadJson = mapper.readTree(new String((byte[]) message.getPayload()));
            return MessageBuilder
                    .withPayload(payloadJson)
                    .copyHeaders(message.getHeaders())
                    .build();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;    // TODO: Will we ever reach here???
    }

}
