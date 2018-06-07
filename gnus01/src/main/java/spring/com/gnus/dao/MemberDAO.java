package spring.com.gnus.dao;

import java.util.List;

import spring.com.gnus.dto.MemberVO;

public interface MemberDAO {

	public List<MemberVO> selectMember() throws Exception;
}
