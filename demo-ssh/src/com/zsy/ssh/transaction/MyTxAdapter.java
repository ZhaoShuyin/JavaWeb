package com.zsy.ssh.transaction;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;

public class MyTxAdapter extends TransactionSynchronizationAdapter {


    public MyTxAdapter() {
        super();
        System.out.println("MyTxAdapter()");
    }

    @Override
    public int getOrder() {
        System.out.println("getOrder()");
        return super.getOrder();
    }

    @Override
    public void suspend() {
        super.suspend();
        System.out.println("suspend()");
    }

    @Override
    public void resume() {
        super.resume();
        System.out.println("resume()");
    }

    @Override
    public void flush() {
        super.flush();
        System.out.println("flush()");
    }

    @Override
    public void beforeCommit(boolean readOnly) {
        super.beforeCommit(readOnly);
        System.out.println("beforeCommit()");
    }

    @Override
    public void beforeCompletion() {
        super.beforeCompletion();
        System.out.println("beforeCompletion()");
    }

    @Override
    public void afterCommit() {
        super.afterCommit();
        System.out.println("afterCommit()");
    }

    @Override
    public void afterCompletion(int status) {
        System.out.println("afterCompletion()");
        if (status == STATUS_ROLLED_BACK) {
            //logic here.
        }
    }
}