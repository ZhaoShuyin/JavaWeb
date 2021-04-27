package com.zsy.ssh.transaction;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    private String name;

    public MyEvent(String name, Object source) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
} 