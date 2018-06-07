package spring.com.gnus.security;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.expression.ParseException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class CustomLoginController {

	@RequestMapping(value="/loginInvalidCheck")
	public String loginInvalidId(Model model, HttpSession session, HttpServletRequest request) {
		
		//customUserDetail�� set�� ���� getter�� ���� �������� �۾��� �����ϰ� ��
        CustomUserDetail userDetails = (CustomUserDetail)SecurityContextHolder.getContext().getAuthentication().getDetails();
        
        //�̷������� ���ǿ� ���� �־��ָ� ��Ʈ�ѷ����� ��밡��
        session.setAttribute("id", userDetails.getUser_id());
        session.setAttribute("auth", userDetails.getAuth());
        session.setAttribute("loginDate", userDetails.getLoginDate());
        
        return "goIndex";

	}
	
	@RequestMapping(value="/login")
	public String login(Model model, HttpServletRequest request) {
		
		return "login";
		
	}
	
	@RequestMapping(value="/login_duplicate")
	public String loginDuplicate(Model model, HttpServletRequest request) {
		
		return "loginDuplicate";
		
	}
	
	@RequestMapping(value="/logout")
	public String pageLogin(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "login";
		
	}
	
	@RequestMapping(value="/")
	public String Index(Locale locale, Model model, HttpServletRequest request) throws ParseException{
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		String loginDate = (String) session.getAttribute("loginDate");
				
		return "index";
		
	}
	
	
}
