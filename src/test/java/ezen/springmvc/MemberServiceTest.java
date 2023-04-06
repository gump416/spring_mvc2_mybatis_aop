package ezen.springmvc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ezen.springmvc.domain.member.dto.Member;
import ezen.springmvc.domain.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class MemberServiceTest {
	
	@Autowired
	MemberService memberService;
	
	@Test
	void getMembersTest() {
		List<Member> list = memberService.getMembers();
		log.info("전체목록 : {}", list);
	}
	
	@Test
	void getMemberTest() {
		Member member = memberService.getMember("bangry");
		log.info("회원상세 : {}", member);
	}
	

}
