package com.textAdventure.Text_Adventure.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@ComponentScan
@EnableIntegration
@IntegrationComponentScan
public class MessageChannelConfiguration {

    // JSON Channels

    @Bean
    public MessageChannel jsonInput() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel jsonLogging() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel jsonToObject() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel jsonToAction() {
        return new DirectChannel();
    }

    // Object Channels

    @Bean
    public MessageChannel testItemChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel attributeChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel characterChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel monsterChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel playerChannel() {
        return new DirectChannel();
    }

}
