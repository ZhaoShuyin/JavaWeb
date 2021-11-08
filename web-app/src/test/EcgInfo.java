package test;

import java.io.Serializable;

import struct.StructClass;
import struct.StructField;

/**
 * @Title com.pengyang.library.bean
 * @date 2021/6/2
 * @autor Zsy
 */

@StructClass
public class EcgInfo implements Serializable {

    @StructField(order = 0)
    public byte[] version = new byte[6];//版本标记
    @StructField(order = 1)
    public byte p;             //版本标记微端0
    @StructField(order = 2)
    public short heartrate;    //心率    【8-9】    例：50-200bpm
    @StructField(order = 3)
    public short P_W;          //P波宽度 【10-11】  例：92ms
    @StructField(order = 4)
    public short QRS_W;        //QRS宽度 【12-13】  例：100ms
    @StructField(order = 5)
    public short T_W;          //T宽度   【14-15】
    @StructField(order = 6)
    public short RR_I;         //RR间期  【16-17】
    @StructField(order = 7)
    public short PR_I;         //PR间期  【18-19】  例：140ms
    @StructField(order = 8)
    public short QT_I;         //QT间期  【20-21】  例：380ms
    @StructField(order = 9)
    public short QTC_I;        //QTC间期 【22-23】
    @StructField(order = 10)
    public short P_TAxis;      //T轴     【24-25】
    @StructField(order = 11)
    public short QRS_TAxis;    //QRS轴   【26-27】
    @StructField(order = 12)
    public short T_TAxis;      //T轴     【28-29】
    @StructField(order = 13)
    public short RV5;          //RV5     【30-31】
    @StructField(order = 14)
    public short SV1;          //SV1     【32-33】
    @StructField(order = 15)
    public short cardiacNumber;//⼼博总数 【34-35】

    @StructField(order = 16)
    public byte[] conclusion = new byte[512];//⾃动结论 GBK编码
    @StructField(order = 17)
    public Cardiac[] cardiacs;                  //⼼博位置/属性数据段

    public EcgInfo(int length) {
        cardiacs = new Cardiac[length];
    }

    public int[][] getCardiacDatas() {

        return null;
    }

    @StructClass
    public static class Cardiac {
        @StructField(order = 0)
        public int index;
        @StructField(order = 1)
        public short type;
    }

    public static void main(String[] args) {
        EcgInfo ecgInfo = new EcgInfo(3);

    }


}
