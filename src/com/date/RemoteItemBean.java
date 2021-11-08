package com.date;

import java.io.Serializable;

/**
 * @Title 远程病例Bean
 * @date 2020/3/20
 * @autor Zsy
 */
public class RemoteItemBean {


    private static final long serialVersionUID = 5698599301560986227L;
    public String EXAM_UID;

    public String NAME;                         //名称
    public String SEX;                          //性别
    public String SEX_NAME;                     //性别
    public int EXAM_AGE;                        //年龄
    public String AGE_UNIT;                     //年龄
    public String CONSULTATION_STATUS;
    public String CONSULTATION_STATUS_NAME;     //会诊状态
    public String APPLY_DATETIME;               //申请会诊日期

    public String CONSULTATION_HOSPITAL_CODE;   //会诊医院
    public String CONSULTATION_HOSPITAL_NAME;   //会诊医院

    public String APPLY_HOSPITAL_CODE;          //申请医院
    public String APPLY_HOSPITAL_NAME;          //申请医院

    public String OUTP_NO;                      //门诊号
    public String ROOM_NO;                      //房间号/病区
    public String BED_NO;                       //床号

    public String EXAM_STATUS;                  //会诊状态 3.已审核
    public String EXAM_STATUS_NAME;             //会诊状态


    public String CONCLUSIONS;                  //检查结论

    public String APPLY_DOCTOR_CODE;            //申请医生ID
    public String APPLY_DOCTOR_NAME;            //申请医生名称

    public String CONSULTATION_DOCTOR_CODE;     //会诊医生
    public String CONSULTATION_DOCTOR_NAME;     //会诊医生

    public String FINDINGS;
    public String CONSULTATION_FINDINGS;        //检查所见
    public String AUTOMATIC_DIAGNOSIS;          //检查所见
    public String CONSULTATION_CONCLUSION;      //检查结论(会诊)


    public String REPORT_DATETIME;
    public String FROM_TYPE;

    public String CASE_HISTORY;
    public String INSURANCE_TYPE;
    public String ITEM_NAME;
    public String PHYS_SIGN;
    public String IMAGE_STATUS_NAME;
    public String EXAM_NO;
    public String CHARGE_TYPE;
    public String USING_STATUS;
    public int WEIGHT;

    public String BIRTHDAY;
    public String DOCTOR_NAME;
    public String IS_ABNORMAL;
    public String RIS_UPLOAD_STATUS_NAME;

    public String REQ_DOCTOR_CODE;

    public String DELETE_USER_UID;

    public String REQ_DEPT_NAME;
    public String ID_NUMBER;

    public String DEVICE_UID;
    public String VISIT_NO;

    public String EDIT_DATE;
    public String EXAM_DEPT_NAME;
    public String DEPT_EXAM_NO;
    public String CHECK_DOCTOR_NAME;
    public String EDIT_USER_UID;
    public String CONSULTATION_UID;     //会诊者UID
    public String CLIN_DIAG;


    public String CREATE_USER_UID;
    public String PATIENT_UID;
    public String EXAM_SUB_CLASS;
    public String REPORT_DOCTOR_NAME;
    public String HOME_ADDRESS;

    public String HOSPITAL_CODE;
    public String EXAM_DOCTOR_NAME;

    public String DANGER_MSG;
    public String PATIENT_SOURCE;
    public String REPORT_DOCTOR_UID;
    public String NATION;
    public String PATIENT_SOURCE_NAME;

    public String REQ_DOCTOR_NAME;
    public String EXAM_CLASS;

    public String NATIVE_PLACE;

    public String PHOTO;
    public String REQ_DATETIME;
    public int PRINT_NUM;
    public String PRINT_STATUS;
    public String ITEM_CODE;
    public String RE_CODE;

    public String MAILING_ADDRESS;

    public int DELETE_FLAG;
    public String CREATE_DATE;
    public String CHECK_DOCTOR_CODE;
    public String INP_NO;
    public int PACS_UPLOAD_STATUS;
    public String ACCESSIONNUMBER;
    public String PATIENT_ID;
    public String EXAM_DOCTOR_UID;

    public String INSURANCE_CARD_NO;


