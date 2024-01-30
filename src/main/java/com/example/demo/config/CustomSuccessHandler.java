package com.example.demo.config;

import java.io.IOException;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



@Configuration
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response, Authentication authentication)
			throws IOException, javax.servlet.ServletException {
		
Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
		if(roles.contains("ROLE_ADMIN"))
		{
			response.sendRedirect("/admin/");
		}
		else if(roles.contains("ROLE_TEACHER"))
		{
			response.sendRedirect("/teacher/");
		}
		else
		{
			response.sendRedirect("/user/");
		}
		
		
		
	}
	


}
