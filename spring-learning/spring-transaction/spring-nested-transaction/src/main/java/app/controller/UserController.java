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


    @ApiOperation(value="创建用户", notes="REQUIRES_NEW事务，两个事物独立，一个异常不影响另一个事物")
    @RequestMapping(value="/saveA", method=RequestMethod.POST)
    public String saveA(@ModelAttribute User user)throws Exception {
        userService.saveA(user.getUser_name(),user.getAge());
        return "success";
    }

    @ApiOperation(value="创建用户", notes="NESTED事务，嵌套事务是回滚外层事物的子事物，嵌套事物异常，外层事物也会")
    @RequestMapping(value="/createA", method=RequestMethod.POST)
    public String createA(@ModelAttribute User user) throws Exception{
        userService.createA(user.getUser_name(),user.getAge());
        return "success";
    }

    @ApiOperation(value="创建用户", notes="REQUIRED事物，两个方法使用同一个事物，一个异常全部回滚")
    @RequestMapping(value="/addA", method=RequestMethod.POST)
    public String addA(@ModelAttribute User user)throws Exception {
        userService.addA(user.getUser_name(),user.getAge());
        return "success";
    }

    @ApiOperation(value="创建用户", notes="REQUIRES_NEW事务，两个事物独立，一个异常不影响另一个事物")
    @RequestMapping(value="/saveB", method=RequestMethod.POST)
    public String saveB(@ModelAttribute User user)throws Exception {
        userService.saveB(user.getUser_name(),user.getAge());
        return "success";
    }

    @ApiOperation(value="创建用户", notes="NESTED事务，嵌套事务是回滚外层事物的子事物，嵌套事物异常，外层事物也会")
    @RequestMapping(value="/createB", method=RequestMethod.POST)
    public String createB(@ModelAttribute User user) throws Exception{
        userService.createB(user.getUser_name(),user.getAge());
        return "success";
    }

    @ApiOperation(value="创建用户", notes="REQUIRED事物，两个方法使用同一个事物，一个异常全部回滚")
    @RequestMapping(value="/addB", method=RequestMethod.POST)
    public String addB(@ModelAttribute User user)throws Exception {
        userService.addA(user.getUser_name(),user.getAge());
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.get(id);
    }



}
