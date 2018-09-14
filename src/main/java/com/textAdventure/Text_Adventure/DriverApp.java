package com.textAdventure.Text_Adventure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.textAdventure.Text_Adventure.Utils.Logger;

import java.io.IOException;

public class DriverApp {

    public static void main(String... args) throws IOException {

        final ObjectMapper objectMapper = new ObjectMapper();

        final String testJson = "{\"num\":14, \"str\":\"keiran\"}";
        final TestItem testItem = objectMapper.readValue(testJson, TestItem.class);

        Logger.info(testItem);
        Logger.info("Hello, it'sa me, a'mario!");

    }
}
