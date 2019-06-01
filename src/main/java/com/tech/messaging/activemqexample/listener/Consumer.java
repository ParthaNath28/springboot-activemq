package com.tech.messaging.activemqexample.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "Send2Recv")
    public void consume(String message){

        System.out.println("The message consumed is "+message);

    }
}
