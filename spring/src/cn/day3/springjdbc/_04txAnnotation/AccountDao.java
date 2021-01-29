package cn.day3.springjdbc._04txAnnotation;


public interface AccountDao {

	Account findAccount(String sourceAccountName);

	void updateAccount(Account sAccount);

}
