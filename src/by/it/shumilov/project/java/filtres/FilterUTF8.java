package by.it.shumilov.project.java.filtres;

import javax.servlet.*;
import java.io.IOException;

public class FilterUTF8 implements Filter {
    private  String encode;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        String encoding = servletRequest.getCharacterEncoding();
        if(encoding == null || encoding.equalsIgnoreCase(encode)){
            servletRequest.setCharacterEncoding(encode);
        }

        encoding = response.getCharacterEncoding();
        if(encoding == null || encoding.equalsIgnoreCase(encode)){
            servletRequest.setCharacterEncoding(encode);
        }

        filterChain.doFilter(servletRequest,response);
    }

    @Override
    public void destroy() {

    }
}
