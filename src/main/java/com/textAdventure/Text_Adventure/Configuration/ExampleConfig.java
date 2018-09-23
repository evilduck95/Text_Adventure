package com.textAdventure.Text_Adventure.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.io.File;

//@Configuration
//@EnableIntegration
public class ExampleConfig {
    private final String inputFile = "src/main/resources/in";
    private final String outputFile = "src/main/resources/out";

    @Bean
    public MessageChannel fileChannel() {
        return new DirectChannel();
    }

    @Bean
    @InboundChannelAdapter(value = "fileChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> fileReadingMessageSource() {
        FileReadingMessageSource sourceReader = new FileReadingMessageSource();
        sourceReader.setDirectory(new File(inputFile));
        sourceReader.setFilter(new SimplePatternFileListFilter("*.txt"));
        return sourceReader;
    }

    @Bean
    @ServiceActivator(inputChannel = "fileChannel")
    public MessageHandler fileWritingMessageHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File(outputFile));
        handler.setFileExistsMode(FileExistsMode.REPLACE_IF_MODIFIED);
        handler.setExpectReply(false);
        return handler;
    }


}
