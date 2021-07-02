package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsExampleController {

    @GetMapping("/")
    public String index() {
        return "params/index";
    }

    @GetMapping("/string")
    public String params(@RequestParam(defaultValue = "algun valor...") String text, Model model) {
        model.addAttribute("text", text);
        return "params/show";
    }

    @GetMapping("/mix-params")
    public String params(@RequestParam() String text, @RequestParam() Integer number, Model model) {
        model.addAttribute("result", "Texto: " + text + ", Número: " + number);
        return "params/show";
    }

    @GetMapping("/mix-params-request")
    public String params(HttpServletRequest req, Model model) {
        String greting = req.getParameter("greting");
        Number number = 0;
        try {
            number = Integer.parseInt(req.getParameter("salude"));
        } catch (NumberFormatException e) {
            // passs.....
        }
        model.addAttribute("result", "Texto: " + greting + ", number: " + number);
        return "params/show";
    }

}
