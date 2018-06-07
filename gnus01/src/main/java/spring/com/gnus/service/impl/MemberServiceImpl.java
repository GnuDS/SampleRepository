package spring.com.gnus.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import spring.com.gnus.dao.MemberDAO;
import spring.com.gnus.dto.MemberVO;
import spring.com.gnus.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO dao;
	
	@Override
	public List<MemberVO> selectMember() throws Exception {
		return dao.selectMember();
	}

}
