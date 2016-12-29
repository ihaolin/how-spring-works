package org.springframework.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

public class LazyBeanTests {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Conf.class);
        Bar bar = ctx.getBean(Bar.class);
        System.out.println(bar);
        System.out.println(bar.foo);
    }
}

@Configuration
class Conf {
    @Bean
    @Lazy
    @Scope(proxyMode = ScopedProxyMode.INTERFACES)
    public IFoo foo() {
        System.out.println("get foo");
        return new Foo();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }
}

class Bar {
    @Autowired
    public IFoo foo;
}

class Foo implements IFoo {

    public Foo(){
        System.out.println("init foo");
    }

    @Override
    public void func1() {

    }
}

interface IFoo{
    void func1();
}