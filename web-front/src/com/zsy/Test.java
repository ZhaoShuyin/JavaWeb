package com.zsy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Title cn.zsy
 * @date 2020/3/23
 * @autor Zsy
 */

public class Test {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(2020, 01, 01);
        String s = date.toString();
        System.out.println(s);
        Calendar ca = Calendar.getInstance();
        Date mEndDate = ca.getTime();
        System.out.println(mEndDate.toString());
        System.out.println(dateFormat.format(mEndDate));
        ca.add(Calendar.DAY_OF_YEAR, -7);
        Date mStartDate = ca.getTime();
        System.out.println(mStartDate.toString());
        System.out.println(dateFormat.format(mStartDate));
    }

}
