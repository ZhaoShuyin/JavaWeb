package test;

import net.sf.json.JSON;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Title com.pengyang.simple.util
 * @date 2020/12/30
 * @autor Zsy
 */

public class TxtUtil {


    public static boolean createTxt(String dataFile, String xmlFile) {
        File file = new File(dataFile);
        if (!file.exists()) {
            return false;
        }
        try {
            File xFile = new File(xmlFile);
            if (xFile.exists()) {
                xFile.delete();
            }
            FileWriter writer = new FileWriter(xmlFile, true);

            FileInputStream inputStream = new FileInputStream(file);
            int length = (int) file.length();
            int le = length % 500;
            if (le != 0) {
                return false;
            }
            byte[] bytes = new byte[length];
            inputStream.read(bytes);
            int count = length / 36;
            int[][] read = new int[18][count];
            int index = 0;
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < 18; j++) {
                    index = i * 36 + j * 2;
                    read[j][i] = bytes[index] << 8 | bytes[index + 1] & 255;
                    if (j < 12) {
                        writer.write(String.valueOf(read[j][i]));
                        writer.write(" ");
                    }
                }
                writer.write("\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String result =
            "HR= 54\n" +
                    "P_width= 100\n" +
                    "QRS_width= 139\n" +
                    "axis_qrs= 22\n" +
                    "PR= 150\n" +
                    "RV5= 0.860667\n" +
                    "SV1= -0.296222\n" +
                    "QT= 554\n" +
                    "QTc= 526\n" +
                    "Conclusion= 窦性心律\n" +
                    "\n" +
                    "异常心电图\n" +
                    "\n" +
                    "窦性心动过缓\n" +
                    "\n" +
                    "不完全性右束支传导阻滞\n" +
                    "异常Q波：II  III  avF  \n" +
                    "T波倒置：II  III  avF  I  avL  V6  V1  V2  V3  V4  V5  ";


    public static Map<String,String> getMap(String s) {
        Map<String, String> map = new HashMap<>();
        String[] split = s.split("\n");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            if (s1.contains("=")) {
                String[] keyvalue = s1.split("=");
                map.put(keyvalue[0], keyvalue[1]);
            } else {
                builder.append(s1);
            }
        }
        map.put("analysis", builder.toString());
        return map;
    }


    public static void main(String[] args) {
//        Map<String,String> map = getMap(result);
//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, String> next = iterator.next();
//            System.out.println(next.getKey()+" >> "+next.getValue());
//        }
        createTxt("D:/Test/upload/新建文件夹/origin.data","D:/Test/upload/新建文件夹/origin.txt");
    }
}
