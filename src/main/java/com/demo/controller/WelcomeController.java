package com.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap modelMap){
        modelMap.put("name", getUserName(modelMap));
        return "welcome";
    }

    private String getUserName(ModelMap modelMap) {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }

    /*@RequestMapping(value = "/login2", method = RequestMethod.POST)
    public String handleRequests(@RequestParam String username,@RequestParam String password,
                                 ModelMap modelMap){
        if(!service.isValidUser(username,password)){
            modelMap.put("errorMessage","Invalid Credentials! Please try again");
            return "login";
        }
        modelMap.put("name",username);
        modelMap.put("password",password);
        return "welcome";
    }*/
}
