package cn.day3.springjdbc._04txAnnotation;


public interface IDao {

	Account findAccount(String sourceAccountName);

	void updateAccount(Account sAccount);

}
