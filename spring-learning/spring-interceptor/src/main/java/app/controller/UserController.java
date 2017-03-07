package app.controller;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lili19289 on 2016/8/4.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value="/index",method = RequestMethod.GET)
    @ApiImplicitParam(name="user_token",paramType = "header")
    public String findUser(String name){
        return "html";
    }
}
