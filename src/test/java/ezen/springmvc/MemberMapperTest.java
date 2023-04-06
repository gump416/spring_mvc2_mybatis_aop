package ezen.springmvc;

import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ezen.springmvc.domain.member.dto.Member;
import ezen.springmvc.domain.member.dto.MemberSearchCondition;
import ezen.springmvc.domain.member.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	@Disabled
	void findByAllTest() {
		log.info("주입받은 프록시 객체: {}", memberMapper);
		List<Member> list = memberMapper.findByAll();
		log.info("전체목록 : {}", list);
	}
	
	@Test
	@Disabled
	void findByIdTest() {
		Member member = memberMapper.findById("bangry");
		log.info("회원 상세 : {}", member);
	}
	
	@Test
	@Disabled
	void findByAgeRangeTest() {
		List<Member> list = memberMapper.findByAgeRange(10, 20);
		log.info("나이 범위 회원 전체목록 : {}", list);
	}
	
	@Test
	@Disabled
	void findByNameLikeTest() {
		List<Member> list = memberMapper.findByNameLike("테스터");
		log.info("이름 와일드카드 검색 회원 전체목록 : {}", list);
	}
	
	@Test
	@Disabled
	void createTest() {
		Member member = new Member();
		member.setMemberId("son1");
		member.setPassword("1111");
		member.setName("손흥민1");
		member.setEmail("song1@gmail.com");
		member.setAge(10);
		memberMapper.create(member);
		log.info("회원 등록 완료 : {}", member);
	}
	
	@Test
	@Disabled
	void updateTest() {
		Member member = new Member();
		member.setMemberId("son");
		member.setAge(20);
		memberMapper.update(member);
		log.info("회원 수정 완료 : {}", member);
	}
	
	@Test
	@Disabled
	void findBySearchTypeTest() {
		//List<Member> list = memberMapper.findBySearchType("id", "bangry");
		List<Member> list = memberMapper.findBySearchType("name", "테스터");
		log.info("검색 타입별 검색 회원 전체목록 : {}", list);
	}
	
	@Test
	@Disabled
	void findBySearchAllTest() {
		List<Member> list = memberMapper.findBySearchAll("bangry");
		//List<Member> list = memberMapper.findBySearchAll("테스터");
		log.info("모든 검색 전체목록 : {}", list);
	}
	
	@Test
	//@Disabled
	void findBySearchAllOptionTest() {
		MemberSearchCondition searchCondition = new MemberSearchCondition();
		//searchCondition.setMemberId("bangry");
		searchCondition.setName("테스터");
		//searchCondition.setAge(20);		
		List<Member> list = memberMapper.findBySearchAllOption(searchCondition);
		log.info("검색 옵션별 전체목록 : {}", list);
	}
}










