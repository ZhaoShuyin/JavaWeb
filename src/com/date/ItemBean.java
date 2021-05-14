package com.date;

import java.io.Serializable;

/**
 * @Title 本院病例Bean
 * @date 2020/3/20
 * @autor Zsy
 */
public class ItemBean implements Serializable {

    public boolean QUICK;             //标记是否快速新建
    public String SERIES = "";        //重做时覆盖的SERIES

    public String EXAM_SERIES_UID;    //

    public String EXAM_UID;           //病例唯一标识ID
    public String ISTOP;              //是否置顶

    public String NAME;               //姓名
    public String NAME_PHONETIC;      //英文名
    public String SEX;                //性别
    public String SEX_NAME;           //性别Name
    public String AgeDisPlay;         //年龄描述
    public String EXAM_AGE;           //年龄
    public String AGE_UNIT;           //年龄单位
    public String BIRTHDAY;           //生日

    public String REQ_DEPT_NAME;      //科室Name
    public String REQ_DEPT_CODE;      //科室Code

    public String PATIENT_SOURCE_NAME;//患者来源Name
    public String PATIENT_SOURCE;     //患者来源Code

    public String ITEM_NAME;           //检查项目
    public String ITEM_CODE;           //检查项目

    public String EXAM_CLASS;          //检查类型

    public String OUTP_NO;             //门诊号
    public String INP_NO;              //住院号
    public String ROOM_NO;             //房间号/病区
    public String BED_NO;              //床号

    public String CREATE_USER_UID;     //创建者医生

    public String EXAM_STATUS;         //检查状态 1.未检查 2.未报告 3.已报告 4.已审核 5.已退回
    public String EXAM_STATUS_NAME;    //检查状态

    public String CONSULTATION_STATUS; //会诊状态  未申请/未会诊/已会诊
    public String File_Status;         //文件状态

    public String CREATE_DATE;         //创建日期
    public String EXAM_DATETIME;       //测试日期
    public String REQ_DATETIME;        //申请日期

    public String PATIENT_ID;          //患者ID 使用这个>>>>>>>>>>>>>>>>>>>
    public String HIS_PATIENT_ID;      //HIS患者ID
    public String HOSPITAL_CODE;       //医院ID

    public String PRINT_STATUS;        //打印状态
    public String IMAGE_STATUS_NAME;   //图片状态

    public String DEVICE_UID;          //设备ID

    public String PATIENT_UID;         //某项ID
    public String EXAM_NO;             //某项ID

    public String EDIT_DATE;           //编辑日期
    public String EDIT_USER_UID;       //编辑人UID

    public String EXAM_DEPT_CODE;      //检查科室
    public String EXAM_DEPT_NAME;      //科室名称

    public String REQ_DOCTOR_NAME;     //申请医生名称
    public String REQ_DOCTOR_CODE;     //申请医生ID

    public String CHECK_DOCTOR_CODE;   //审核人UID
    public String CHECK_DOCTOR_NAME;   //审核医生名称

    public String EXAM_DOCTOR_NAME;    //检测医生名称

    public String REPORT_DOCTOR_UID;   //报告人UID
    public String REPORT_DOCTOR_NAME;  //报告医生名称

    public String AUTOMATIC_DIAGNOSIS; //检查所见
    public String FINDINGS;            //检查所见
    public String CONCLUSIONS;         //检查结论

    public int PACS_UPLOAD_STATUS;     //初始化检查PACS图像未上传
    public int RIS_UPLOAD_STATUS;      //初始化检查RIS图像未上传
    public int IMAGE_STATUS;           //初始化检查为无图
    public int DELETE_FLAG;            //删除状态
    public int PRINT_NUM;              //打印次数

    public String ACCESSIONNUMBER;

    public String DANGER_MSG;
    public String REPORT_DATETIME;

    public String FROM_TYPE;
    public String CASE_HISTORY;
    public String INSURANCE_TYPE;

    public String PHYS_SIGN;

    public String NATION;

    public String NATIVE_PLACE;
    public String CHARGE_TYPE;
    public String PHOTO;
    public String USING_STATUS;
    public String WEIGHT;
    public String P_CREATE_USER_UID;

    public String P_CREATE_DATE;

    public String MAILING_ADDRESS;

    public String IS_ABNORMAL;

    public String RIS_UPLOAD_STATUS_NAME;

    public String DELETE_USER_UID;

