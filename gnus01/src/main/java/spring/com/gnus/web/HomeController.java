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
//		String pageNum = request.getParameter("pageNum");		// ������ ���� �Է� �޴´�.
//		String contentNum = request.getParameter("contentNum");	// �� ������ ���� ��ȣ
//		System.out.println("������ ��ȣ : " + contentNum);
//		int cPageNum = Integer.parseInt(pageNum);
//		int cContentNum = Integer.parseInt(contentNum);
//		
//		// ������ ��ü�� ���ο� ���� �ٽ� �������ִ� �κ�
//		pageMaker.setTotalCount(100);				// ��ü �Խñ� ����
//		pageMaker.setPageNum(cPageNum-1);			// ���� �������� ������ ��ü�� �ٽ� �������ش�, ��� ���������� PageMaker�� �����Ѵ�
//		pageMaker.setContentNum(cContentNum);		// �� �������� ��� �������� �����Ѵ�
//		pageMaker.setCurrentBlock(cPageNum);		// ���� ����������� ������� ���� ������ ��ȣ�� ���ؼ� �����Ѵ�
//		pageMaker.setLastBlock(pageMaker.getTotalCount()); // ������ ��� ��ȣ�� ��ü �Խñ� ���� ���ؼ� ���Ѵ�
//
//		pageMaker.prevNext(cPageNum);//���� ������ ��ȣ�� ȭ��ǥ ��Ÿ���� �����Ѵ�
//        pageMaker.setStartPage(pageMaker.getCurrentBlock());//���������� ��ȣ�� ���� ������ ������� ���Ѵ�
//        pageMaker.setEndPage(pageMaker.getLastBlock(),pageMaker.getCurrentBlock());
//        //���� ��� ��ȣ�� ������ ��� ��ȣ�� ������ �����ϰ� ������ ����� ������ ��ȣ�� �����Ѵ�
//        
//        List list = new ArrayList();//�Խñ� ���� ����Ʈ ����
////        list = mapper.testlist(pageMaker.getPageNum()*10, pageMaker.getContentNum());//����Ʈ�� ����
//        int i;
//        for(i=1;i<=10;i++) {
//        	list.add(i);
//        }
//        //���۷� �� �������� � ������ ,��� ������ ���� ����//����.xml ���� ����ϱ� ���ؼ� ���ϱ� 10�� �Ѵ�
// 
//        request.setAttribute("list", list);//sql�� ���� ����Ʈ�� .jsp�������� ����
//        request.setAttribute("page", pageMaker);//������ ��ȣ ��ü .jsp�������� ����
		
		return "list";
	}
	
	
	
}
