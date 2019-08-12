package com.beans;

import com.core.BeanFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author ozj
 * @Description TODO
 * @Date 2019/8/915:12
 **/
public class ApplicationContext extends AbstractApplicationContext implements BeanFactory {

    String[] configLocations;

    BeanDefinitionReader reader;

    //用来存储所有的被代理过的对象
    Map<String,BeanWrapper> beanWrapperMap = new ConcurrentHashMap<String, BeanWrapper>();


    public void refresh(){
        //定位
        this.reader = new BeanDefinitionReader(configLocations);

        //加载
        List<String> beanDefinitions = reader.loadBeanDefinitions();

        //注册
        doRegisty(beanDefinitions);


        //依赖注入（lazy-init = false），要是执行依赖注入
        //在这里自动调用getBean方法
        doAutowrited();

//        MyAction myAction = (MyAction)this.getBean("myAction");
//        myAction.query(null,null,"任性的Tom老师");
    }

    //开始执行自动化的依赖注入
    private void doAutowrited() {
        for(Map.Entry<String,BeanDefinition> m : beanDefinitionMap.entrySet()){
            populateBean(m.getKey(),m.getValue());
        }
    }

    public void populateBean(String beanName,Object instance) {
            Class<?> clazz = instance.getClass();

    }

        private void doRegisty(List<String> beanDefinitions) {
        for(String className : beanDefinitions){
            try {
                Class<?> clazz = Class.forName(className);
                //如果是接口不能实例化
                if(clazz.isInterface()){continue;}
                BeanDefinition beanDefinition = reader.registerBean(className);
                if(beanDefinition!=null){
                    beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
                }
                Class<?>[]interFaces = clazz.getInterfaces();
                for(Class c : interFaces){
                    beanDefinitionMap.put(c.getName(),beanDefinition);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void refreshBeanFactory() {

    }

    @Override
    public Object getBean(String name) {
        return null;
    }
}
