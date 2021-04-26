package com.zsy.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zsy.ssh.service.TestService;

/**
 * @Title com.zsy.ssh.action
 * @date 2021/4/25
 * @autor Zsy
 */

public class TestAction extends ActionSupport {

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    private TestService testService;

    @Override
    public String execute() throws Exception {
        System.out.println("============= TestAction : " + TestAction.this + " , testService: " + testService);
        System.out.println("========================================================================");
        testService.test();
        System.out.println("========================================================================");
        testService.testSupport();
        System.out.println("========================================================================");
        return SUCCESS;
    }

    public String transaction(){
        testService.transaction();
        return SUCCESS;
    }

    public String trano(){
        testService.trano();
        return SUCCESS;
    }
}
