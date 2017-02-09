package app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lili19289 on 2017/1/22.
 */
@RestController
public class AspectController {


    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(){
        return "success";
    }
}
