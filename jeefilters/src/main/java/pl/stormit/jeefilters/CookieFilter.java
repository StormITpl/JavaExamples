package pl.stormit.jeefilters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

//@WebFilter(urlPatterns = "/*")
public class CookieFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

		Cookie cookie = Stream.of(Optional.ofNullable(request.getCookies()).orElse(new Cookie[]{}))
				.filter(c -> "counter".equals(c.getName()))
				.findAny()
				.orElse(new Cookie("counter", "0"));

		cookie.setValue(String.valueOf(Integer.parseInt(cookie.getValue()) + 1));

		response.addCookie(cookie);
		chain.doFilter(request, response);
	}
}
