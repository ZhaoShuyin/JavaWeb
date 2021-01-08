package test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

/**
 * 病例信息Bean
 */
public class CollectBean implements Serializable {

    private static final long serialVersionUID = -3428016453313652815L;

    public String StudyInstanceUID = "";    //唯一标识
    public String AdmissionID = "";         //记录ID
    public String hospital = "";
    public String name = "";
    public String sex = "";
    public String age = "";
    public String brithday = "";
    public String department = "";
    public String sourseType = "";
    public String checkOption = "";
    public String outHopsitalNo = "";
    public String inHospitalNo = "";
    public String ward = "";
    public String bedno = "";

    //标识
    public String TAG;
    //分析结果
    public String analysisResult = "暂无分析";
    //文件路径
    public String dataPath;
    public String dataFile;       //数据文件路径
    public String txtFile;        //数据文件路径
    public String xmlFile;        //xml文件路径
    public String proFile;        //xml文件路径

    public String start;
    public String end;

    public boolean valid;   //是否是有效文件
    public boolean checked; //是否选择

    public CollectBean(String path, String tag) {
        TAG = tag;
        dataPath = path + "/" + tag;
        File file = new File(dataPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        dataFile = path + "/" + tag + "/origin.data";
        txtFile = path + "/" + tag + "/origin.txt";
        xmlFile = path + "/" + tag + "/ECGL.xml";
        proFile = path + "/" + tag + "/info.properties";
    }

    public boolean saveProperties() {
        Properties properties = new Properties();
        properties.setProperty("StudyInstanceUID", StudyInstanceUID);
        properties.setProperty("AdmissionID", AdmissionID);
        properties.setProperty("hospital", hospital);
        properties.setProperty("name", name);
        properties.setProperty("sex", sex);
        properties.setProperty("age", age);
        properties.setProperty("brithday", brithday);
        properties.setProperty("department", department);
        properties.setProperty("sourseType", sourseType);
        properties.setProperty("checkOption", checkOption);
        properties.setProperty("outHopsitalNo", outHopsitalNo);
        properties.setProperty("inHospitalNo", inHospitalNo);
        properties.setProperty("ward", ward);
        properties.setProperty("bedno", bedno);
        try {
            properties.store(new FileWriter(proFile), "信息");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean readProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(proFile));
            StudyInstanceUID = properties.getProperty("StudyInstanceUID");
            AdmissionID = properties.getProperty("AdmissionID");
            hospital = properties.getProperty("hospital");
            name = properties.getProperty("name");
            sex = properties.getProperty("sex");
            age = properties.getProperty("age");
            brithday = properties.getProperty("brithday");
            department = properties.getProperty("department");
            sourseType = properties.getProperty("sourseType");
            checkOption = properties.getProperty("checkOption");
            outHopsitalNo = properties.getProperty("outHopsitalNo");
            inHospitalNo = properties.getProperty("inHospitalNo");
            ward = properties.getProperty("ward");
            bedno = properties.getProperty("bedno");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void main(String[] args) {
        String tag = System.currentTimeMillis() + "";
        String path = "D:/Test/File/abc";
        CollectBean bean = new CollectBean(path, tag);
        bean.StudyInstanceUID = "123";
        bean.AdmissionID = "123";
        bean.saveProperties();
        CollectBean bean1 = new CollectBean(path, tag);
        bean1.readProperties();
        System.out.println(bean1.StudyInstanceUID);
      /*  File path = new File("D:/Test/File/abc/1609740154005");
        File[] files = path.listFiles();
        for (int i = 0; i < files.length; i++) {
            files[i].delete();
        }
        boolean delete = path.delete();
        System.out.println(delete);*/
    }

}