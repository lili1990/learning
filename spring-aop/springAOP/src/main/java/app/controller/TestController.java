package app.controller;

import app.service.AopService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lili19289 on 2017/1/22.
 */
@RestController
public class TestController {

    @Resource(name="aopServiceProxy")
    private AopService aopService;

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String testAOP() {
        return aopService.testAOP();
    }
}
