package com.tech.messaging.activemqexample.resources;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;


@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/{message}")
    public void publish(@PathVariable("message") final String stringMessage) {
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(stringMessage);
                message.setJMSReplyTo(new ActiveMQQueue("Recv2Send"));
                return message;
            }
        });

    }

}
