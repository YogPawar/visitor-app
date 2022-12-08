package com.yogsoft.visitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yogsoft.visitor.bean.Member;
import com.yogsoft.visitor.bean.Visitor;
import com.yogsoft.visitor.service.MemberService;
import com.yogsoft.visitor.service.VisitorService;

@Controller
@RequestMapping("/visitors/visit")
public class VisitorController {

	@Autowired
	MemberService memberService;

	@Autowired
	VisitorService visitorService;

	@GetMapping("/add")
	public String saveVisitor(Model model) {
		Visitor visitor = new Visitor();
		List<Member> member = memberService.getMembers();
		visitor.setMemberList(member);
		model.addAttribute("visitor", visitor);
		return "visitor-add";

	}

	@PostMapping("/save")
	public String save(@ModelAttribute("visitor") Visitor visitor) {
		visitorService.saveVisitor(visitor);
		return "redirect:/visitors/visit/list";
	}

	@GetMapping("/list")
	public String getVisitors(Model theModel) {
		List<Visitor> theVisitors = visitorService.getVisitors();
		theModel.addAttribute("visitors", theVisitors);
		return "visitor-list";
	}
	
	@GetMapping("/edit")
	public String updateVisitor(@RequestParam("visitorId") int visitorId, Model model) {
		Visitor visitor = visitorService.getVisitor(visitorId);
		List<Member> member = memberService.getMembers();
		visitor.setMemberList(member);
		model.addAttribute("visitor", visitor);
		return "visitor-add";

	}

	@GetMapping("/delete")
	public String deleteVisitor(@RequestParam("visitorId") int visitroId) {
		visitorService.deleteVisitor(visitroId);
		return "redirect:/visitors/visit/list";

	}


}
