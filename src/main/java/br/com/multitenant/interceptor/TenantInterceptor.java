package br.com.multitenant.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Intercept request in search of X-TENANT header.
 */
@Slf4j
@Component
public class TenantInterceptor implements HandlerInterceptor {
    private static final String TENANT_HEADER = "X-TENANT";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Interceptando a requisicao: {}", request.getHeader(TENANT_HEADER));
        RequestContextHolder.getRequestAttributes().setAttribute("tenantId", request.getHeader(TENANT_HEADER), RequestAttributes.SCOPE_REQUEST);
        return true;
    }
}