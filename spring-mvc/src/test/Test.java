package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;

/**
 * @Title PACKAGE_NAME
 * @date 2021/5/14
 * @autor Zsy
 */

public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("test/bean.xml");
        ItemsService service = (ItemsService) ac.getBean("itemsService");
        try {
            List<ItemsCustom> itemsCustoms = service.queryItems(null);
            System.out.println(itemsCustoms.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
