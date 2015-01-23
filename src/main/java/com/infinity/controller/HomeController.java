package com.infinity.controller;



import com.infinity.data.jpa.domain.Code;
import com.infinity.data.jpa.domain.Users;
import com.infinity.data.jpa.service.CodeRepository;

import com.infinity.data.jpa.service.UsersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {

    
    
@Autowired
private UsersRepository services;

@Autowired
private CodeRepository codeService;


    /**
     * Handle the main page
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"/index"})
    public ModelAndView getHome() {


   
    Iterable<Code> findAllCode = codeService.findAll();
        ModelAndView mv = new ModelAndView("home");
   
        mv.addObject("code",findAllCode);

        return mv;
    }    
}
