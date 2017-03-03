package app.controller;

import app.models.User;
import app.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by lili19289 on 2016/12/23.
 */
@RestController
@RequestMapping(value="/users")
public class UserController {


    @Resource
    private UserService userService;


    @ApiOperation(value="创建用户", notes="根据User对象save用户")
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String saveUser(@ModelAttribute User user)throws Exception {
        userService.save(user.getUser_name(),user.getAge());
        return "success";
    }

    @ApiOperation(value="创建用户", notes="根据User对象create用户")
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String createUser(@ModelAttribute User user) throws Exception{
        userService.create(user.getUser_name(),user.getAge());
        return "success";
    }

    @ApiOperation(value="创建用户", notes="根据User对象add用户")
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String addUser(@ModelAttribute User user)throws Exception {
        userService.add(user.getUser_name(),user.getAge());
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.get(id);
    }



}
