package com.textAdventure.Text_Adventure;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import static com.textAdventure.Text_Adventure.Utils.Logger.info;

public class DriverApp {

    public static void main(String... args) throws IOException {

        final ObjectMapper objectMapper = new ObjectMapper();

        final String testJson = "{\"num\":14, \"str\":\"keiran\"}";
        final TestItem testItem = objectMapper.readValue(testJson, TestItem.class);

        info(testItem);
        info("Hello, it'sa me, a'mario!");

    }
}