    public String EXAM_DOCTOR_UID;
    public String INSURANCE_CARD_NO;
    public String P_DELETE_USER_UID;
    public String ID_NUMBER;

    public String ZIP_CODE;
    public String CHARGES;

    public String P_EDIT_DATE;

    public String P_EDIT_USER_UID;

    public String VISIT_NO;

    public String DEPT_EXAM_NO;

    public String P_DELETE_DATE;

    public String CLIN_DIAG;

    public String CROWD_TYPE;
    public String CHECK_DATETIME;

    public String CONTACT_TEL;
    public String HEIGHT;

    public String EXAM_SUB_CLASS;
    public String EXAM_ROOM;
    public String PACS_UPLOAD_STATUS_NAME;

    public String HOME_ADDRESS;

    public String DELETE_DATE;


    public String getEXAM_SERIES_UID() {
        return EXAM_SERIES_UID;
    }

    public void setEXAM_SERIES_UID(String EXAM_SERIES_UID) {
        this.EXAM_SERIES_UID = EXAM_SERIES_UID;
    }

    public String getEXAM_UID() {
        return EXAM_UID;
    }

    public void setEXAM_UID(String EXAM_UID) {
        this.EXAM_UID = EXAM_UID;
    }

    public String getISTOP() {
        return ISTOP;
    }

