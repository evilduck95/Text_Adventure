package com.textAdventure.Text_Adventure.Web;

import org.springframework.context.annotation.Configuration;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

@Configuration
public class JsonHeaderFilter implements MessageSelector {

    @Override
    public boolean accept(Message<?> message) {

        return false;
    }
}
