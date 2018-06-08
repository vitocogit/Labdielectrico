/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 
public class SimpleAuthenticationFilter implements Filter {
 
	private static final String TOKEN_PARAMETER_KEY = "token";
	private static final String TOKEN_CONFIG_KEY = "expectedToken";
	private String expectedToken;
 
	public void destroy() {
	}
 
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
 
		final String tokenFromRequest = request.getParameter(TOKEN_PARAMETER_KEY);
 
		if (expectedToken.equalsIgnoreCase(tokenFromRequest)) {
			chain.doFilter(request, response);
		} else {
			response.reset();
			response.getWriter().println("Error en la autentiación: token no presente");
			response.getWriter().flush();
			return;
		}
	}
 
	public void init(final FilterConfig config) throws ServletException {
		this.expectedToken = config.getInitParameter(TOKEN_CONFIG_KEY);
		System.out.println("Filtro " + config.getFilterName() + " configurado con token:" + this.expectedToken);
	}
 
}
