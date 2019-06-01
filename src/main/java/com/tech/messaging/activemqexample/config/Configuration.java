package com.tech.messaging.activemqexample.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${activemq.broker.url}")
    private String brokerUrl;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue();
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(activeMQConnectionFactory());
        jmsTemplate.setDefaultDestination(queue());
        jmsTemplate.setDefaultDestinationName("Send2Recv");
        return jmsTemplate;
    }

}
