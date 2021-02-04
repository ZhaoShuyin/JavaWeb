package cn.day3.springjdbc._03tx;


public interface IDao {

	Account findAccount(String sourceAccountName);

	int updateAccount(Account sAccount);

}
