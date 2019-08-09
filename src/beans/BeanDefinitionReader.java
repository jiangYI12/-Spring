package beans;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @Author ozj
 * @Description TODO
 * @Date 2019/8/915:55
 **/
public class BeanDefinitionReader {
    Properties properties = new Properties();

    public BeanDefinitionReader(String... atgs) {
        //加载配置文件
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(atgs[0].replace("classpath:",""));

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> loadBeanDefinitions() {
        return null;
    }
}
