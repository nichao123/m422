package com.nichao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "ChinaFilter",urlPatterns = "/*",initParams = {@WebInitParam(name="encoding",value="utf-8")})
public class ChinaFilter implements Filter {
    public ChinaFilter() {
        System.out.println("ChinaFilter 加载实例");
    }

    public void destroy() {
        System.out.println("ChinaFilter 销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("ChinaFilter 处理");

        //强制类型转换成有协议的对象
        HttpServletRequest  request = (HttpServletRequest) req;
        HttpServletResponse  response = (HttpServletResponse) resp;


        //设置编码
        request.setCharacterEncoding(encoding);

        //进行下一个过滤链!
        chain.doFilter(request, response);


    }

    String  encoding ="";
    public void init(FilterConfig config) throws ServletException {
        System.out.println("ChinaFilter 初始化");
        //获得参数值
        encoding = config.getInitParameter("encoding");
    }

}
