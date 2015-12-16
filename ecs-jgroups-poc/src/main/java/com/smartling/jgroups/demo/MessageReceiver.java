package com.smartling.jgroups.demo;

import org.jgroups.Address;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

import java.util.logging.Logger;

/**
 * JGroups message receiver.
 */
public class MessageReceiver extends ReceiverAdapter {

    private static final Logger LOGGER = Logger.getLogger(MessageReceiver.class.getName());

    @Override
    public void receive(Message msg) {
        Address sender=msg.getSrc();
        LOGGER.info(msg.getObject() + " [" + sender + "]");
    }

    @Override
    public void viewAccepted(View view) {
        LOGGER.info("view: " + view);
    }
}
