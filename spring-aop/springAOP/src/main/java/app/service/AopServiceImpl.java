package app.service;

import org.springframework.stereotype.Service;

/**
 * Created by lili19289 on 2017/1/22.
 */
//@Service
public class AopServiceImpl implements AopService{

    @Override
    public String testAOP() {
        return "test aop service";
    }
}
