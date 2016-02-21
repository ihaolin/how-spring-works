package org.springframework.context;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.DemoService;

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
        DemoService demoService = context.getBean(DemoService.class);
        System.out.println(demoService.hello("world"));
    }

}
