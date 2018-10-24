package com.textAdventure.Text_Adventure.Web.JSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.textAdventure.Text_Adventure.Configuration.MongoConfiguration;
import com.textAdventure.Text_Adventure.Transformers.JsonParseTransformer;
import com.textAdventure.Text_Adventure.Transformers.JsonToObjectTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.integration.http.support.DefaultHttpHeaderMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;

import java.util.Map;


@Controller
@EnableMongoRepositories(basePackageClasses = MongoConfiguration.class)
public class JsonGateway {

    @Bean
    public IntegrationFlow jsonInputFlow(final JsonToObjectTransformer jsonToObjectTransformer,
                                         final JsonParseTransformer jsonParseTransformer,
                                         final MessageChannel jsonToObject) {
        final String[] names = new String[1];
        names[0] = "*";
        DefaultHttpHeaderMapper headerMapper = new DefaultHttpHeaderMapper();
        headerMapper.setInboundHeaderNames(names);
        return IntegrationFlows.from(Http.inboundGateway("/json").headerMapper(headerMapper))
                .transform(jsonParseTransformer)
                .channel(jsonToObject)
                .get();
    }

    // TODO: MOVE TO JSON LOGGING
    private String getActionType(Message<?> message) {
        JsonNode messageJson = (JsonNode) message.getPayload();
        return messageJson.get("actionType").textValue();
    }

    private static class JsonHeaderMapper extends DefaultHttpHeaderMapper {

        @Override
        public Map<String, Object> toHeaders(HttpHeaders source) {
            return super.toHeaders(source);
        }
    }

}
