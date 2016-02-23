package org.springframework.context;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.HelloService;

/**
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 18/2/16
 */
public class ClassPathXmlApplicationContextTests {

    @Test
    public void test1(){
        System.setProperty("context.name", "demo");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:${context.name}-context.xml");
        context.start();
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.hello("world"));
    }

}
