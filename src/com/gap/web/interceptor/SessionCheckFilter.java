package com.gap.web.interceptor;

import java.io.IOException;    
import java.util.HashSet;    
import java.util.Set;    
import javax.servlet.Filter;    
import javax.servlet.FilterChain;    
import javax.servlet.FilterConfig;    
import javax.servlet.ServletException;    
import javax.servlet.ServletRequest;    
import javax.servlet.ServletResponse;    
import javax.servlet.http.HttpServletRequest;    
import javax.servlet.http.HttpServletResponse;    
import javax.servlet.http.HttpSession;    
/**  
 * 用于检测用户是否登陆的过滤器，如果未登录，则重定向到指的登录页面 配置参数 checkSessionKey 需检查的在 Session 中保存的关键字  
 * redirectURL 如果用户未登录，则重定向到指定的页面，URL不包括 ContextPath notCheckURLList  
 * 不做检查的URL列表，以分号分开，并且 URL 中不包括 ContextPath  
 */    
public class SessionCheckFilter implements Filter {    
	  protected FilterConfig filterConfig = null;    
	  private String redirectURL = null;    
	  private Set<String> notCheckURLList = new HashSet<String>();    
	  private String sessionKey = null;    
	  @Override    
	  public void destroy() {    
	    notCheckURLList.clear();    
	  }    
	  @Override    
	  public void doFilter(ServletRequest servletRequest,    
	      ServletResponse servletResponse, FilterChain filterChain)    
	      throws IOException, ServletException {    
	    HttpServletRequest request = (HttpServletRequest) servletRequest;    
	    HttpServletResponse response = (HttpServletResponse) servletResponse;    
	    HttpSession session = request.getSession();    
	    if (sessionKey == null) {    
	      filterChain.doFilter(request, response);    
	      return;    
	    }    
	    if ((!checkRequestURIIntNotFilterList(request))    
	        && session.getAttribute("users") == null) {    
	         response.sendRedirect(request.getContextPath() + redirectURL);    
	      return;    
	    }    
	    filterChain.doFilter(servletRequest, servletResponse);    
	  }    
	  private boolean checkRequestURIIntNotFilterList(HttpServletRequest request) {    
	    String uri = request.getServletPath()    
	        + (request.getPathInfo() == null ? "" : request.getPathInfo());    
	    String temp = request.getRequestURI();  
	    temp = temp.substring(request.getContextPath().length() + 1);    
	    // System.out.println("是否包括："+uri+";"+notCheckURLList+"=="+notCheckURLList.contains(uri));    
	    return notCheckURLList.contains(uri);    
	  }    
	  @Override    
	  public void init(FilterConfig filterConfig) throws ServletException {    
	    this.filterConfig = filterConfig;    
	    redirectURL = filterConfig.getInitParameter("redirectURL");    
	    sessionKey = filterConfig.getInitParameter("checkSessionKey");    
	    String notCheckURLListStr = filterConfig    
	        .getInitParameter("notCheckURLList");    
	    if (notCheckURLListStr != null) {    
	      System.out.println(notCheckURLListStr);    
	      String[] params = notCheckURLListStr.split(",");    
	      for (int i = 0; i < params.length; i++) {    
	        notCheckURLList.add(params[i].trim());    
	      }    
	    }    
	  }    
}  
