package com.zsy.ssh.transaction;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements ApplicationListener {
    private static final Logger LOGGER = Logger.getLogger(MyListener.class);

//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//    public void hanldeOrderCreatedEvent(MyEvent event) {
//        System.out.println("@@@@@@@@@@@@ event:"+event);
//    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("^^^^^^^^^^^^^^^ applicationEvent :" + applicationEvent.getTimestamp());
    }
}