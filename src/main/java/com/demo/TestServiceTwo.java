package com.demo;

import com.myAnnotation.Service;

/**
 * @Author ozj
 * @Description TODO
 * @Date 2019/8/916:38
 **/
@Service
public class TestServiceTwo implements ITestServiceTwo {
    @Override
    public void add() {
        System.out.println("testtwo add");
    }

    @Override
    public void del() {
        System.out.println("testtwo del");
    }

    @Override
    public void modify() {
        System.out.println("testtwo modify");
    }
}
