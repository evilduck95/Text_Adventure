package com.textAdventure.Text_Adventure.Web;

import com.fasterxml.jackson.databind.JsonNode;
import com.textAdventure.Text_Adventure.Transformers.JsonParseTransformer;
import com.textAdventure.Text_Adventure.Utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;


@Controller
public class JsonController {

    @Autowired
    private JsonParseTransformer jsonParseTransformer;

    @Autowired
    private JsonHeaderFilter jsonHeaderFilter;

    @Autowired
    private MessageChannel jsonInputChannel;

    @Autowired
    private MessageChannel jsonRoutingChannel;

    @Bean
    public IntegrationFlow jsonInputFlow() {
        return IntegrationFlows.from(Http.inboundGateway("/json"))
                .channel(jsonInputChannel)
                .get();
    }

    @Bean
    public IntegrationFlow jsonParseFlow() {
        return IntegrationFlows.from(jsonInputChannel)
                .transform(jsonParseTransformer)
                .channel(jsonRoutingChannel)
                .get();
    }

    @Bean
    public IntegrationFlow jsonRoutingFlow() {
        return IntegrationFlows.from(jsonRoutingChannel)
                .filter(Message.class, m -> getActionType(m).equals("testItem"))
                .handle(m -> Logger.info("Filter Passed!"))
                .get();
    }

    private String getActionType(Message<?> message) {
        JsonNode messageJson = (JsonNode) message.getPayload();
        Logger.info(messageJson.get("actionType").textValue());
        return messageJson.get("actionType").textValue();
    }

}
