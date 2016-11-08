package de.mvitz.spring.boot.thymeleaf.error;


import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class MyFilter implements Filter {

    public static final ThreadLocal<String> foo = new ThreadLocal<>();

    public static ThreadLocal<String> getFoo() {
        return foo;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            foo.set("foo");
            chain.doFilter(request, response);
        } finally {
            foo.remove();
        }
    }

    @Override
    public void destroy() {
    }
}
