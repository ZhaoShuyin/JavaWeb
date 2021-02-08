package zsy.hibernate.day41.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import zsy.hibernate.day41.domain.Customer;
import zsy.hibernate.day41.util.HibernateUtil;

public class Demo1Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Session s = HibernateUtil.openSession();
        Customer c = (Customer) s.get(Customer.class, 1);
        System.out.println(c);
        s.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
