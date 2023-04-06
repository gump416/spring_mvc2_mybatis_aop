package ezen.springmvc.domain.member.dto;

import lombok.Data;

@Data
public class Member {
	private String memberId;
	private String password;
	private String name;
	private String email;
	private int age;
	private String regdate;
}