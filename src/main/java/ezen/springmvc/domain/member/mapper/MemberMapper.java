package ezen.springmvc.domain.member.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ezen.springmvc.domain.member.dto.Member;
import ezen.springmvc.domain.member.dto.MemberSearchCondition;

//@Repository
@Mapper
public interface MemberMapper {
	public List<Member> findByAll();
	public Member findById(String id);
	public List<Member> findByAgeRange(@Param("begin") int begin, @Param("end") int end);
	public List<Member> findByNameLike(String name);
	public void create(Member member);
	public void update(Member member);
	
	// 검색 타입별 회원 검색
	public List<Member> findBySearchType(@Param("type") String type, @Param("value") String value);
	// 통합 검색
	public List<Member> findBySearchAll(String value);
	// 검색 옵션별 통합 검색
	public List<Member> findBySearchAllOption(MemberSearchCondition searchCondition);
}






