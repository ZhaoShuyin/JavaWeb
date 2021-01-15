package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title com.pengyang.simple.util
 * @date 2020/12/30
 * @autor Zsy
 */

public class TxtUtil {

    public static int leadsNumber = 12;  //导联个数

    public static void main(String[] args) {
        int[] txt = createTxt("D:/abc/test/origin.data", "D:/abc/test/222.txt");
        System.out.println(Arrays.toString(txt));
    }

    /**
     * @param dataFile
     * @param xmlFile
     * @return 返回 0:导联数据长度  1:导联数量
     */
    public static int[] createTxt(String dataFile, String xmlFile) {
        File file = new File(dataFile);
        if (!file.exists()) {
            return null;
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
                return null;
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
                    if (j < leadsNumber) {
                        writer.write(String.valueOf(read[j][i]));
                        writer.write("\t");
                    }
                }
                writer.write("\n");
            }
            writer.close();
            return new int[]{count, 500, leadsNumber, 500, 16, 0};
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Map<String, String> getMap(String s) {
        Map<String, String> map = new HashMap<>();
        if (s == null) {
            return map;
        }
        String[] split = s.split("\n");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String s1 = split[i];
            if (s1.contains("=")) {
                String[] keyvalue = s1.split("=");
                if (keyvalue.length == 2) {
                    map.put(keyvalue[0], keyvalue[1].replace(" ", ""));
                }
            } else {
                if (s1.length() != 0) {
                    builder.append(s1 + "\r\n");
                }
            }
        }
        map.put("analysis", builder.toString());
        return map;
    }

}
