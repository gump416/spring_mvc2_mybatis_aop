package ezen.springmvc.web.member.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ezen.springmvc.domain.member.dto.Member;
import ezen.springmvc.domain.member.service.MemberService;


@Controller
@RequestMapping("/springmvc/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping
	public String members(Model model) {
		// 서비스 객체를 이용한 회원 목록
		List<Member> members = memberService.getMembers();
		model.addAttribute("members", members);
		return "member/list";
	}
	
	@GetMapping("/{userId}")
	public String view(@PathVariable String userId, Model model) {
		Member member = memberService.getMember(userId);
		model.addAttribute("member", member);
		return "member/view";
	}
}
