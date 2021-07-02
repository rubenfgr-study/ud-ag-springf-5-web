package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vars")
public class ExampleVarsPathController {

    @GetMapping({ "/", "" })
    public String index(Model model) {
        return "vars/index";
    }

    @GetMapping("/string/{text}")
    public String vars(@PathVariable String text, Model model) {
        model.addAttribute("text", text);
        return "/vars/show";
    }

    @GetMapping("/string/{text}/{number}")
    public String mixvars(@PathVariable String text, @PathVariable Integer number, Model model) {
        model.addAttribute("text", text);
        model.addAttribute("number", number);
        return "/vars/show";
    }

}
