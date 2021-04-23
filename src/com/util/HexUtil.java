package com.util;

/**
 * @Title com.example.app4
 * @date 2020/12/10
 * @autor Zsy
 */

public class HexUtil {
    public static String encodeHexStr(byte[] value, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String str = Integer.toHexString(value[i]);
            builder.append(" ");
            if (str.length() == 8) {
                str = str.substring(6);
            }
            if (str.length() == 1) {
                builder.append("0");
            }
            builder.append(str);
        }
        return builder.toString();
    }

    public static String encodeHexStr(byte[] value) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            String str = Integer.toHexString(value[i]);
            builder.append(" ");
            if (str.length() == 8) {
                str = str.substring(6);
            }
            if (str.length() == 1) {
                builder.append("0");
            }
            builder.append(str);
        }
        return builder.toString();
    }

    public static String bytetoString(byte... b) {
        return Integer.toHexString(b[0]) + Integer.toHexString(b[1]) + Integer.toHexString(b[2]) + Integer.toHexString(b[3]);
    }

    /**
     * 十六进制转int
     *
     * @param c
     * @return
     */
    public static int toByte(char c) {
        if (c >= '0' && c <= '9') return (c - '0');
        if (c >= 'A' && c <= 'F') return (c - 'A' + 10);
        if (c >= 'a' && c <= 'f') return (c - 'a' + 10);
        throw new RuntimeException("Invalid hex char '" + c + "'");
    }

    /**
     * 十六进制字符串转字节数组
     *
     * @param hexString 如：FE00120F0E
     * @return
     */
    public static byte[] hexStringToByteArray(String hexString) {
        int length = hexString.length();
        byte[] buffer = new byte[length / 2];

        for (int i = 0; i < length; i += 2) {
            buffer[i / 2] = (byte) ((toByte(hexString.charAt(i)) << 4) | toByte(hexString.charAt(i + 1)));
        }

        return buffer;
    }

    public static void main(String[] args) {
        byte[] bytes = {0x00, 0x00, 0x00, 0x01};
        System.out.println(new String(bytes));
    }

}
