package cn.wc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyInterceptor implements HandlerInterceptor {
    //在请求处理方法之前执行
    //如果返回true那么执行下一个拦截器，如果false那么不执行下一个拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("----处理前-----");

        String url = request.getRequestURI();
        // URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        // 注意：一些静态文件不能拦截，否则会死循环，知道内存耗尽
        if (url.indexOf("login") >= 0) {
            return true;
        }
        // 获取Session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username != null) {
            return true;
        }
        // 不符合条件的，跳转到登录界面
        // request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        response.sendRedirect("/wc/login");

        return false;
    }
    //在请求处理方法之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("-----处理后------");
    }
    //在DispatchServlet处理后执行--------清理工作
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
