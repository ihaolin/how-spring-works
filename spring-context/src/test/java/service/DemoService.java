package service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 18/2/16
 */
public class DemoService {

    @Autowired
    private EchoService echoService;

    public String hello(String name){
        echoService.echo(name);
        return "hello, " + name;
    }
}
