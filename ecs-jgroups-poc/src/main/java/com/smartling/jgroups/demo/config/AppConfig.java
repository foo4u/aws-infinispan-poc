package com.smartling.jgroups.demo.config;

import com.smartling.jgroups.demo.MessageReceiver;
import com.smartling.jgroups.demo.Sender;
import org.jgroups.JChannel;
import org.jgroups.Receiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.net.InetAddress;

/**
 * Application configuration.
 */
@Configuration
public class AppConfig {

    private static final String CLUSTER = "aws-demo";
    private static final String CHANNEL = "aws-chat";

    @Bean
    Receiver receiver() {
        return new MessageReceiver();
    }

    @Bean
    JChannel channel() throws Exception {
        Resource config = new ClassPathResource("tcp.xml");
        JChannel channel = new JChannel(config.getInputStream());

        channel.setName(CHANNEL);
        channel.setReceiver(receiver());

        channel.connect(CLUSTER, null, 3000L);
        channel.setDiscardOwnMessages(true);

        return channel;
    }

    @Bean
    String nodeName() throws Exception {
        return "Node_" + InetAddress.getLocalHost().getHostName();
    }

    @Bean
    Sender sender() throws Exception {
        return new Sender(channel(), nodeName());
    }

}
