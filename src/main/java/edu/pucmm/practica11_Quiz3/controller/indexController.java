package edu.pucmm.practica11_Quiz3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class indexController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }

    @RequestMapping("/free")
    public String pruebaI18n(Model model,
                             Locale locale/*,
                             @RequestParam(value="nombre",required=false,defaultValue="Mundo") String nombre*/){
        System.out.println("Holaaaaaa desde el controlador");

        model.addAttribute("saludos", messageSource.getMessage("saludos", null, locale));
        model.addAttribute("Mensaje", messageSource.getMessage("Mensaje", null, locale));

        return "/freemarker/index";
    }

}
