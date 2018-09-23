package com.textAdventure.Text_Adventure.Web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.textAdventure.Text_Adventure.Utils.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlowBuilder;
import org.springframework.integration.dsl.IntegrationFlowDefinition;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.router.HeaderValueRouter;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    static final ObjectMapper jsonToObjectMapper = new ObjectMapper();

    public MessageChannel testItemMapper;

    @PostMapping(value = "/jsonIn")
    @ResponseBody
    @InboundChannelAdapter
    public HeaderValueRouter jsonInputRouter(@RequestHeader("actionType") String objectType, @RequestBody Object inboundPayload) {
        Logger.info(objectType);
        IntegrationFlowBuilder jsonRouterFlow = IntegrationFlows.from("jsonInput");
        HeaderValueRouter router = new HeaderValueRouter("actionType");
        router.setChannelMapping("actionType", "testItemMapper");
        return router;
    }

    @Bean
    public IntegrationFlow testItemMapper() {
        return IntegrationFlowDefinition::log;  // TODO: Hmmmmmmmmmmmm....
    }


}
