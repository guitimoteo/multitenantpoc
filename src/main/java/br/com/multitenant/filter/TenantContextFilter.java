package br.com.multitenant.filter;

/*

import br.com.viavarejo.frete.marketplace.app.config.CurrentMongoConfigHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.model.TenantConfig;
import com.example.model.TenantMembership;
import com.example.repository.CurrentMongoConfigHolder;
import com.example.security.CurrentUser;
import com.example.security.InvalidTenantException;
*/

/**
 * HTTP request {@link  } that finds by id
 * if any specified in the X-Tenant HTTP header and stores it in the context holder.
 * 
 * Executes <b>after</b> {@code SpringSecurityFilterChain}.
 */
//@Component
public class TenantContextFilter /*extends OncePerRequestFilter */{

	public static final String TENANT_HTTP_HEADER = "X-Tenant";
/*
	@Override
	protected void doFilterInternal(HttpServletRequest request,
					HttpServletResponse response,
					FilterChain filterChain) throws ServletException, IOException {
		String targetTenantId = request.getHeader(TENANT_HTTP_HEADER);
		TenantConfig currentTenant = getCurrentTenant(targetTenantId);

		CurrentMongoConfigHolder.set(currentTenant);

		filterChain.doFilter(request, response);

		CurrentMongoConfigHolder.set(null);
	}

	private TenantConfiguration getCurrentTenant(String targetTenantId) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}

		CurrentUser user = (CurrentUser) authentication.getPrincipal();
		if (user == null) {
			return null;
		}

		TenantMembership currentTenantMembership = user.getCurrentTenantMembership();
		TenantConfig currentTenant = currentTenantMembership != null ? currentTenantMembership.getTenant() : null;

		if (!currentTenantIsAccessed(currentTenant, targetTenantId)) {
			throw new InvalidTenantException("User has no access to tenant[id=" + targetTenantId + "]");
		}

		return currentTenant;
	}

	private boolean currentTenantIsAccessed(TenantConfig currentTenant, String targetTenantId) {
		return currentTenant == null || (targetTenantId == null || targetTenantId.equals(currentTenant.getId()));
	} */
}
