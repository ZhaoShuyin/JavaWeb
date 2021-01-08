import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @Title PACKAGE_NAME
 */

public class Test {

    public static void main(String[] args) {
       /* byte b = 0x57;
        System.out.println(Integer.toBinaryString(b));
        boolean[] booleans = new boolean[8];
        booleans[0] = (b >> 7 & 0x1) != 0;
        booleans[1] = (b >> 6 & 0x1) != 0;
        booleans[2] = (b >> 5 & 0x1) != 0;
        booleans[3] = (b >> 4 & 0x1) != 0;
        booleans[4] = (b >> 3 & 0x1) != 0;
        booleans[5] = (b >> 2 & 0x1) != 0;
        booleans[6] = (b >> 1 & 0x1) != 0;
        booleans[7] = (b  & 0x1) != 0;
        //01010101
        //01010111
        System.out.println(Arrays.toString(booleans));*/

       /*String tag = "123.456.789";
        System.out.println(tag.substring(tag.lastIndexOf(".")+1));*/

       //39.98.68.80:3008
        try {
            boolean b = pingIp("192.168.0.101");
            System.out.println("ping: >> "+b);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }


    public static boolean pingIp(String ip) throws UnknownHostException, IOException {
        //能ping通放回true 反之 false 超时时间 3000毫秒
        return InetAddress.getByName(ip).isReachable(3000);
    }

    public static File[] sort(File[] s){
        //中间值
        File temp =null;
        //外循环:我认为最小的数,从0~长度-1
        for(int j = 0; j<s.length-1;j++){
            //最小值:假设第一个数就是最小的
            String min = s[j].getName();
            //记录最小数的下标的
            int minIndex=j;
            //内循环:拿我认为的最小的数和后面的数一个个进行比较
            for(int k=j+1;k<s.length;k++){
                //找到最小值
                if (Integer.parseInt(min.substring(0,min.indexOf(".")))>Integer.parseInt(s[k].getName().substring(0,s[k].getName().indexOf(".")))){
                    //修改最小
                    min=s[k].getName();
                    minIndex=k;
                }
            }
            //当退出内层循环就找到这次的最小值
            //交换位置
            temp = s[j];
            s[j]=s[minIndex];
            s[minIndex]=temp;
        }
        return s;
    }

}
