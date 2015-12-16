package com.smartling.jgroups.demo;

import org.jgroups.JChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JGroups message sender.
 */
public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    private final JChannel channel;
    private final String name;

    public Sender(JChannel channel, String name) {
        this.channel = channel;
        this.name = name;
    }

    //@Override
    public void run() {
        LOGGER.info("Current cluster view: " + channel.getViewAsString());
        try {
            channel.send(null, String.format("%s says hi", name));
        } catch (Exception ex) {
            throw new RuntimeException("Cannot send message");
        }
    }
}
