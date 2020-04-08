package com.myapp.securitys;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class CsrfSecurityRequestMatcher implements RequestMatcher {
	private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
//	�ش� url���� csrf�� ������� ����
	private RegexRequestMatcher unprotectedMatcher = new RegexRequestMatcher("/member/popup", null) ;
		
	@Override
	public boolean matches(HttpServletRequest request) {
		// TODO Auto-generated method stub
		if (allowedMethods.matcher(request.getMethod()).matches()) {
			return false;
		}
		return !unprotectedMatcher.matches(request);
	}

}
