package spring.com.gnus.service;

import java.util.List;

import spring.com.gnus.dto.MemberVO;

public interface MemberService {
	
	public List<MemberVO> selectMember() throws Exception;
	
}
