package cn.struts.day2.valid.test;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {
    //commons-lang3.jar:对java.lang中的类进行的扩展
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "";
        String s3 = "     ";
        System.out.println(StringUtils.isBlank(s1));//true
        System.out.println(StringUtils.isBlank(s2));//true
        System.out.println(StringUtils.isBlank(s3));//true

        System.out.println(StringUtils.isEmpty(s1));//true
        System.out.println(StringUtils.isEmpty(s2));//true
        System.out.println(StringUtils.isEmpty(s3));//false
    }

}
