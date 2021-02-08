package test;

/**
 * @Title test
 */

public class Test {

    public static void main(String[] args) {
        System.out.println(test());
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
