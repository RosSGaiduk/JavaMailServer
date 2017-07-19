package com.emailsender.ua.controllers;

import com.emailsender.ua.EmailSenderAPI;
import com.emailsender.ua.EmailSenderTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rostyslav on 15.07.2017.
 */
@Controller
public class BaseController {
    private final String crunchifyConfFile = "emailSenderBean.xml";
    private ConfigurableApplicationContext context;
    private EmailSenderAPI emailSenderAPI;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "views-base-home";
    }

    @RequestMapping(value = "/sendEmailExample", method = RequestMethod.GET)
    public String sendEmail() {
        context = new ClassPathXmlApplicationContext(crunchifyConfFile);
        emailSenderAPI = (EmailSenderAPI) context.getBean("crunchifyEmail");
        EmailSenderTest.sendEmail(emailSenderAPI,"b.sahaiko@gmail.com","subject","body");
        return "redirect:/";
    }


    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    public String sendEmailPost(HttpServletRequest request){
        String emailTo = request.getParameter("emailTo");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");

        context = new ClassPathXmlApplicationContext(crunchifyConfFile);
        emailSenderAPI = (EmailSenderAPI) context.getBean("crunchifyEmail");
        EmailSenderTest.sendEmail(emailSenderAPI,emailTo,subject,body);
        return "redirect:/";
    }

}
