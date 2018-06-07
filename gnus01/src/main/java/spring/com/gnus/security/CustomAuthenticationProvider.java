package spring.com.gnus.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@SuppressWarnings("unused")
	@Autowired
//	CustomService customService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	
		String user_id = (String) authentication.getPrincipal(); // 아이디 받기
		String user_pw = (String) authentication.getCredentials(); // 비밀번호 받기
		
		CustomUserDetail customUserDetail = new CustomUserDetail();

        /*
        *     DB작업 및 로그인과 관련된 처리를 한다.
        *     만약 <form-login>의 default=target-url 속성에 보내고싶은 값이 있을 때는
        *     CustomUserDetail에 세팅을하고 아래에서 CustomUserDetail의 객체를 set해준다.
        */       

		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		// 권한 설정하기 해당 사항에 맞는 권한을 선택하여 이용한다.
		if(customUserDetail != null) {
			roles.add(new SimpleGrantedAuthority("IS_AUTHENTICATED_ANONYMOUSLY"));
		}else {
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		// 아이디, 비밀번호, 권한, customUserDetail 값 세팅
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user_id, user_pw, roles);
		result.setDetails(customUserDetail);
		
		return result;
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
