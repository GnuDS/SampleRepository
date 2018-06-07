package spring.com.gnus.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.com.gnus.dao.MemberDAO;
import spring.com.gnus.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "spring.com.gnus.dao.MemberDAO";
	
	@Override
	public List<MemberVO> selectMember() throws Exception {
		return sqlSession.selectList(Namespace+".selectMember");
	}

}
