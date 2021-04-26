package com.zsy.ssh.transaction;

import org.springframework.context.ApplicationEvent;

public class MyTransactionEvent extends ApplicationEvent {
    private String name;

    public MyTransactionEvent(String name, Object source) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
} 