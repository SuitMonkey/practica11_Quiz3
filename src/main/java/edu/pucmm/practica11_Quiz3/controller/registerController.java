package edu.pucmm.practica11_Quiz3.controller;


import edu.pucmm.practica11_Quiz3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class registerController {

    @Autowired
    private UserService userService;

    @RequestMapping("/Users")
    public ModelAndView register(Model model){

        model.addAttribute("accounts", userService.findAllUsers().size() + 1);
        model.addAttribute("users", userService.findAllUsers());

        return new ModelAndView("register");
    }

    @Secured("ADMIN")
    @PostMapping("/addNewUserAccount")
    public String addNewUser(@RequestParam("username") String username, @RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("pass") String pass){

        userService.createNewUserAccount(username, first, last, pass);

        return "redirect:/Users";
    }

}
