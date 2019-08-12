package com.beans;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author ozj
 * @Description TODO
 * @Date 2019/8/915:55
 **/
public class BeanDefinitionReader {
    Properties properties = new Properties();
    private List<String> registyBeanClasses = new ArrayList<String>();

    public BeanDefinitionReader(String... atgs) {
        //加载配置文件
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(atgs[0].replace("classpath:",""));
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        doScanner(properties.getProperty("scanPackage"));
    }

    private void doScanner(String path) {
        //通过类加载器 加载资源文件
       URL url =   this.getClass().getClassLoader().getResource(path);
       File dir =  new File(url.getFile());
       for(File file : dir.listFiles()){
           if(file.isDirectory()){
               doScanner(path);
           }else {
               registyBeanClasses.add(path + file.getName().replace(".class",""));
           }
       }
    }

    public List<String> loadBeanDefinitions() {

        return this.registyBeanClasses;
    }

    public BeanDefinition registerBean(String className) {
        if(registyBeanClasses.contains(className)){
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setBeanClassName(className);
            beanDefinition.setFactoryBeanName(lowerFirstCase(className.substring(className.lastIndexOf(".") + 1)));
            return beanDefinition;
        }
        return null;
    }

    private String lowerFirstCase(String str){
        char [] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
