package cn.struts.day1.json;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport; 


/**
 * JSON测试
 *
 * @author Watson Xu
 * @date 2012-8-4 下午06:21:01
 */
public class JsonAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private Map<String, Object> dataMap;
    private String key = "Just see see";

    public String json() {
// dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据 
        dataMap = new HashMap<String, Object>();
        User user = new User();
        user.setName("张三");
        user.setPassword("123");
        dataMap.put("user", user);
// 放入一个是否操作成功的标识 
        dataMap.put("success", true);
// 返回结果 
        return SUCCESS;
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }


    //设置key属性不作为json的内容返回
    @JSON(serialize = false)
    public String getKey() {
        return key;
    }

} 