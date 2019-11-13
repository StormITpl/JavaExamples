package pl.stormit.jeefilters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns="/*")
public class AuthFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		if("admin".equals(req.getParameter("user"))
				&& "password".equals(req.getParameter("password"))
				&& req.getRequestURI().equals("/jeefilters/cities")){

			chain.doFilter(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}
	}
}
