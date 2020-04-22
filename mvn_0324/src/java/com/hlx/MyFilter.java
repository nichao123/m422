package com.hlx;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    public MyFilter() {
        System.out.println("加载实例=>MyFilter->0");
    }

    public void destroy() {
        System.out.println("过滤结束=>MyFilter->3");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        System.out.println("过滤处理=>MyFilter->2");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤开始=>MyFilter->1");
    }

}
