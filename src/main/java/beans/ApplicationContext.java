package beans;

import core.BeanFactory;

import java.util.List;

/**
 * @Author ozj
 * @Description TODO
 * @Date 2019/8/915:12
 **/
public class ApplicationContext extends AbstractApplicationContext implements BeanFactory {

    String[] configLocations;

    BeanDefinitionReader reader;
    
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

    private void doAutowrited() {
    }

    private void doRegisty(List<String> beanDefinitions) {
    }

    @Override
    protected void refreshBeanFactory() {

    }

    @Override
    public Object getBean(String name) {
        return null;
    }
}
