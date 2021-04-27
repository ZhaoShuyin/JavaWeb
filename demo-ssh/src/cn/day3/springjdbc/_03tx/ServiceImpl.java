package cn.day3.springjdbc._03tx;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


public class ServiceImpl implements IService {

    //通过bean1.xml spring获取
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    //通过bean1.xml spring获取
    private IDao accountDao;

    public void setAccountDao(IDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 编程式事务：Spring要求，把处于同一个事务之中的代码写在 transactionTemplate.execute(同一个事务中的代码)
     * *** 使用 TransactionCallback 进行事务操作
     */
    public void transferTest(final String sourceAccountName, final String targetAccountName,
                             final float money) {
        TransactionCallback tc = new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                Account sAccount = accountDao.findAccount(sourceAccountName);// 每条语句都处于单独的JDBC事务中
                Account tAccount = accountDao.findAccount(targetAccountName);// 每条语句都处于单独的JDBC事务中
                sAccount.setAmount(sAccount.getAmount() - money);
                tAccount.setAmount(tAccount.getAmount() + money);
                accountDao.updateAccount(sAccount);// 每条语句都处于单独的JDBC事务中
//				 int i=1/0;
                accountDao.updateAccount(tAccount);// 每条语句都处于单独的JDBC事务中
            }
        };
        transactionTemplate.execute(tc);//执行事务控制的代码
    }

    /**
     * @param sourceAccountName 转出账户名
     * @param targetAccountName 转入账户名
     * @param money             金额
     */
    public void transfer(String sourceAccountName, String targetAccountName,
                         float money) {
        Account sAccount = accountDao.findAccount(sourceAccountName);// 每条语句都处于单独的JDBC事务中
        Account tAccount = accountDao.findAccount(targetAccountName);// 每条语句都处于单独的JDBC事务中
        sAccount.setAmount(sAccount.getAmount() - money);
        tAccount.setAmount(tAccount.getAmount() + money);
        accountDao.updateAccount(sAccount);// 每条语句都处于单独的JDBC事务中
				 int i=1/0;
        accountDao.updateAccount(tAccount);// 每条语句都处于单独的JDBC事务中
    }

    //当前方法是m1.调用m2
    //<tx:method name="m2" propagation="MANDATORY"/>
    //m2上必须有事务
    public void m1() {
        System.out.println("=============m1================");
//		m2();
    }

    public void m2() {
        System.out.println("=============m2================");
        m1();
    }

}
