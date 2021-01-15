package com.spring;

/**
 * @Title spring
 */

public class Test {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String regex = "^#[0-9a-fA-F]{6}$";
        System.out.println("#FFFFFF".matches(regex));
        System.out.println("#FFFFFFFF".matches(regex));
        System.out.println("#000000".matches(regex));
        System.out.println("#000000".matches(regex));
    }
}
