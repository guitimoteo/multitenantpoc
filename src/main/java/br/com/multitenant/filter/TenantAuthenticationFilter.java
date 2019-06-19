package br.com.multitenant.filter;

/**
 * Authentication filter that requires tenant identifier to be passed with the request
 * and authenticates users based on their state and roles inside tenant.
 */
public class TenantAuthenticationFilter { /* extends BasicAuthenticationFilter {

	public static final String TENANT_HTTP_HEADER = "X-Tenant";

	public TenantAuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
		super(authenticationManager, authenticationEntryPoint);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String tenantId = request.getHeader(TENANT_HTTP_HEADER);
		// Authenticate user only if:
		//   1) Tenant identifier is passed via "X-Tenant" HTTP header
		//   2) There is no authenticated user in the security context
		return tenantId == null || SecurityContextHolder.getContext().getAuthentication() != null;
	}*/
}