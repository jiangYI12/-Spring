package com.demo;

import com.myAnnotation.Service;

/**
 * @Author ozj
 * @Description TODO
 * @Date 2019/8/916:19
 **/
@Service
public class TestService implements ITestSerive {
    @Override
    public void add() {
        System.out.println("testone add");
    }

    @Override
    public void del() {
        System.out.println("testone del");
    }

    @Override
    public void modify() {
        System.out.println("testone modify");
    }
}
