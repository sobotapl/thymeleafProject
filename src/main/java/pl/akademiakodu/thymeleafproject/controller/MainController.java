package pl.akademiakodu.thymeleafproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("name", "Zosia");
        return "index";
    }

    @GetMapping("/{name}")
    public String index(@PathVariable String name, ModelMap modelMap){
        log.info("User with name={} clicked on index", name);
        modelMap.addAttribute("name", name);
        return "index";
    }


    @GetMapping("/bookadd")
    public String addbook(){
        return "bookadd";
    }

}
