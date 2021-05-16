package test.mybatisplus;

import com.zsy.ssm.entity.Employee;
import com.zsy.ssm.dao.EmplopyeeDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class testcurd {
    @Autowired
    private EmplopyeeDao emplopyeeDao;
    @Test
    public void testInsert(){
        Employee employee = new Employee();
        employee.setLastName("东方不败");
        employee.setEmail("dfbb@163.com");
        employee.setGender(1);
        employee.setAge(20);
        emplopyeeDao.insert(employee);
        //mybatisplus会自动把当前插入对象在数据库中的id写回到该实体中
        System.out.println(employee.getId());
    }

    @Test
    public void testUpdate(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("更新测试");
//        emplopyeeDao.updateById(employee);//根据id进行更新，没有传值的属性就不会更新
        emplopyeeDao.updateAllColumnById(employee);//根据id进行更新，没传值的属性就更新为null
    }

}