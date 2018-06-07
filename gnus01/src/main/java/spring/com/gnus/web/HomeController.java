package spring.com.gnus.web;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.com.gnus.dto.MemberVO;
import spring.com.gnus.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		
		logger.info("home");
		
		List<MemberVO> memberList = service.selectMember();
		
		model.addAttribute("memberList", memberList);
		
		return "home";
	}
	
	
	
	/**
	 * Simply list
	 */
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request) {
		
//		PageMaker pageMaker = new PageMaker();
//
//		String pageNum = request.getParameter("pageNum");		// 페이지 값을 입력 받는다.
//		String contentNum = request.getParameter("contentNum");	// 한 페이지 보일 번호
//		System.out.println("컨텐츠 번호 : " + contentNum);
//		int cPageNum = Integer.parseInt(pageNum);
//		int cContentNum = Integer.parseInt(contentNum);
//		
//		// 페이지 객체에 새로운 정보 다시 지정해주는 부분
//		pageMaker.setTotalCount(100);				// 전체 게시글 개수
//		pageMaker.setPageNum(cPageNum-1);			// 현재 페이지를 페이지 객체에 다시 지정해준다, 몇번 페이지인지 PageMaker에 세팅한다
//		pageMaker.setContentNum(cContentNum);		// 한 페이지에 몇개씩 보여줄지 세팅한다
//		pageMaker.setCurrentBlock(cPageNum);		// 현재 페이지블록이 몇번인지 현재 페이지 번호를 통해서 지정한다
//		pageMaker.setLastBlock(pageMaker.getTotalCount()); // 마지막 블록 번호를 전체 게시글 수를 통해서 정한다
//
//		pageMaker.prevNext(cPageNum);//현재 페이지 번호로 화살표 나타낼지 결정한다
//        pageMaker.setStartPage(pageMaker.getCurrentBlock());//시작페이지 번호를 현재 페이지 블록으로 정한다
//        pageMaker.setEndPage(pageMaker.getLastBlock(),pageMaker.getCurrentBlock());
//        //현재 블록 번호와 마지막 블록 번호를 보내서 대조하고 페이지 블록의 마지막 번호를 지정한다
//        
//        List list = new ArrayList();//게시글 담을 리스트 선언
////        list = mapper.testlist(pageMaker.getPageNum()*10, pageMaker.getContentNum());//리스트에 저장
//        int i;
//        for(i=1;i<=10;i++) {
//        	list.add(i);
//        }
//        //매퍼로 한 페이지에 몇개 보일지 ,몇번 페이지 인지 전달//매퍼.xml 에서 사용하기 위해서 곱하기 10을 한다
// 
//        request.setAttribute("list", list);//sql로 얻은 리스트를 .jsp페이지로 전달
//        request.setAttribute("page", pageMaker);//페이지 번호 객체 .jsp페이지로 전달
		
		return "list";
	}
	
	
	
}