    public void setISTOP(String ISTOP) {
        this.ISTOP = ISTOP;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getNAME_PHONETIC() {
        return NAME_PHONETIC;
    }

    public void setNAME_PHONETIC(String NAME_PHONETIC) {
        this.NAME_PHONETIC = NAME_PHONETIC;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getSEX_NAME() {
        return SEX_NAME;
    }

    public void setSEX_NAME(String SEX_NAME) {
        this.SEX_NAME = SEX_NAME;
    }

    public String getAgeDisPlay() {
        return AgeDisPlay;
    }

    public void setAgeDisPlay(String ageDisPlay) {
        AgeDisPlay = ageDisPlay;
    }

    public String getEXAM_AGE() {
        return EXAM_AGE;
    }

    public void setEXAM_AGE(String EXAM_AGE) {
        this.EXAM_AGE = EXAM_AGE;
    }

    public String getAGE_UNIT() {
        return AGE_UNIT;
    }

    public void setAGE_UNIT(String AGE_UNIT) {
        this.AGE_UNIT = AGE_UNIT;
    }

    public String getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(String BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public String getREQ_DEPT_NAME() {
        return REQ_DEPT_NAME;
    }

    public void setREQ_DEPT_NAME(String REQ_DEPT_NAME) {
        this.REQ_DEPT_NAME = REQ_DEPT_NAME;
    }

    public String getREQ_DEPT_CODE() {
        return REQ_DEPT_CODE;
    }

    public void setREQ_DEPT_CODE(String REQ_DEPT_CODE) {
        this.REQ_DEPT_CODE = REQ_DEPT_CODE;
    }

    public String getPATIENT_SOURCE_NAME() {
        return PATIENT_SOURCE_NAME;
    }

    public void setPATIENT_SOURCE_NAME(String PATIENT_SOURCE_NAME) {
        this.PATIENT_SOURCE_NAME = PATIENT_SOURCE_NAME;
    }

    public String getPATIENT_SOURCE() {
        return PATIENT_SOURCE;
    }

    public void setPATIENT_SOURCE(String PATIENT_SOURCE) {
        this.PATIENT_SOURCE = PATIENT_SOURCE;
    }

    public String getITEM_NAME() {
        return ITEM_NAME;
    }

    public void setITEM_NAME(String ITEM_NAME) {
        this.ITEM_NAME = ITEM_NAME;
    }

    public String getITEM_CODE() {
        return ITEM_CODE;
    }

    public void setITEM_CODE(String ITEM_CODE) {
        this.ITEM_CODE = ITEM_CODE;
    }

    public String getEXAM_CLASS() {
        return EXAM_CLASS;
    }

    public void setEXAM_CLASS(String EXAM_CLASS) {
        this.EXAM_CLASS = EXAM_CLASS;
    }

    public String getOUTP_NO() {
        return OUTP_NO;
    }

    public void setOUTP_NO(String OUTP_NO) {
        this.OUTP_NO = OUTP_NO;
    }

    public String getINP_NO() {
        return INP_NO;
    }

    public void setINP_NO(String INP_NO) {
        this.INP_NO = INP_NO;
    }

    public String getROOM_NO() {
        return ROOM_NO;
    }

    public void setROOM_NO(String ROOM_NO) {
        this.ROOM_NO = ROOM_NO;
    }

    public String getBED_NO() {
        return BED_NO;
    }

    public void setBED_NO(String BED_NO) {
        this.BED_NO = BED_NO;
    }

    public String getCREATE_USER_UID() {
        return CREATE_USER_UID;
    }

    public void setCREATE_USER_UID(String CREATE_USER_UID) {
        this.CREATE_USER_UID = CREATE_USER_UID;
    }

    public String getEXAM_STATUS() {
        return EXAM_STATUS;
    }

    public void setEXAM_STATUS(String EXAM_STATUS) {
        this.EXAM_STATUS = EXAM_STATUS;
    }

    public String getEXAM_STATUS_NAME() {
        return EXAM_STATUS_NAME;
    }

    public void setEXAM_STATUS_NAME(String EXAM_STATUS_NAME) {
        this.EXAM_STATUS_NAME = EXAM_STATUS_NAME;
    }

    public String getCONSULTATION_STATUS() {
        return CONSULTATION_STATUS;
    }

    public void setCONSULTATION_STATUS(String CONSULTATION_STATUS) {
        this.CONSULTATION_STATUS = CONSULTATION_STATUS;
    }

    public String getFile_Status() {
        return File_Status;
    }

    public void setFile_Status(String file_Status) {
        File_Status = file_Status;
    }

    public String getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(String CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public String getEXAM_DATETIME() {
        return EXAM_DATETIME;
    }

    public void setEXAM_DATETIME(String EXAM_DATETIME) {
        this.EXAM_DATETIME = EXAM_DATETIME;
    }

    public String getREQ_DATETIME() {
        return REQ_DATETIME;
    }

    public void setREQ_DATETIME(String REQ_DATETIME) {
        this.REQ_DATETIME = REQ_DATETIME;
    }

    public String getPATIENT_ID() {
        return PATIENT_ID;
    }

    public void setPATIENT_ID(String PATIENT_ID) {
        this.PATIENT_ID = PATIENT_ID;
    }

    public String getHIS_PATIENT_ID() {
        return HIS_PATIENT_ID;
    }

    public void setHIS_PATIENT_ID(String HIS_PATIENT_ID) {
        this.HIS_PATIENT_ID = HIS_PATIENT_ID;
    }

    public String getHOSPITAL_CODE() {
        return HOSPITAL_CODE;
    }

    public void setHOSPITAL_CODE(String HOSPITAL_CODE) {
        this.HOSPITAL_CODE = HOSPITAL_CODE;
    }

    public String getPRINT_STATUS() {
        return PRINT_STATUS;
    }

    public void setPRINT_STATUS(String PRINT_STATUS) {
        this.PRINT_STATUS = PRINT_STATUS;
    }

    public String getIMAGE_STATUS_NAME() {
        return IMAGE_STATUS_NAME;
    }

    public void setIMAGE_STATUS_NAME(String IMAGE_STATUS_NAME) {
        this.IMAGE_STATUS_NAME = IMAGE_STATUS_NAME;
    }

    public String getDEVICE_UID() {
        return DEVICE_UID;
    }

    public void setDEVICE_UID(String DEVICE_UID) {
        this.DEVICE_UID = DEVICE_UID;
    }

    public String getPATIENT_UID() {
        return PATIENT_UID;
    }

    public void setPATIENT_UID(String PATIENT_UID) {
        this.PATIENT_UID = PATIENT_UID;
    }

    public String getEXAM_NO() {
        return EXAM_NO;
    }

    public void setEXAM_NO(String EXAM_NO) {
        this.EXAM_NO = EXAM_NO;
    }

    public String getEDIT_DATE() {
        return EDIT_DATE;
    }

    public void setEDIT_DATE(String EDIT_DATE) {
        this.EDIT_DATE = EDIT_DATE;
    }

    public String getEDIT_USER_UID() {
        return EDIT_USER_UID;
    }

    public void setEDIT_USER_UID(String EDIT_USER_UID) {
        this.EDIT_USER_UID = EDIT_USER_UID;
    }

    public String getEXAM_DEPT_CODE() {
        return EXAM_DEPT_CODE;
    }

    public void setEXAM_DEPT_CODE(String EXAM_DEPT_CODE) {
        this.EXAM_DEPT_CODE = EXAM_DEPT_CODE;
    }

    public String getEXAM_DEPT_NAME() {
        return EXAM_DEPT_NAME;
    }

    public void setEXAM_DEPT_NAME(String EXAM_DEPT_NAME) {
        this.EXAM_DEPT_NAME = EXAM_DEPT_NAME;
    }

    public String getREQ_DOCTOR_NAME() {
        return REQ_DOCTOR_NAME;
    }

    public void setREQ_DOCTOR_NAME(String REQ_DOCTOR_NAME) {
        this.REQ_DOCTOR_NAME = REQ_DOCTOR_NAME;
    }

    public String getREQ_DOCTOR_CODE() {
        return REQ_DOCTOR_CODE;
    }

    public void setREQ_DOCTOR_CODE(String REQ_DOCTOR_CODE) {
        this.REQ_DOCTOR_CODE = REQ_DOCTOR_CODE;
    }

    public String getCHECK_DOCTOR_NAME() {
        return CHECK_DOCTOR_NAME;
    }

    public void setCHECK_DOCTOR_NAME(String CHECK_DOCTOR_NAME) {
        this.CHECK_DOCTOR_NAME = CHECK_DOCTOR_NAME;
    }

    public String getEXAM_DOCTOR_NAME() {
        return EXAM_DOCTOR_NAME;
    }

    public void setEXAM_DOCTOR_NAME(String EXAM_DOCTOR_NAME) {
        this.EXAM_DOCTOR_NAME = EXAM_DOCTOR_NAME;
    }

    public String getREPORT_DOCTOR_NAME() {
        return REPORT_DOCTOR_NAME;
    }

    public void setREPORT_DOCTOR_NAME(String REPORT_DOCTOR_NAME) {
        this.REPORT_DOCTOR_NAME = REPORT_DOCTOR_NAME;
    }

    public String getAUTOMATIC_DIAGNOSIS() {
        return AUTOMATIC_DIAGNOSIS;
    }

    public void setAUTOMATIC_DIAGNOSIS(String AUTOMATIC_DIAGNOSIS) {
        this.AUTOMATIC_DIAGNOSIS = AUTOMATIC_DIAGNOSIS;
    }

    public String getFINDINGS() {
        return FINDINGS;
    }

    public void setFINDINGS(String FINDINGS) {
        this.FINDINGS = FINDINGS;
    }

    public String getCONCLUSIONS() {
        return CONCLUSIONS;
    }

    public void setCONCLUSIONS(String CONCLUSIONS) {
        this.CONCLUSIONS = CONCLUSIONS;
    }

    public int getPACS_UPLOAD_STATUS() {
        return PACS_UPLOAD_STATUS;
    }

    public void setPACS_UPLOAD_STATUS(int PACS_UPLOAD_STATUS) {
        this.PACS_UPLOAD_STATUS = PACS_UPLOAD_STATUS;
    }

    public int getRIS_UPLOAD_STATUS() {
        return RIS_UPLOAD_STATUS;
    }

    public void setRIS_UPLOAD_STATUS(int RIS_UPLOAD_STATUS) {
        this.RIS_UPLOAD_STATUS = RIS_UPLOAD_STATUS;
    }

    public int getIMAGE_STATUS() {
        return IMAGE_STATUS;
    }

    public void setIMAGE_STATUS(int IMAGE_STATUS) {
        this.IMAGE_STATUS = IMAGE_STATUS;
    }

    public int getDELETE_FLAG() {
        return DELETE_FLAG;
    }

    public void setDELETE_FLAG(int DELETE_FLAG) {
        this.DELETE_FLAG = DELETE_FLAG;
    }

    public int getPRINT_NUM() {
        return PRINT_NUM;
    }

    public void setPRINT_NUM(int PRINT_NUM) {
        this.PRINT_NUM = PRINT_NUM;
    }

    public String getACCESSIONNUMBER() {
        return ACCESSIONNUMBER;
    }

    public void setACCESSIONNUMBER(String ACCESSIONNUMBER) {
        this.ACCESSIONNUMBER = ACCESSIONNUMBER;
    }

    public String getDANGER_MSG() {
        return DANGER_MSG;
    }

    public void setDANGER_MSG(String DANGER_MSG) {
        this.DANGER_MSG = DANGER_MSG;
    }

    public String getREPORT_DATETIME() {
        return REPORT_DATETIME;
    }

    public void setREPORT_DATETIME(String REPORT_DATETIME) {
        this.REPORT_DATETIME = REPORT_DATETIME;
    }

    public String getFROM_TYPE() {
        return FROM_TYPE;
    }

    public void setFROM_TYPE(String FROM_TYPE) {
        this.FROM_TYPE = FROM_TYPE;
    }

    public String getCASE_HISTORY() {
        return CASE_HISTORY;
    }

    public void setCASE_HISTORY(String CASE_HISTORY) {
        this.CASE_HISTORY = CASE_HISTORY;
    }

    public String getINSURANCE_TYPE() {
        return INSURANCE_TYPE;
    }

    public void setINSURANCE_TYPE(String INSURANCE_TYPE) {
        this.INSURANCE_TYPE = INSURANCE_TYPE;
    }

    public String getREPORT_DOCTOR_UID() {
        return REPORT_DOCTOR_UID;
    }

    public void setREPORT_DOCTOR_UID(String REPORT_DOCTOR_UID) {
        this.REPORT_DOCTOR_UID = REPORT_DOCTOR_UID;
    }

    public String getPHYS_SIGN() {
        return PHYS_SIGN;
    }

    public void setPHYS_SIGN(String PHYS_SIGN) {
        this.PHYS_SIGN = PHYS_SIGN;
    }

    public String getNATION() {
        return NATION;
    }

    public void setNATION(String NATION) {
        this.NATION = NATION;
    }

    public String getNATIVE_PLACE() {
        return NATIVE_PLACE;
    }

    public void setNATIVE_PLACE(String NATIVE_PLACE) {
        this.NATIVE_PLACE = NATIVE_PLACE;
    }

    public String getCHARGE_TYPE() {
        return CHARGE_TYPE;
    }

    public void setCHARGE_TYPE(String CHARGE_TYPE) {
        this.CHARGE_TYPE = CHARGE_TYPE;
    }

    public String getPHOTO() {
        return PHOTO;
    }

    public void setPHOTO(String PHOTO) {
        this.PHOTO = PHOTO;
    }

    public String getUSING_STATUS() {
        return USING_STATUS;
    }

    public void setUSING_STATUS(String USING_STATUS) {
        this.USING_STATUS = USING_STATUS;
    }

    public String getWEIGHT() {
        return WEIGHT;
    }

    public void setWEIGHT(String WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    public String getP_CREATE_USER_UID() {
        return P_CREATE_USER_UID;
    }

    public void setP_CREATE_USER_UID(String p_CREATE_USER_UID) {
        P_CREATE_USER_UID = p_CREATE_USER_UID;
    }

    public String getP_CREATE_DATE() {
        return P_CREATE_DATE;
    }

    public void setP_CREATE_DATE(String p_CREATE_DATE) {
        P_CREATE_DATE = p_CREATE_DATE;
    }

    public String getMAILING_ADDRESS() {
        return MAILING_ADDRESS;
    }

    public void setMAILING_ADDRESS(String MAILING_ADDRESS) {
        this.MAILING_ADDRESS = MAILING_ADDRESS;
    }

    public String getIS_ABNORMAL() {
        return IS_ABNORMAL;
    }

    public void setIS_ABNORMAL(String IS_ABNORMAL) {
        this.IS_ABNORMAL = IS_ABNORMAL;
    }

    public String getRIS_UPLOAD_STATUS_NAME() {
        return RIS_UPLOAD_STATUS_NAME;
    }

    public void setRIS_UPLOAD_STATUS_NAME(String RIS_UPLOAD_STATUS_NAME) {
        this.RIS_UPLOAD_STATUS_NAME = RIS_UPLOAD_STATUS_NAME;
    }

    public String getCHECK_DOCTOR_CODE() {
        return CHECK_DOCTOR_CODE;
    }

    public void setCHECK_DOCTOR_CODE(String CHECK_DOCTOR_CODE) {
        this.CHECK_DOCTOR_CODE = CHECK_DOCTOR_CODE;
    }

    public String getDELETE_USER_UID() {
        return DELETE_USER_UID;
    }

    public void setDELETE_USER_UID(String DELETE_USER_UID) {
        this.DELETE_USER_UID = DELETE_USER_UID;
    }

    public String getEXAM_DOCTOR_UID() {
        return EXAM_DOCTOR_UID;
    }

    public void setEXAM_DOCTOR_UID(String EXAM_DOCTOR_UID) {
        this.EXAM_DOCTOR_UID = EXAM_DOCTOR_UID;
    }

    public String getINSURANCE_CARD_NO() {
        return INSURANCE_CARD_NO;
    }

    public void setINSURANCE_CARD_NO(String INSURANCE_CARD_NO) {
        this.INSURANCE_CARD_NO = INSURANCE_CARD_NO;
    }

    public String getP_DELETE_USER_UID() {
        return P_DELETE_USER_UID;
    }

    public void setP_DELETE_USER_UID(String p_DELETE_USER_UID) {
        P_DELETE_USER_UID = p_DELETE_USER_UID;
    }

    public String getID_NUMBER() {
        return ID_NUMBER;
    }

    public void setID_NUMBER(String ID_NUMBER) {
        this.ID_NUMBER = ID_NUMBER;
    }

    public String getZIP_CODE() {
        return ZIP_CODE;
    }

    public void setZIP_CODE(String ZIP_CODE) {
        this.ZIP_CODE = ZIP_CODE;
    }

    public String getCHARGES() {
        return CHARGES;
    }

    public void setCHARGES(String CHARGES) {
        this.CHARGES = CHARGES;
    }

    public String getP_EDIT_DATE() {
        return P_EDIT_DATE;
    }

    public void setP_EDIT_DATE(String p_EDIT_DATE) {
        P_EDIT_DATE = p_EDIT_DATE;
    }

    public String getP_EDIT_USER_UID() {
        return P_EDIT_USER_UID;
    }

    public void setP_EDIT_USER_UID(String p_EDIT_USER_UID) {
        P_EDIT_USER_UID = p_EDIT_USER_UID;
    }

    public String getVISIT_NO() {
        return VISIT_NO;
    }

    public void setVISIT_NO(String VISIT_NO) {
        this.VISIT_NO = VISIT_NO;
    }

    public String getDEPT_EXAM_NO() {
        return DEPT_EXAM_NO;
    }

    public void setDEPT_EXAM_NO(String DEPT_EXAM_NO) {
        this.DEPT_EXAM_NO = DEPT_EXAM_NO;
    }

    public String getP_DELETE_DATE() {
        return P_DELETE_DATE;
    }

    public void setP_DELETE_DATE(String p_DELETE_DATE) {
        P_DELETE_DATE = p_DELETE_DATE;
    }

    public String getCLIN_DIAG() {
        return CLIN_DIAG;
    }

    public void setCLIN_DIAG(String CLIN_DIAG) {
        this.CLIN_DIAG = CLIN_DIAG;
    }

    public String getCROWD_TYPE() {
        return CROWD_TYPE;
    }

    public void setCROWD_TYPE(String CROWD_TYPE) {
        this.CROWD_TYPE = CROWD_TYPE;
    }

    public String getCHECK_DATETIME() {
        return CHECK_DATETIME;
    }

    public void setCHECK_DATETIME(String CHECK_DATETIME) {
        this.CHECK_DATETIME = CHECK_DATETIME;
    }

    public String getCONTACT_TEL() {
        return CONTACT_TEL;
    }

    public void setCONTACT_TEL(String CONTACT_TEL) {
        this.CONTACT_TEL = CONTACT_TEL;
    }

    public String getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(String HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public String getEXAM_SUB_CLASS() {
        return EXAM_SUB_CLASS;
    }

    public void setEXAM_SUB_CLASS(String EXAM_SUB_CLASS) {
        this.EXAM_SUB_CLASS = EXAM_SUB_CLASS;
    }

    public String getEXAM_ROOM() {
        return EXAM_ROOM;
    }

    public void setEXAM_ROOM(String EXAM_ROOM) {
        this.EXAM_ROOM = EXAM_ROOM;
    }

    public String getPACS_UPLOAD_STATUS_NAME() {
        return PACS_UPLOAD_STATUS_NAME;
    }

    public void setPACS_UPLOAD_STATUS_NAME(String PACS_UPLOAD_STATUS_NAME) {
        this.PACS_UPLOAD_STATUS_NAME = PACS_UPLOAD_STATUS_NAME;
    }

    public String getHOME_ADDRESS() {
        return HOME_ADDRESS;
    }

    public void setHOME_ADDRESS(String HOME_ADDRESS) {
        this.HOME_ADDRESS = HOME_ADDRESS;
    }

    public String getDELETE_DATE() {
        return DELETE_DATE;
    }

    public void setDELETE_DATE(String DELETE_DATE) {
        this.DELETE_DATE = DELETE_DATE;
    }
}