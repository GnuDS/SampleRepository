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
	
		String user_id = (String) authentication.getPrincipal(); // ���̵� �ޱ�
		String user_pw = (String) authentication.getCredentials(); // ��й�ȣ �ޱ�
		
		CustomUserDetail customUserDetail = new CustomUserDetail();

        /*
        *     DB�۾� �� �α��ΰ� ���õ� ó���� �Ѵ�.
        *     ���� <form-login>�� default=target-url �Ӽ��� ��������� ���� ���� ����
        *     CustomUserDetail�� �������ϰ� �Ʒ����� CustomUserDetail�� ��ü�� set���ش�.
        */       

		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		// ���� �����ϱ� �ش� ���׿� �´� ������ �����Ͽ� �̿��Ѵ�.
		if(customUserDetail != null) {
			roles.add(new SimpleGrantedAuthority("IS_AUTHENTICATED_ANONYMOUSLY"));
		}else {
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		// ���̵�, ��й�ȣ, ����, customUserDetail �� ����
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user_id, user_pw, roles);
		result.setDetails(customUserDetail);
		
		return result;
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
