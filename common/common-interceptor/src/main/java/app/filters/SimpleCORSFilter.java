package app.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lili990 on 17/3/7.
 * 允许跨域访问，现在后台服务器一般会使用nginx反向代理，因此nginx也需要配置跨域访问
 *
 * Spring较低的版本只能通过Filter实现跨域访问，高版本可以通过注解@CrossOrigin或者<mvc:cors></mvc:cors>标签来实现
 */
public class SimpleCORSFilter  implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     *
     *  web.xml配置
     *  <filter>
     *    <filter-name>cors</filter-name>
     *   <filter-class>app.interceptor.SimpleCORSFilter</filter-class>
     *  </filter>
     *  <filter-mapping>
     *    <filter-name>cors</filter-name>
     *    <url-pattern>/*</url-pattern>
     *  </filter-mapping>
     */

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        /**
         * “*”：表示设置允许所有的其他站点跨域请求该
         * “http:http://localhost:9000”：设置只允许指定站点访问该地址
         * ——授权控制
         */
        response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setHeader("Access-Control-Allow-Origin", "http://localhost:9000");
        //允许访问的方式，值得注意的是如果这里不设置OPTIONS，那么在web.xml的dispatchservlet的配置里面一定要设置OPTIONS为true，
        //不然仍然不可以实现跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        //允许接下来的60秒之内都可以支持该站点的跨域访问——授权时间
        response.setHeader("Access-Control-Max-Age", "60");
        //控制哪些header能发送真正的请求
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
