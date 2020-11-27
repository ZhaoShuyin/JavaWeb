package mybatis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Title mybatis
 */

public class Test {
    public static String bigJson = "{\"Status\":1," +
            "\"Msg\":\"ok\"," +
            "\"Result\":" +
            "[" +
            "[" +
            "{\"NAME\":\"跟*\",\"EXAM_ROOM\":\"心电图一室\",\"QUEUE_ID\":null,\"CALLOK\":0,\"PRIORITYCHECK\":null}," +
            "{\"NAME\":\"大*\",\"EXAM_ROOM\":\"心电图一室\",\"QUEUE_ID\":\"0001\",\"CALLOK\":0,\"PRIORITYCHECK\":true}" +
            "]," +
            "[" +
            "{\"NAME\":\"的*\",\"EXAM_ROOM\":\"心电图二室\",\"QUEUE_ID\":\"0001\",\"CALLOK\":0,\"PRIORITYCHECK\":null}" +
            "]" +
            "]," +
            "\"ResponseModel\":\"\"}";
    public static void main(String[] args) {
        String s = "张三--医生--标题--是指客户冯丽娟";
        System.out.println(Arrays.toString(s.split("--")));
    }
}
