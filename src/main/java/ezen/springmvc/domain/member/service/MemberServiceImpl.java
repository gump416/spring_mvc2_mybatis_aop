package ezen.springmvc.domain.member.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ezen.springmvc.domain.member.dto.Member;
import ezen.springmvc.domain.member.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * 회원 관련 비즈니스 메소드 구현
 */
@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;

	/** 회원 전체 목록 반환 */
	@Override
	public List<Member> getMembers() {
		return memberMapper.findByAll();
	}
	
	/** 회원 상세 정보 반환 */
	@Override
	public Member getMember(String id) {
		return memberMapper.findById(id);
	}
}
