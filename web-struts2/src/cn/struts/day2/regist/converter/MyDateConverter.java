package cn.struts.day2.regist.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.XWorkException;

//目标：MM/dd/yyyy<------------>java.util.Date互转
public class MyDateConverter extends StrutsTypeConverter {

    private DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * 从String--->其他类型（此处Date）
     * Map context:struts2的contextMap（数据中心）
     * String[] values:用户输入的字符串数值
     * Class toClass:目标类型（此处Date）
     */
    public Object convertFromString(Map context, String[] values, Class toClass) {
        if (values == null || values.length == 0)
            return null;
        String sdate = values[0];//  "10/09/2000"
        if (toClass == Date.class) {
            try {
                return df.parse(sdate);//只要不按照此格式就会解析出错
            } catch (ParseException e) {
                throw new XWorkException("转换失败，请检查您的格式是否是MM/dd/yyyy");//扔出的异常时框架要求的
            }
        }
        return null;
    }

    /**
     * 从其他类型（此处Date）---->String类型
     * Map context:struts2的contextMap（数据中心）
     * Object o:其他类对象（此处就是Date）
     */
    public String convertToString(Map context, Object o) {
        if (o == null)
            return null;
        if (o instanceof Date) {
            Date date = (Date) o;
            return df.format(date);
        }
        return null;
    }

}
