package com.zsy.ssh.transaction;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;

public class MyTxCallback extends TransactionSynchronizationAdapter {

    @Override
    public void afterCompletion(int status) {
        if (status == STATUS_ROLLED_BACK) {
           //logic here.
        }
    }

}