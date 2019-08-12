package com.test;

import org.junit.Test;

import java.net.URL;

/**
 * @Author ozj
 * @Description TODO
 * @Date 2019/8/1215:50
 **/

public class MyTest {
    @Test
    public void test(){
      URL url =  this.getClass().getClassLoader()
              .getResource("com");
        System.out.println(url.getFile());
    }
}
