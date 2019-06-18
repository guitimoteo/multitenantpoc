package br.com.multitenant.filter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Authentication filter that does not require tenant identifier to be passed with the request
 * and authenticates users based on their global state and roles.
 */
public class GlobalAuthenticationFilter extends BasicAuthenticationFilter {

	GlobalAuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
		super(authenticationManager, authenticationEntryPoint);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		// Authenticate user only if:
		//   1) There is no authenticated user in the security context
		return SecurityContextHolder.getContext().getAuthentication() != null;
	}
}