package com.smartling.jgroups.demo.service;

import com.smartling.jgroups.demo.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by scott on 7/21/15.
 */
@Service
public class MessageSenderService {

    @Autowired
    private Sender sender;

    @Scheduled(fixedDelay = 5000L)
    public void sendMessage() {
        sender.run();
    }
}
