package com.example.secondhandMarkets.controller;

import com.example.secondhandMarkets.service.UserServiceImpl;
import com.example.secondhandMarkets.session.SessionConst;
import com.example.secondhandMarkets.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserApiController {
	
	@Autowired
	private UserServiceImpl service;

    
    @Autowired
    private PasswordEncoder passwordEncoder;
	
    @RequestMapping("/loginCheck.do")
    public Map<String, Object> login(HttpServletRequest request, UserVo vo) {
		HttpSession session = request.getSession();
    	Map<String, Object> resultMap = new HashMap<>();
    	boolean loginCheck = false;
    	System.out.println("==> login.do 확인");
    	String password1 = vo.getPassword1();
    	UserVo loginUser = service.login(vo);
    	String originEncodePw = loginUser.getPassword2();
    	if (originEncodePw != null) {
    		if (passwordEncoder.matches(password1, originEncodePw)) {
    			session.setAttribute(SessionConst.LOGIN_USER, loginUser);
    			loginCheck = true;
    		}
    	}
    	resultMap.put("status", loginCheck);
    	
    	return resultMap;
    }
}