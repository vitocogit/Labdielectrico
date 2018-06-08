package modelo;

import java.io.IOException; 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import beans.loginBeans;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
 
/**
 * Filter checks if LoginBean has loginIn property set to true.
 * If it is not set then request is being redirected to the login.xhml page.
 * 
 * @author itcuties
 *
 */
public class LoginFilter implements Filter {
  private static final org.slf4j.Logger LOGGER =
      LoggerFactory.getLogger(LoginFilter.class);

  public static final String LOGIN_PAGE = "/login.xhtml";

  @Override
  public void doFilter(ServletRequest servletRequest,
      ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {

    HttpServletRequest httpServletRequest =
        (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse =
        (HttpServletResponse) servletResponse;

    // managed bean name is exactly the session attribute name
    loginBeans userManager = (loginBeans) httpServletRequest
        .getSession().getAttribute(" loginBeans");

    if (userManager != null) {
      if (userManager.Logeado()) {
        LOGGER.debug("user is logged in");
        // user is logged in, continue request
        filterChain.doFilter(servletRequest, servletResponse);
      } else {
        LOGGER.debug("user is not logged in");
        // user is not logged in, redirect to login page
        httpServletResponse.sendRedirect(
            httpServletRequest.getContextPath() + LOGIN_PAGE);
      }
    } else {
      LOGGER.debug("userManager not found");
      // user is not logged in, redirect to login page
      httpServletResponse.sendRedirect(
          httpServletRequest.getContextPath() + LOGIN_PAGE);
    }
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
    LOGGER.debug("loginFilter initialized");
  }

  @Override
  public void destroy() {
    // close resources
  } 
  
     
}