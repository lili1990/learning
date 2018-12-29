package app.controller;

import app.models.User;
import app.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by lili19289 on 2016/12/23.
 */
@RestController
@RequestMapping(value="/users")
public class UserController {


    @Resource
    private UserService userService;

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public List<User> getUserList(@ApiParam(value = "页数", required = false) @RequestParam Integer page,
                                  @ApiParam(value = "数量", required = false) @RequestParam Integer pageSize) {
        List<User> users = userService.fetchUsers(page,pageSize);
        return users;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        userService.create(user.getUser_name(),user.getAge());
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.get(id);
    }




    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        userService.deleteByName("lil");
        return "success";
    }

}
