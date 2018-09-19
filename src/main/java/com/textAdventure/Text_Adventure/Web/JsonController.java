package com.textAdventure.Text_Adventure.Web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class JsonController {

    static final ObjectMapper jsonToObjectMapper = new ObjectMapper();

    @PostMapping(value = "/jsonIn")
    public void jsonInputChannel(@RequestHeader("type") String objectType, @RequestBody String objectBody) {

    }

}
