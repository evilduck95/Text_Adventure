package com.textAdventure.Text_Adventure.Web;

import com.textAdventure.Text_Adventure.Entity.Character.UserName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContentController {

    // This is the default format for getting some HTML using a template.
    @GetMapping(value = "/home")
    public String home(Model model,
                       @RequestParam(name = "name", required = false, defaultValue = "Keiran") String name) {
        model.addAttribute("name", name);
        return "home";
    }

    @RequestMapping(value = "/newName", method = RequestMethod.POST)
    public ResponseEntity<UserName> storeName(@RequestBody UserName userName) {
        System.out.println(String.format("New Username Received; %s", userName.getUserName()));
        return new ResponseEntity<UserName>(userName, HttpStatus.OK);
    }


}
