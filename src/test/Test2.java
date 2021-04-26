package test;

/**
 * @Title test
 * @date 2021/4/25
 * @autor Zsy
 */

public class Test2 {

    public static void main(String[] args) {
        String detailed = "有【安贞医院】的患者【患者姓名:qq】催办";
        int start = detailed.indexOf("【");
        int end = detailed.indexOf("】");
        String substring = detailed.substring(start+1, end);
        System.out.println(substring);
    }

}
