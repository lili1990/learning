package app.controller;

import app.main.Configure;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.session.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lili19289 on 2016/8/4.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String addUser(HttpServletRequest request,@RequestParam("name") String name){
        HttpSession session = request.getSession();
//        String name = request.getParameter("name");
        session.setAttribute("user_token",name);
        System.out.println(session.getId());
        return "success";
    }


    @RequestMapping(value="/get",method = RequestMethod.GET)
    public String getUser(HttpServletRequest request, String name){
        HttpSession session = request.getSession();

        String user_token= (String) session.getAttribute("user_token");
        System.out.println(user_token);
        //为了证明启动了两个项目（自己copy一份，改掉端口启动）,，设置不同端口运行
        System.out.println(Configure.configuration.getProperty("http.port")+"----"+session.getId());
        return user_token;
    }
}