    public String ZIP_CODE;
    public Double CHARGES;

    public String NAME_PHONETIC;


    public String REQ_DEPT_CODE;
    public String ISTOP;
    public String HIS_PATIENT_ID;
    public int IMAGE_STATUS;

    public String EXAM_DATETIME;
    public String CROWD_TYPE;
    public String CHECK_DATETIME;
    public int RIS_UPLOAD_STATUS;
    public String CONTACT_TEL;
    public int HEIGHT;
    public String EXAM_ROOM;
    public String PACS_UPLOAD_STATUS_NAME;
    public String CONSULTATION_DATE;
    public String DELETE_DATE;
    public String EXAM_DEPT_CODE;



    public void setREPORT_DATETIME(String REPORT_DATETIME) {
        this.REPORT_DATETIME = REPORT_DATETIME;
    }

    public void setFROM_TYPE(String FROM_TYPE) {
        this.FROM_TYPE = FROM_TYPE;
    }

    public void setCONSULTATION_STATUS_NAME(String CONSULTATION_STATUS_NAME) {
        this.CONSULTATION_STATUS_NAME = CONSULTATION_STATUS_NAME;
    }

    public void setCASE_HISTORY(String CASE_HISTORY) {
        this.CASE_HISTORY = CASE_HISTORY;
    }

    public void setINSURANCE_TYPE(String INSURANCE_TYPE) {
        this.INSURANCE_TYPE = INSURANCE_TYPE;
    }

    public void setITEM_NAME(String ITEM_NAME) {
        this.ITEM_NAME = ITEM_NAME;
    }

    public void setPHYS_SIGN(String PHYS_SIGN) {
        this.PHYS_SIGN = PHYS_SIGN;
    }

    public void setIMAGE_STATUS_NAME(String IMAGE_STATUS_NAME) {
        this.IMAGE_STATUS_NAME = IMAGE_STATUS_NAME;
    }

    public void setEXAM_NO(String EXAM_NO) {
        this.EXAM_NO = EXAM_NO;
    }

    public void setCHARGE_TYPE(String CHARGE_TYPE) {
        this.CHARGE_TYPE = CHARGE_TYPE;
    }

    public void setUSING_STATUS(String USING_STATUS) {
        this.USING_STATUS = USING_STATUS;
    }

    public void setWEIGHT(int WEIGHT) {
        this.WEIGHT = WEIGHT;
    }

    public void setAPPLY_DOCTOR_NAME(String APPLY_DOCTOR_NAME) {
        this.APPLY_DOCTOR_NAME = APPLY_DOCTOR_NAME;
    }

