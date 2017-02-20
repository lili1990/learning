package app.controller;

import app.models.Member;
import app.service.MemberService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lili19289 on 2017/1/12.
 */
@RestController
@RequestMapping(value="/member")
public class MemberController {

    @Resource
    private MemberService memberService;


    @ApiOperation(value="创建用户", notes="根据Member对象创建用户")
    @RequestMapping(value="/create", method= RequestMethod.POST)
    public String postUser(@RequestBody Member member) {
        memberService.save(member);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Member getUser(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public List<Member> getMemberList(@ApiParam(value = "页数", required = false) @RequestParam Integer page,
                                  @ApiParam(value = "数量", required = false) @RequestParam Integer pageSize) {
        List<Member> members = memberService.fetchMembers(page,pageSize);
        return members;
    }

}
