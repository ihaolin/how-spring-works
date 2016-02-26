package service;

import org.springframework.stereotype.Service;

/**
 * Author: haolin
 * Email: haolin.h0@gmail.com
 * Date: 23/2/16
 */
@Service
public class LogService {

    public void info(String msg){
        System.err.println(msg);
    }
}
