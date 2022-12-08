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
import com.yogsoft.visitor.service.MemberService;

@Controller
@RequestMapping("/visitors/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/save")
	public String saveMember(@ModelAttribute("member") Member theMember) {
		memberService.saveMember(theMember);

		return "redirect:/visitors/member/list";

	}

	@GetMapping("/add")
	public String saveMember(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);

		return "member-add";

	}

	@GetMapping("/list")
	public String getMember(Model theModel) {
		List<Member> theMembers = memberService.getMembers();
		theModel.addAttribute("members", theMembers);
		return "member-list";
	}

	@GetMapping("/edit")
	public String updateMember(@RequestParam("memberId") int memberId, Model model) {
		Member member = memberService.getMember(memberId);
		model.addAttribute("member", member);
		return "member-add";

	}

	@GetMapping("/delete")
	public String deleteMember(@RequestParam("memberId") int memberId) {

		memberService.deleteMember(memberId);
		return "redirect:/visitors/member/list";

	}

}
