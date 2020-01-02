package email.verify.example.demo.controller;

import email.verify.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping("/registerPage")
    public String registerPage(){
        return "register";
    }

    @RequestMapping("/getCheckCode")
    public String getCheckCode(String email, HttpSession session){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为:" + checkCode;
        mailService.sendSimpleMail(email,"注册验证码",message);
        session.setAttribute(email,checkCode);
        return "register";
    }
}
