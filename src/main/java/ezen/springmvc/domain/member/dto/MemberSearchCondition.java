package ezen.springmvc.domain.member.dto;

import lombok.Data;

/**
 * 검색 조건 저장
 */
@Data
public class MemberSearchCondition {
	private String memberId;
	private String name;
	private Integer age;
}
