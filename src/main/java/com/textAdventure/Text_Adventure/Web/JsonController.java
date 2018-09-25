package com.textAdventure.Text_Adventure.Web;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.http.dsl.Http;
import org.springframework.stereotype.Controller;


@Controller
public class JsonController {

    @Bean
    public IntegrationFlow jsonInputRouter() {
        return IntegrationFlows.from(Http.inboundGateway("/json")).log().channel("jsonInputChannel").get();
    }

    @Bean
    public IntegrationFlow testFlow() {
        return IntegrationFlows.from("jsonInputChannel").log(LoggingHandler.Level.INFO, m -> "Header: " + m.getHeaders()).get();
    }


}
