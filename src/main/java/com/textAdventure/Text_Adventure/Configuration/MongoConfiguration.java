package com.textAdventure.Text_Adventure.Configuration;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }


    @Override
    protected String getDatabaseName() { // FIXME: 07/10/2018 
        return "TextAdventure";
    }
}
