package com.example.secondhandMarkets.controller;

import com.example.secondhandMarkets.service.BoardServiceImpl;
import com.example.secondhandMarkets.service.CommentServiceImpl;
import com.example.secondhandMarkets.vo.BoardVo;
import com.example.secondhandMarkets.vo.CommentVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {


	@Autowired
	BoardServiceImpl service;

	@Autowired
	CommentServiceImpl cService;

	@RequestMapping("/form.do")
	public String form(Model model, BoardVo vo, HttpServletRequest request) {
		System.out.println("==> form.do 확인");

		String id = request.getParameter("id");
		request.getSession().setAttribute("id", id);
		model.addAttribute("msno", service.form(vo));
		return "form";
	}

	@RequestMapping("/formOk.do")
	public String formOk(BoardVo vo) {
		service.insert(vo);

		return "redirect:select.do";
	}

	@RequestMapping("/select.do")
	public List<BoardVo> select(Model model, BoardVo vo) {
		System.out.println("==> select.do 확인");
		model.addAttribute("li", service.select(vo));

		return service.select(vo);
	}

	@RequestMapping("/edit.do")
	public String edit(Model model, BoardVo vo, @RequestParam int sno) {
		model.addAttribute("m", service.content(vo));
		return "edit";
	}

	@RequestMapping("/detail.do")
	public String detail(Model model, BoardVo vo, CommentVo cVo, @RequestParam int sno) {
		model.addAttribute("m", service.content(vo));
		List<CommentVo> comList = cService.commentList(cVo);
		model.addAttribute("comList", comList);
		model.addAttribute("cnt", cService.commentCount(cVo));

		return "detail";
	}

	@RequestMapping("/updateOk.do")
	public String updateOk(BoardVo vo) {
		service.update(vo);

		return "redirect:select.do";
	}

	@RequestMapping("/del.do")
	public String delOk(BoardVo vo) {
		service.delete(vo);
		return "redirect:select.do";
	}

	@RequestMapping("/deleteComments.do")
	public String deleteComments(CommentVo vo) {
		cService.deleteComments(vo);
		return "redirect:/";
	}

}