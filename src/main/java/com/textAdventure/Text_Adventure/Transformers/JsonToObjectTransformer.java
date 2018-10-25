package com.textAdventure.Text_Adventure.Transformers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.textAdventure.Text_Adventure.Entity.Character.Attribute;
import com.textAdventure.Text_Adventure.Entity.Character.Character;
import com.textAdventure.Text_Adventure.Entity.Character.Monster;
import com.textAdventure.Text_Adventure.TestItem;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

// Maps JSON to object using header.

@Component
public class JsonToObjectTransformer extends AbstractTransformer {

    @Override
    protected Message<Object> doTransform(final Message<?> message) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final Object parsedObject = mapper.readValue(
                message.getPayload().toString(),
                getClassFromHeader(message.getHeaders().get("object_type").toString()));

        System.out.printf("\nParsed: %s\n", parsedObject);

        return MessageBuilder
                .withPayload(parsedObject)
                .copyHeaders(message.getHeaders())
                .build();

    }

    private Class<?> getClassFromHeader(final String header) {
        switch (header.toUpperCase()) {
            case "TESTITEM":
                return TestItem.class;
            case "ATTRIBUTE":
                return Attribute.class;
            case "CHARACTER":
                return Character.class;
            case "MONSTER":
                return Monster.class;
            default:
                return null;
        }
    }

}
