package com.textAdventure.Text_Adventure.Web.JSON;

import com.textAdventure.Text_Adventure.Transformers.JsonToObjectTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;

// Routes message based on objectType.

@Controller
public class JsonToObjectController {

    @Bean
    public IntegrationFlow jsonToObjectFlow(final MessageChannel jsonToObject,
                                            final JsonToObjectTransformer jsonToObjectTransformer) {
        return IntegrationFlows.from(jsonToObject)
                .transform(jsonToObjectTransformer)
                .<Message<Object>, String>route(objectMessage -> objectMessage.getHeaders().get("objectType", String.class),
                        objectRouterFlow ->
                                objectRouterFlow.channelMapping("testItem", "testItemChannel")
                                        .channelMapping("attribute", "attributeChannel")
                                        .channelMapping("character", "characterChannel")
                                        .channelMapping("monster", "monsterChannel")
                                        .channelMapping("player", "playerChannel")
                                        .resolutionRequired(true)).get();
    }
}
