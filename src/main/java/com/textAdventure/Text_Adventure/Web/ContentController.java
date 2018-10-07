package com.textAdventure.Text_Adventure.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContentController {

    // This is the default format for getting some HTML using a template.
    @GetMapping(value = "/home")
    public String home(Model model,
                       @RequestParam(name = "name", required = false, defaultValue = "Keiran") String name) {
        model.addAttribute("name", name);
        return "home";
    }

}
