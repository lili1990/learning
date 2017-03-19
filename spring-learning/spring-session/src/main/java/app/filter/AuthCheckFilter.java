package app.filter;

import app.service.UserService;
import app.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by lili1990 on 17/3/6.
 */
public class AuthCheckFilter implements Filter {


//    @Resource //不生效
    private UserService userService;

    public void init(FilterConfig filterConfig) throws ServletException {
       //获取容器上下文，可以进行对Bean的操作
        ServletContext context = filterConfig.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        userService = (UserServiceImpl)ctx.getBean(UserServiceImpl.class);


    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String user_token = request.getHeader("user_token");
        String methodString=request.getMethod();
        //这个判断只是简单的说明，通过init方法我们可以获取bean对象来进行验证操作
        if(!userService.findOne(user_token)){
            response.setContentType("application/json; charset=utf-8");
            String jsonString="{\"status\":\"false\",\"info\":\"用户未登陆或超时\"}";
            OutputStream os = response.getOutputStream();
            os.write(jsonString.getBytes());
            os.close();
        }
        //这里是个简单的demo ，具体逻辑需要时再处理
        if(StringUtils.isEmpty(user_token)){
            response.setContentType("application/json; charset=utf-8");
            String jsonString="{\"status\":\"false\",\"info\":\"用户未登陆或超时\"}";
            OutputStream os = response.getOutputStream();
            os.write(jsonString.getBytes());
            os.close();
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    public void destroy() {

    }
}
