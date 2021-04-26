package com.zsy.ssh.dao;

import com.zsy.ssh.domain.User;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Title com.zsy.ssh.dao
 * @date 2021/4/26
 * @autor Zsy
 */
@Component("userDao")
public class UserDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Resource(name = "hibernateTemplate")
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public User queryBuId(Integer id) {
       return hibernateTemplate.get(User.class,id);
    }

}
