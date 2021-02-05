package cn.day3.springjdbc._04txAnnotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements IDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public DaoImpl() {
		System.out.println("构造函数 : DaoImpl");
	}

	public Account findAccount(String sourceAccountName) {
		List<Account> list = jdbcTemplate.query("select * from accounts where name=?", new AMapper(), sourceAccountName);
		return list.size()==0?null:list.get(0);
		
	}

	public void updateAccount(Account sAccount) {
		jdbcTemplate.update("update accounts set amount=? where id=?",sAccount.getAmount(),sAccount.getId());
	}

}
