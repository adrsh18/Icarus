package com.icaru.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*auth.xhtml")
public class SecurityCheck implements Filter {

public void init(FilterConfig filterConfig) throws ServletException {

}

@Override
public void doFilter(ServletRequest req, ServletResponse res,
    FilterChain chain) throws ServletException, IOException {

  HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession();
    System.out.println("Checking");
    if (session == null || session.getAttribute("loginUtil") == null) {
        response.sendRedirect(request.getContextPath() +"/login.xhtml"); // No logged-in user found, so redirect to login page.
    } else {
        chain.doFilter(req, res); // Logged-in user found, so just continue request.
    }

}

@Override
public void destroy() {
// Cleanup global variables if necessary.
}
}