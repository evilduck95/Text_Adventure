package com.textAdventure.Text_Adventure.Web;

import com.fasterxml.jackson.databind.JsonNode;
import com.textAdventure.Text_Adventure.Utils.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
public class JsonHeaderFilter implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        Logger.info(message.getHeaders());
        JsonNode payloadJson = (JsonNode) message.getPayload();
        Logger.info(payloadJson.get("actionType"));
        switch (payloadJson.get("actionType").toString().replace("\"", "")) {
            case "testItem":
                System.out.println("TESTITEM FOUND");
                break;
            default:
                System.out.println("DEFAULT!");
                break;
        }
    }
}
