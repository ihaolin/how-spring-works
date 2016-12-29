package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 22/2/16
 */
public class EchoService implements EnvironmentAware {

    @Value(value = "#{echo.echoHeader}")
    private String echoHeader;

    public EchoService(){
        System.out.println("I will be init.");
    }

    public void echo(String msg){
        System.out.println(echoHeader + ": " + msg);
    }

    @Override
    public void setEnvironment(Environment env) {
        System.out.println("EnvironmentAware callback: " + env.getDefaultProfiles()[0]);
    }
}
