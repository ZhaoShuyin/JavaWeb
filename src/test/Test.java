package test;

/**
 * @Title test
 */

public class Test {

    public static void main(String[] args) {
//        byte[] bytes = {0x3f, 0x3f};
//        System.out.println(bytes[0] << 8 | bytes[1] & 255);//0,3855,16191,3855,0
    }

    public static int test() {
        try {
            int a = 1 / 0;
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        } finally {
            return 2;
        }
    }



}
