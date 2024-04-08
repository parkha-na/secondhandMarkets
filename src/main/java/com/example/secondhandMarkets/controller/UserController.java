package com.example.secondhandMarkets.controller;

import com.example.secondhandMarkets.service.UserServiceImpl;
import com.example.secondhandMarkets.vo.UserVo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
    private UserServiceImpl service;

    
    @Autowired
    private PasswordEncoder passwordEncoder;
	
    public UserController() {
      System.out.println("==> LoginController생성자확인!! ");	
    }

    @RequestMapping("/login.do")
    public String loginPage() {
    	System.out.println("==> login.do 확인");
    	return "login";
    }
    
    @GetMapping("/logout.do")
    public String logoutPage(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    
    @RequestMapping("/signup.do")
    public String signup() {
    	System.out.println("==> signup.do 확인");
    	//model.addAttribute("msno", service.form(vo)) ;
    	return "signup";
    }
    
    @RequestMapping("/signupOk.do")
    public String signupOk(UserVo vo) {
    	System.out.println("==> signup.do 확인");
    	//model.addAttribute("msno", service.form(vo)) ;
    	String password1 = vo.getPassword1();
    	String encodePw = passwordEncoder.encode(password1);
    	vo.setPassword2(encodePw);
    	service.insert(vo);
    	
    	return "redirect:/";
    }
}