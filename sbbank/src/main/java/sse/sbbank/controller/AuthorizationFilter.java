/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sse.sbbank.controller;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

/**
 *
 * @author Marco
 */
@WebFilter(filterName = "AuthorizationFilter", urlPatterns = { "/user/*"})
public class AuthorizationFilter implements Filter {

    public AuthorizationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession sess = req.getSession(false);
            if (sess.getAttribute("username")==null) {
                res.sendRedirect(req.getContextPath()+"/index.xhtml");               
           FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Test:  " + sess.getAttribute("username").toString(),
                            " " + sess.toString()));
            }
            
                //            String reqURI = req.getRequestURI();
                //            if (
                //                    reqURI.indexOf("/index.xhtml") >= 0
                //                    || (sess != null && sess.getAttribute("username") != null)
                //                    || reqURI.contains("javax.faces.resource"))
                //                    
                //                chain.doFilter(request, response);
                
            else
                    chain.doFilter(request, response);
             
                //res.sendRedirect(req.getContextPath() + "/index.xhtml");
            }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }

        @Override
        public void destroy() {
 
    }
}
