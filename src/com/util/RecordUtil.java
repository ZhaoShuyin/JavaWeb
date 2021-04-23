package com.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title com.transit.util
 * @date 2021/3/25
 * @autor Zsy
 */

public class RecordUtil {

    private static String newline = "\r\n";

    private static File logFile;
    private static File errorFile;

    private static Map<String, File> fileMap = new HashMap<>();
    private static Map<String, File> fileTxtMap = new HashMap<>();


    public static void main(String[] args) {
        RecordUtil.record("1", "1");
    }


    static {
        File path = new File("C:/static/data");
        if (!path.exists()) {
            path.mkdirs();
        }
        logFile = new File("C:/static/data/log.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        errorFile = new File("C:/static/error.txt");
        if (!errorFile.exists()) {
            try {
                errorFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void log(String s) {
        s = DateUtil.getDate() + " " + s + newline;
        System.out.println("log =========== " + s);
        appendMethodA(logFile, s.getBytes());
    }

    public static void log(String name, String s) {
        s = DateUtil.getDate() + " " + s + newline;
        System.out.println(s);
//        System.out.println(name + " : /n " + s);
//        if (!fileTxtMap.containsKey(name)) {
//            File file = new File("C:/static/data/" + name + ".txt");
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            fileTxtMap.put(name, file);
//        }
//        appendMethodA(fileTxtMap.get(name), s.getBytes());
    }

    public static void error(String s) {
        s = DateUtil.getDate() + " " + s + newline;
        System.out.println("log =========== " + s);
        appendMethodA(errorFile, s.getBytes());
    }


    public static void record(String device, String s) {
        System.out.println(device + " : /n " + s);
        if (!fileTxtMap.containsKey(device)) {
            File file = new File("C:/static/data/" + device + ".data");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileTxtMap.put(device, file);
        }
        appendMethodA(fileTxtMap.get(device), s.getBytes());
    }

    public static void record(String device, byte[] bytes) {
        if (!fileMap.containsKey(device)) {
            File file = new File("C:/static/data/" + device + ".data");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileMap.put(device, file);
        }
        appendMethodA(fileMap.get(device), bytes);
    }

    public static void log(File file, String s) {
        String s1 = DateUtil.getDate() + " ==> " + s + newline;
        System.out.println(s1);
        appendMethodA(file, s1.getBytes());
    }

    /**
     * A方法追加文件：使用RandomAccessFile
     */
    private static void appendMethodA(File file, byte[] bytes) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(file, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.write(bytes);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * B方法追加文件：使用FileWriter
     */
    private static void appendMethodB(File file, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(file, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
