package com.infinity.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {

    
    /**
     * Handle the main page
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"/"})
    public ModelAndView getHome() {



        ModelAndView mv = new ModelAndView("home");


        return mv;
    }
    

}
