package com.textAdventure.Text_Adventure.Web;

import com.fasterxml.jackson.databind.JsonNode;
import com.textAdventure.Text_Adventure.Configuration.MongoConfiguration;
import com.textAdventure.Text_Adventure.TestItem;
import com.textAdventure.Text_Adventure.Transformers.JsonParseTransformer;
import com.textAdventure.Text_Adventure.Utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@EnableMongoRepositories(basePackageClasses = MongoConfiguration.class)
public class JsonController {

    @Autowired
    private MongoOperations mongoOperations;

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

        mongoOperations.save(new TestItem(4, "kek"));
        mongoOperations.save(new TestItem(123, "omg it works!"), "testItemCollection");
        List<TestItem> testItemList = mongoOperations.findAll(TestItem.class);

        testItemList.forEach(testItem -> Logger.info("Found: " + testItem.toString()));

        return IntegrationFlows.from(jsonRoutingChannel)
                .route(Message.class, this::getActionType, routerSpec -> routerSpec
                        .resolutionRequired(true)
                        .subFlowMapping("testItem", testItemFlow -> testItemFlow.handle(this::logMessage))
                        .subFlowMapping("secondTestItem", secondItemFlow -> secondItemFlow.channel("nowhere yet")))
                .get();

//        return IntegrationFlows.from(jsonRoutingChannel)
//                .wireTap(f -> f
//                        .filter(Message.class, m -> getActionType(m).equals("testItem"))
//                        .handle(m -> Logger.info("First Filter Passed!")))
//                .wireTap(f -> f
//                        .filter(Message.class, m -> getActionType(m).equals("secondTestItem"))
//                        .handle(m -> Logger.info("Second Filter Passed!")))
//                .get();
    }

    public void logMessage(Message<?> message) {
        System.out.println("Handler Reached!");
    }


    private String getActionType(Message<?> message) {
        JsonNode messageJson = (JsonNode) message.getPayload();
        return messageJson.get("actionType").textValue();
    }

}
