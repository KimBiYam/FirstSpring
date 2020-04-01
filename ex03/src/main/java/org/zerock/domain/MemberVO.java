package org.zerock.domain;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	private String userid;
	private String userpw;
	private String username;
	private String addr;
	private String zipNo;
	private boolean enabled;	
	private String regDate;
	private String updateDate;
	private List<AuthVO> authList;
	
}
