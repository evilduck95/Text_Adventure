package com.textAdventure.Text_Adventure.Web.JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.textAdventure.Text_Adventure.Configuration.MongoConfiguration;
import com.textAdventure.Text_Adventure.Transformers.JsonParseTransformer;
import com.textAdventure.Text_Adventure.Transformers.JsonToObjectTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;


@Controller
@EnableMongoRepositories(basePackageClasses = MongoConfiguration.class)
public class JsonGateway {

    @Bean
    public IntegrationFlow jsonInputFlow(final JsonToObjectTransformer jsonToObjectTransformer,
                                         final JsonParseTransformer jsonParseTransformer,
                                         final MessageChannel jsonToObject) {
        return IntegrationFlows.from(Http.inboundGateway("/json"))
                .transform(jsonParseTransformer)
                .channel(jsonToObject)
                .get();
    }

    // TODO: MOVE TO JSON LOGGING
    private String getActionType(Message<?> message) {
        JsonNode messageJson = (JsonNode) message.getPayload();
        return messageJson.get("actionType").textValue();
    }

}
