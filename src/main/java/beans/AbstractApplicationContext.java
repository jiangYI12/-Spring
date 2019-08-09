package beans;

/**
 * @Author ozj
 * @Description TODO
 * @Date 2019/8/915:21
 **/
public abstract class AbstractApplicationContext {

    //提供给子类重写
    protected void onRefresh(){
        // For subclasses: do nothing by default.
    }

    protected abstract void refreshBeanFactory();
}
