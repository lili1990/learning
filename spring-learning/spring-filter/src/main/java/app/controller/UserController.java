package app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lili19289 on 2016/8/4.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value="/index",method = RequestMethod.GET)
    @ApiImplicitParam(name="user_token",paramType = "header")
    public String findUser(String name){
        return "success";
    }
}
