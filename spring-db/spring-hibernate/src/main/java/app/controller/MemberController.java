package app.controller;

import app.models.Member;
import app.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by sdlili on 17-1-12.
 */
@RestController
@RequestMapping("/member")
public class MemberController {


    @Resource
    private MemberService memberService;

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String postUser(@RequestBody Member member) {
        memberService.save(member);
        return "success";
    }
}
