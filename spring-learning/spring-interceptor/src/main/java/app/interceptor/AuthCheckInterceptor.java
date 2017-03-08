package app.interceptor;

import app.main.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by lili19289 on 2017/3/7.
 */
public class AuthCheckInterceptor  implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handle) throws Exception {
        //这里是个简单的demo ，具体逻辑需要时再处理
        String user_token = httpServletRequest.getHeader("user_token");
        if(StringUtils.isEmpty(user_token)){
            ServletOutputStream os=null;
            try {
                os = httpServletResponse.getOutputStream();
                os.print("没有访问权限！");
            }catch (IOException e){
                Logger.error("权限校验异常："+e);
            }finally {
                os.close();
            }

            return false;
        }
        return true;
    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
