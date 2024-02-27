package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.gbVo.GbVo;
import com.javaex.service.GbService;

@Controller
@RequestMapping(value = "/guest")
public class GbController {
	
	@Autowired
	private GbService gbService; 
	
	@RequestMapping(value = "addlist", method = {RequestMethod.GET, RequestMethod.POST})
	public String addlist(Model model) {//리스트폼
		
		List<GbVo> gList = gbService.gbList();
		
		model.addAttribute("gList", gList);
		
		return "addList";
	}
	
	@RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GbVo gv) {//추가
		
		gbService.gbInsert(gv);
		
		return "redirect:/guest/addlist";
	}
	
	@RequestMapping(value = "deleteform", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@RequestParam("no")int no, Model model) {//삭제폼
		
		model.addAttribute("no", no);
		
		return "deleteForm";
	}
	
	@RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no")int no, @RequestParam("password")String pw) {//삭제
		
		gbService.gbDelete(no, pw);
		
		return "redirect:/guest/addlist";
	}
	
}
