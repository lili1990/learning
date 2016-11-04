package test;

import app.models.User;
import app.zookeeper.ConfigureLoader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by sdlili on 16-10-22.
 */
public class TestXmlBeanFactory {


    public static void main(String[] args) {
        ClassPathResource classPath = new ClassPathResource("conf/applicationContext.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPath);
        User user= xmlBeanFactory.getBean(User.class);
        System.out.print("---------"+user.getUser_name());


    }
}