    public void setBIRTHDAY(String BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public void setDOCTOR_NAME(String DOCTOR_NAME) {
        this.DOCTOR_NAME = DOCTOR_NAME;
    }

    public void setIS_ABNORMAL(String IS_ABNORMAL) {
        this.IS_ABNORMAL = IS_ABNORMAL;
    }

    public void setRIS_UPLOAD_STATUS_NAME(String RIS_UPLOAD_STATUS_NAME) {
        this.RIS_UPLOAD_STATUS_NAME = RIS_UPLOAD_STATUS_NAME;
    }

    public void setCONSULTATION_HOSPITAL_CODE(String CONSULTATION_HOSPITAL_CODE) {
        this.CONSULTATION_HOSPITAL_CODE = CONSULTATION_HOSPITAL_CODE;
    }

    public void setREQ_DOCTOR_CODE(String REQ_DOCTOR_CODE) {
        this.REQ_DOCTOR_CODE = REQ_DOCTOR_CODE;
    }

    public void setFINDINGS(String FINDINGS) {
        this.FINDINGS = FINDINGS;
    }

    public void setDELETE_USER_UID(String DELETE_USER_UID) {
        this.DELETE_USER_UID = DELETE_USER_UID;
    }

    public void setEXAM_UID(String EXAM_UID) {
        this.EXAM_UID = EXAM_UID;
    }

    public void setREQ_DEPT_NAME(String REQ_DEPT_NAME) {
        this.REQ_DEPT_NAME = REQ_DEPT_NAME;
    }

    public void setID_NUMBER(String ID_NUMBER) {
        this.ID_NUMBER = ID_NUMBER;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public void setDEVICE_UID(String DEVICE_UID) {
        this.DEVICE_UID = DEVICE_UID;
    }

    public void setVISIT_NO(String VISIT_NO) {
        this.VISIT_NO = VISIT_NO;
    }

    public void setCONSULTATION_DOCTOR_NAME(String CONSULTATION_DOCTOR_NAME) {
        this.CONSULTATION_DOCTOR_NAME = CONSULTATION_DOCTOR_NAME;
    }

    public void setEDIT_DATE(String EDIT_DATE) {
        this.EDIT_DATE = EDIT_DATE;
    }

    public void setEXAM_DEPT_NAME(String EXAM_DEPT_NAME) {
        this.EXAM_DEPT_NAME = EXAM_DEPT_NAME;
    }

    public void setDEPT_EXAM_NO(String DEPT_EXAM_NO) {
        this.DEPT_EXAM_NO = DEPT_EXAM_NO;
    }

    public void setCHECK_DOCTOR_NAME(String CHECK_DOCTOR_NAME) {
        this.CHECK_DOCTOR_NAME = CHECK_DOCTOR_NAME;
    }

    public void setEDIT_USER_UID(String EDIT_USER_UID) {
        this.EDIT_USER_UID = EDIT_USER_UID;
    }

    public void setCONSULTATION_UID(String CONSULTATION_UID) {
        this.CONSULTATION_UID = CONSULTATION_UID;
    }

    public void setCLIN_DIAG(String CLIN_DIAG) {
        this.CLIN_DIAG = CLIN_DIAG;
    }

    public void setAPPLY_DATETIME(String APPLY_DATETIME) {
        this.APPLY_DATETIME = APPLY_DATETIME;
    }

    public void setCONSULTATION_FINDINGS(String CONSULTATION_FINDINGS) {
        this.CONSULTATION_FINDINGS = CONSULTATION_FINDINGS;
    }

    public void setAUTOMATIC_DIAGNOSIS(String AUTOMATIC_DIAGNOSIS) {
        this.AUTOMATIC_DIAGNOSIS = AUTOMATIC_DIAGNOSIS;
    }

    public void setCREATE_USER_UID(String CREATE_USER_UID) {
        this.CREATE_USER_UID = CREATE_USER_UID;
    }

    public void setPATIENT_UID(String PATIENT_UID) {
        this.PATIENT_UID = PATIENT_UID;
    }

    public void setEXAM_SUB_CLASS(String EXAM_SUB_CLASS) {
        this.EXAM_SUB_CLASS = EXAM_SUB_CLASS;
    }

    public void setREPORT_DOCTOR_NAME(String REPORT_DOCTOR_NAME) {
        this.REPORT_DOCTOR_NAME = REPORT_DOCTOR_NAME;
    }

    public void setHOME_ADDRESS(String HOME_ADDRESS) {
        this.HOME_ADDRESS = HOME_ADDRESS;
    }

    public void setCONCLUSIONS(String CONCLUSIONS) {
        this.CONCLUSIONS = CONCLUSIONS;
    }

    public void setHOSPITAL_CODE(String HOSPITAL_CODE) {
        this.HOSPITAL_CODE = HOSPITAL_CODE;
    }

    public void setEXAM_DOCTOR_NAME(String EXAM_DOCTOR_NAME) {
        this.EXAM_DOCTOR_NAME = EXAM_DOCTOR_NAME;
    }

    public void setSEX_NAME(String SEX_NAME) {
        this.SEX_NAME = SEX_NAME;
    }

    public void setDANGER_MSG(String DANGER_MSG) {
        this.DANGER_MSG = DANGER_MSG;
    }

    public void setPATIENT_SOURCE(String PATIENT_SOURCE) {
        this.PATIENT_SOURCE = PATIENT_SOURCE;
    }

    public void setREPORT_DOCTOR_UID(String REPORT_DOCTOR_UID) {
        this.REPORT_DOCTOR_UID = REPORT_DOCTOR_UID;
    }

    public void setNATION(String NATION) {
        this.NATION = NATION;
    }

    public void setPATIENT_SOURCE_NAME(String PATIENT_SOURCE_NAME) {
        this.PATIENT_SOURCE_NAME = PATIENT_SOURCE_NAME;
    }

    public void setCONSULTATION_STATUS(String CONSULTATION_STATUS) {
        this.CONSULTATION_STATUS = CONSULTATION_STATUS;
    }

    public void setREQ_DOCTOR_NAME(String REQ_DOCTOR_NAME) {
        this.REQ_DOCTOR_NAME = REQ_DOCTOR_NAME;
    }

    public void setEXAM_CLASS(String EXAM_CLASS) {
        this.EXAM_CLASS = EXAM_CLASS;
    }

    public void setEXAM_AGE(int EXAM_AGE) {
        this.EXAM_AGE = EXAM_AGE;
    }

    public void setNATIVE_PLACE(String NATIVE_PLACE) {
        this.NATIVE_PLACE = NATIVE_PLACE;
    }

    public void setCONSULTATION_HOSPITAL_NAME(String CONSULTATION_HOSPITAL_NAME) {
        this.CONSULTATION_HOSPITAL_NAME = CONSULTATION_HOSPITAL_NAME;
    }

    public void setPHOTO(String PHOTO) {
        this.PHOTO = PHOTO;
    }

    public void setREQ_DATETIME(String REQ_DATETIME) {
        this.REQ_DATETIME = REQ_DATETIME;
    }

    public void setPRINT_NUM(int PRINT_NUM) {
        this.PRINT_NUM = PRINT_NUM;
    }

    public void setPRINT_STATUS(String PRINT_STATUS) {
        this.PRINT_STATUS = PRINT_STATUS;
    }

    public void setITEM_CODE(String ITEM_CODE) {
        this.ITEM_CODE = ITEM_CODE;
    }

    public void setRE_CODE(String RE_CODE) {
        this.RE_CODE = RE_CODE;
    }

    public void setROOM_NO(String ROOM_NO) {
        this.ROOM_NO = ROOM_NO;
    }

    public void setMAILING_ADDRESS(String MAILING_ADDRESS) {
        this.MAILING_ADDRESS = MAILING_ADDRESS;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setDELETE_FLAG(int DELETE_FLAG) {
        this.DELETE_FLAG = DELETE_FLAG;
    }

    public void setCREATE_DATE(String CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public void setCHECK_DOCTOR_CODE(String CHECK_DOCTOR_CODE) {
        this.CHECK_DOCTOR_CODE = CHECK_DOCTOR_CODE;
    }

    public void setINP_NO(String INP_NO) {
        this.INP_NO = INP_NO;
    }

    public void setPACS_UPLOAD_STATUS(int PACS_UPLOAD_STATUS) {
        this.PACS_UPLOAD_STATUS = PACS_UPLOAD_STATUS;
    }

    public void setACCESSIONNUMBER(String ACCESSIONNUMBER) {
        this.ACCESSIONNUMBER = ACCESSIONNUMBER;
    }

    public void setPATIENT_ID(String PATIENT_ID) {
        this.PATIENT_ID = PATIENT_ID;
    }

    public void setEXAM_DOCTOR_UID(String EXAM_DOCTOR_UID) {
        this.EXAM_DOCTOR_UID = EXAM_DOCTOR_UID;
    }

    public void setAPPLY_HOSPITAL_NAME(String APPLY_HOSPITAL_NAME) {
        this.APPLY_HOSPITAL_NAME = APPLY_HOSPITAL_NAME;
    }

    public void setINSURANCE_CARD_NO(String INSURANCE_CARD_NO) {
        this.INSURANCE_CARD_NO = INSURANCE_CARD_NO;
    }

    public void setAPPLY_DOCTOR_CODE(String APPLY_DOCTOR_CODE) {
        this.APPLY_DOCTOR_CODE = APPLY_DOCTOR_CODE;
    }

    public void setAGE_UNIT(String AGE_UNIT) {
        this.AGE_UNIT = AGE_UNIT;
    }

    public void setZIP_CODE(String ZIP_CODE) {
        this.ZIP_CODE = ZIP_CODE;
    }

    public void setCHARGES(Double CHARGES) {
        this.CHARGES = CHARGES;
    }

    public void setCONSULTATION_DOCTOR_CODE(String CONSULTATION_DOCTOR_CODE) {
        this.CONSULTATION_DOCTOR_CODE = CONSULTATION_DOCTOR_CODE;
    }

    public void setCONSULTATION_CONCLUSION(String CONSULTATION_CONCLUSION) {
        this.CONSULTATION_CONCLUSION = CONSULTATION_CONCLUSION;
    }

    public void setNAME_PHONETIC(String NAME_PHONETIC) {
        this.NAME_PHONETIC = NAME_PHONETIC;
    }

    public void setEXAM_STATUS_NAME(String EXAM_STATUS_NAME) {
        this.EXAM_STATUS_NAME = EXAM_STATUS_NAME;
    }

    public void setBED_NO(String BED_NO) {
        this.BED_NO = BED_NO;
    }

    public void setEXAM_STATUS(String EXAM_STATUS) {
        this.EXAM_STATUS = EXAM_STATUS;
    }

    public void setAPPLY_HOSPITAL_CODE(String APPLY_HOSPITAL_CODE) {
        this.APPLY_HOSPITAL_CODE = APPLY_HOSPITAL_CODE;
    }

    public void setREQ_DEPT_CODE(String REQ_DEPT_CODE) {
        this.REQ_DEPT_CODE = REQ_DEPT_CODE;
    }

    public void setISTOP(String ISTOP) {
        this.ISTOP = ISTOP;
    }

    public void setHIS_PATIENT_ID(String HIS_PATIENT_ID) {
        this.HIS_PATIENT_ID = HIS_PATIENT_ID;
    }

    public void setIMAGE_STATUS(int IMAGE_STATUS) {
        this.IMAGE_STATUS = IMAGE_STATUS;
    }

    public void setOUTP_NO(String OUTP_NO) {
        this.OUTP_NO = OUTP_NO;
    }

    public void setEXAM_DATETIME(String EXAM_DATETIME) {
        this.EXAM_DATETIME = EXAM_DATETIME;
    }

    public void setCROWD_TYPE(String CROWD_TYPE) {
        this.CROWD_TYPE = CROWD_TYPE;
    }

    public void setCHECK_DATETIME(String CHECK_DATETIME) {
        this.CHECK_DATETIME = CHECK_DATETIME;
    }

    public void setRIS_UPLOAD_STATUS(int RIS_UPLOAD_STATUS) {
        this.RIS_UPLOAD_STATUS = RIS_UPLOAD_STATUS;
    }

    public void setCONTACT_TEL(String CONTACT_TEL) {
        this.CONTACT_TEL = CONTACT_TEL;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public void setEXAM_ROOM(String EXAM_ROOM) {
        this.EXAM_ROOM = EXAM_ROOM;
    }

    public void setPACS_UPLOAD_STATUS_NAME(String PACS_UPLOAD_STATUS_NAME) {
        this.PACS_UPLOAD_STATUS_NAME = PACS_UPLOAD_STATUS_NAME;
    }

    public void setCONSULTATION_DATE(String CONSULTATION_DATE) {
        this.CONSULTATION_DATE = CONSULTATION_DATE;
    }

    public void setDELETE_DATE(String DELETE_DATE) {
        this.DELETE_DATE = DELETE_DATE;
    }

    public void setEXAM_DEPT_CODE(String EXAM_DEPT_CODE) {
        this.EXAM_DEPT_CODE = EXAM_DEPT_CODE;
    }

    public String getREPORT_DATETIME() {
        return REPORT_DATETIME;
    }

    public String getFROM_TYPE() {
        return FROM_TYPE;
    }

    public String getCONSULTATION_STATUS_NAME() {
        return CONSULTATION_STATUS_NAME;
    }

    public String getCASE_HISTORY() {
        return CASE_HISTORY;
    }

    public String getINSURANCE_TYPE() {
        return INSURANCE_TYPE;
    }

    public String getITEM_NAME() {
        return ITEM_NAME;
    }

    public String getPHYS_SIGN() {
        return PHYS_SIGN;
    }

    public String getIMAGE_STATUS_NAME() {
        return IMAGE_STATUS_NAME;
    }

    public String getEXAM_NO() {
        return EXAM_NO;
    }

    public String getCHARGE_TYPE() {
        return CHARGE_TYPE;
    }

    public String getUSING_STATUS() {
        return USING_STATUS;
    }

    public int getWEIGHT() {
        return WEIGHT;
    }

    public String getAPPLY_DOCTOR_NAME() {
        return APPLY_DOCTOR_NAME;
    }

    public String getBIRTHDAY() {
        return BIRTHDAY;
    }

    public String getDOCTOR_NAME() {
        return DOCTOR_NAME;
    }

    public String getIS_ABNORMAL() {
        return IS_ABNORMAL;
    }

    public String getRIS_UPLOAD_STATUS_NAME() {
        return RIS_UPLOAD_STATUS_NAME;
    }

    public String getCONSULTATION_HOSPITAL_CODE() {
        return CONSULTATION_HOSPITAL_CODE;
    }

    public String getREQ_DOCTOR_CODE() {
        return REQ_DOCTOR_CODE;
    }

    public String getFINDINGS() {
        return FINDINGS;
    }

    public String getDELETE_USER_UID() {
        return DELETE_USER_UID;
    }

    public String getEXAM_UID() {
        return EXAM_UID;
    }

    public String getREQ_DEPT_NAME() {
        return REQ_DEPT_NAME;
    }

    public String getID_NUMBER() {
        return ID_NUMBER;
    }

    public String getSEX() {
        return SEX;
    }

    public String getDEVICE_UID() {
        return DEVICE_UID;
    }

    public String getVISIT_NO() {
        return VISIT_NO;
    }

    public String getCONSULTATION_DOCTOR_NAME() {
        return CONSULTATION_DOCTOR_NAME;
    }

    public String getEDIT_DATE() {
        return EDIT_DATE;
    }

    public String getEXAM_DEPT_NAME() {
        return EXAM_DEPT_NAME;
    }

    public String getDEPT_EXAM_NO() {
        return DEPT_EXAM_NO;
    }

    public String getCHECK_DOCTOR_NAME() {
        return CHECK_DOCTOR_NAME;
    }

    public String getEDIT_USER_UID() {
        return EDIT_USER_UID;
    }

    public String getCONSULTATION_UID() {
        return CONSULTATION_UID;
    }

    public String getCLIN_DIAG() {
        return CLIN_DIAG;
    }

    public String getAPPLY_DATETIME() {
        return APPLY_DATETIME;
    }

    public String getCONSULTATION_FINDINGS() {
        return CONSULTATION_FINDINGS;
    }

    public String getAUTOMATIC_DIAGNOSIS() {
        return AUTOMATIC_DIAGNOSIS;
    }

    public String getCREATE_USER_UID() {
        return CREATE_USER_UID;
    }

    public String getPATIENT_UID() {
        return PATIENT_UID;
    }

    public String getEXAM_SUB_CLASS() {
        return EXAM_SUB_CLASS;
    }

    public String getREPORT_DOCTOR_NAME() {
        return REPORT_DOCTOR_NAME;
    }

    public String getHOME_ADDRESS() {
        return HOME_ADDRESS;
    }

    public String getCONCLUSIONS() {
        return CONCLUSIONS;
    }

    public String getHOSPITAL_CODE() {
        return HOSPITAL_CODE;
    }

    public String getEXAM_DOCTOR_NAME() {
        return EXAM_DOCTOR_NAME;
    }

    public String getSEX_NAME() {
        return SEX_NAME;
    }

    public String getDANGER_MSG() {
        return DANGER_MSG;
    }

    public String getPATIENT_SOURCE() {
        return PATIENT_SOURCE;
    }

    public String getREPORT_DOCTOR_UID() {
        return REPORT_DOCTOR_UID;
    }

    public String getNATION() {
        return NATION;
    }

    public String getPATIENT_SOURCE_NAME() {
        return PATIENT_SOURCE_NAME;
    }

    public String getCONSULTATION_STATUS() {
        return CONSULTATION_STATUS;
    }

    public String getREQ_DOCTOR_NAME() {
        return REQ_DOCTOR_NAME;
    }

    public String getEXAM_CLASS() {
        return EXAM_CLASS;
    }

    public int getEXAM_AGE() {
        return EXAM_AGE;
    }

    public String getNATIVE_PLACE() {
        return NATIVE_PLACE;
    }

    public String getCONSULTATION_HOSPITAL_NAME() {
        return CONSULTATION_HOSPITAL_NAME;
    }

    public String getPHOTO() {
        return PHOTO;
    }

    public String getREQ_DATETIME() {
        return REQ_DATETIME;
    }

    public int getPRINT_NUM() {
        return PRINT_NUM;
    }

    public String getPRINT_STATUS() {
        return PRINT_STATUS;
    }

    public String getITEM_CODE() {
        return ITEM_CODE;
    }

    public String getRE_CODE() {
        return RE_CODE;
    }

    public String getROOM_NO() {
        return ROOM_NO;
    }

    public String getMAILING_ADDRESS() {
        return MAILING_ADDRESS;
    }

    public String getNAME() {
        return NAME;
    }

    public int getDELETE_FLAG() {
        return DELETE_FLAG;
    }

    public String getCREATE_DATE() {
        return CREATE_DATE;
    }

    public String getCHECK_DOCTOR_CODE() {
        return CHECK_DOCTOR_CODE;
    }

    public String getINP_NO() {
        return INP_NO;
    }

    public int getPACS_UPLOAD_STATUS() {
        return PACS_UPLOAD_STATUS;
    }

    public String getACCESSIONNUMBER() {
        return ACCESSIONNUMBER;
    }

    public String getPATIENT_ID() {
        return PATIENT_ID;
    }

    public String getEXAM_DOCTOR_UID() {
        return EXAM_DOCTOR_UID;
    }

    public String getAPPLY_HOSPITAL_NAME() {
        return APPLY_HOSPITAL_NAME;
    }

    public String getINSURANCE_CARD_NO() {
        return INSURANCE_CARD_NO;
    }

    public String getAPPLY_DOCTOR_CODE() {
        return APPLY_DOCTOR_CODE;
    }

    public String getAGE_UNIT() {
        return AGE_UNIT;
    }

    public String getZIP_CODE() {
        return ZIP_CODE;
    }

    public Double getCHARGES() {
        return CHARGES;
    }

    public String getCONSULTATION_DOCTOR_CODE() {
        return CONSULTATION_DOCTOR_CODE;
    }

    public String getCONSULTATION_CONCLUSION() {
        return CONSULTATION_CONCLUSION;
    }

    public String getNAME_PHONETIC() {
        return NAME_PHONETIC;
    }

    public String getEXAM_STATUS_NAME() {
        return EXAM_STATUS_NAME;
    }

    public String getBED_NO() {
        return BED_NO;
    }

    public String getEXAM_STATUS() {
        return EXAM_STATUS;
    }

    public String getAPPLY_HOSPITAL_CODE() {
        return APPLY_HOSPITAL_CODE;
    }

    public String getREQ_DEPT_CODE() {
        return REQ_DEPT_CODE;
    }

    public String getISTOP() {
        return ISTOP;
    }

    public String getHIS_PATIENT_ID() {
        return HIS_PATIENT_ID;
    }

    public int getIMAGE_STATUS() {
        return IMAGE_STATUS;
    }

    public String getOUTP_NO() {
        return OUTP_NO;
    }

    public String getEXAM_DATETIME() {
        return EXAM_DATETIME;
    }

    public String getCROWD_TYPE() {
        return CROWD_TYPE;
    }

    public String getCHECK_DATETIME() {
        return CHECK_DATETIME;
    }

    public int getRIS_UPLOAD_STATUS() {
        return RIS_UPLOAD_STATUS;
    }

    public String getCONTACT_TEL() {
        return CONTACT_TEL;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public String getEXAM_ROOM() {
        return EXAM_ROOM;
    }

    public String getPACS_UPLOAD_STATUS_NAME() {
        return PACS_UPLOAD_STATUS_NAME;
    }

    public String getCONSULTATION_DATE() {
        return CONSULTATION_DATE;
    }

    public String getDELETE_DATE() {
        return DELETE_DATE;
    }

    public String getEXAM_DEPT_CODE() {
        return EXAM_DEPT_CODE;
    }


}
