package demo;

import myAnnotation.AutoWirse;
import myAnnotation.Controller;

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
}
