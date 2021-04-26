package com.zsy.ssh.dao;

import com.zsy.ssh.domain.Account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * @Title com.zsy.ssh.dao
 * @date 2021/4/26
 * @autor Zsy
 */

public class TestDao {

    //org.hibernate.SessionFactory
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Account queryBy(Integer id){
        System.out.println("=================== TestDao.queryBy() ======= "+id);
        Session session = sessionFactory.openSession();
        Account account = session.get(Account.class, id);
        session.close();
        return account;
    }


    public void transaction(Account account){
//        Session session = sessionFactory.openSession();
//        session.save(account);
//        session.close();
        hibernateTemplate.save(account);
    }


}
