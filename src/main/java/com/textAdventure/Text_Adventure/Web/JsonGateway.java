package com.textAdventure.Text_Adventure.Web;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(name = "jsonGateway", defaultRequestChannel = "jsonInputChannel")
public interface JsonGateway {

    @Gateway
    void processJsonInput(Message message);

}
