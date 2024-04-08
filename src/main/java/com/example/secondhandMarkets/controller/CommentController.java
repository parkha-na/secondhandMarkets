package com.example.secondhandMarkets.controller;

import com.example.secondhandMarkets.service.CommentServiceImpl;
import com.example.secondhandMarkets.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {
	@Autowired
	CommentServiceImpl service;
	
	
	@RequestMapping("/insertComments.do")
	public String insertComments(CommentVo vo) {
		service.insertComments(vo);
		return "redirect:/";
	}
}
