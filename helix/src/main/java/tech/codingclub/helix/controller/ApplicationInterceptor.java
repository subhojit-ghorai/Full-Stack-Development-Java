package tech.codingclub.helix.controller;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

public class ApplicationInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(ApplicationInterceptor.class);

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        if (httpServletRequest.getRequestURI().startsWith("/admin")) {
            Boolean isAdmin = ControllerUtils.isUserAdmin(httpServletRequest);
            if (isAdmin != null && isAdmin) {
                return true;
            } else if (!httpServletRequest.getRequestURI().startsWith("/admin/login")) {
                httpServletResponse.sendRedirect("/admin/login");
                return false;
            }
        }
        if (httpServletRequest.getRequestURI().equals("/welcome")) {
            Boolean isUserLoggedIn = ControllerUtils.isUserCodingMafia(httpServletRequest);
            if (isUserLoggedIn != null && isUserLoggedIn) {
                return true;
            } else{
                httpServletResponse.sendRedirect("/login/welcome?failed=1");
                return false;
            }
        }

        if (httpServletRequest.getRequestURI().startsWith("/user")) {
            Boolean isUserLoggedIn = ControllerUtils.isUserCodingMafia(httpServletRequest);
            if (isUserLoggedIn != null && isUserLoggedIn) {
                return true;
            } else{
                if(httpServletRequest.getMethod().equals("GET"))
                {
                    httpServletResponse.sendRedirect("/login/welcome?failed=1");
                }
                else
                {
                    httpServletResponse.sendError(401);  // 401 means unauthorised access.
                }
                return false;
            }
        }

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView)
            throws Exception {
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception exception)
            throws Exception {
    }
}