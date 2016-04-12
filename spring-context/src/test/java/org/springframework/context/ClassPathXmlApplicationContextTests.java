package org.springframework.context;

import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.ConfigurableEnvironment;
import service.HelloService;

/**
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 18/2/16
 */
public class ClassPathXmlApplicationContextTests {

    @Test
    public void test1(){
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
        System.setProperty("context.name", "demo");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:${context.name}-context.xml");
        context.start();
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.hello("world"));
    }

    @Test
    public void testJarOfClass(){
        System.out.println(Logger.class.getProtectionDomain().getCodeSource().getLocation());
    }
}
