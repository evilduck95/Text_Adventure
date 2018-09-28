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

    @Bean
    public MessageChannel jsonInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel jsonRoutingChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel jsonLoggingChannel() {
        return new DirectChannel();
    }

}
