package com.textAdventure.Text_Adventure.Web;

import com.textAdventure.Text_Adventure.Transformers.JsonParseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;


@Controller
public class JsonController {

    @Autowired
    private JsonParseTransformer jsonParseTransformer;

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

    //TODO: SOME ROUTING
    @Bean
    public IntegrationFlow jsonRoutingFlow() {
        return IntegrationFlows.from(jsonRoutingChannel);
    }


}
