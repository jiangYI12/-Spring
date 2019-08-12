package com.demo;

import com.myAnnotation.AutoWirse;
import com.myAnnotation.Controller;

/**
 * @Author ozj
 * @Description TODO
 * @Date 2019/8/916:19
 **/
@Controller
public class TestController {
    @AutoWirse
    TestService service;
    @AutoWirse
    TestServiceTwo serviceTwo;

    public void  test(){
        service.add();
        serviceTwo.add();
    }
}
