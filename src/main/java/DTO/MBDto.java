package DTO;

import java.sql.Date;

public class MBDto {
    private int BOARD_NUM; 
    private String BOARD_NAME;
    private String BOARD_SUBJECT; 
    private String BOARD_CONTENT;
    private int BOARD_RE_REF; 
    private int BOARD_RE_LEV; 
    private int BOARD_RE_SEQ; 
    private int BOARD_READCOUNT; 
    private Date BOARD_DATE;
    
    
    public MBDto() {
        super();
    }
    
    public MBDto(int bOARD_NUM, String bOARD_NAME, String bOARD_SUBJECT, String bOARD_CONTENT,
            int bOARD_RE_REF, int bOARD_RE_LEV, int bOARD_RE_SEQ, int bOARD_READCOUNT,
            java.util.Date date) {
        super();
        BOARD_NUM = bOARD_NUM;
        BOARD_NAME = bOARD_NAME;
        BOARD_SUBJECT = bOARD_SUBJECT;
        BOARD_CONTENT = bOARD_CONTENT;
        BOARD_RE_REF = bOARD_RE_REF;
        BOARD_RE_LEV = bOARD_RE_LEV;
        BOARD_RE_SEQ = bOARD_RE_SEQ;
        BOARD_READCOUNT = bOARD_READCOUNT;
        BOARD_DATE = (Date) date;
    }
    public int getBOARD_NUM() {
        return BOARD_NUM;
    }
    public void setBOARD_NUM(int bOARD_NUM) {
        BOARD_NUM = bOARD_NUM;
    }
    public String getBOARD_NAME() {
        return BOARD_NAME;
    }
    public void setBOARD_NAME(String bOARD_NAME) {
        BOARD_NAME = bOARD_NAME;
    }
    public String getBOARD_SUBJECT() {
        return BOARD_SUBJECT;
    }
    public void setBOARD_SUBJECT(String bOARD_SUBJECT) {
        BOARD_SUBJECT = bOARD_SUBJECT;
    }
    public String getBOARD_CONTENT() {
        return BOARD_CONTENT;
    }
    public void setBOARD_CONTENT(String bOARD_CONTENT) {
        BOARD_CONTENT = bOARD_CONTENT;
    }
    public int getBOARD_RE_REF() {
        return BOARD_RE_REF;
    }
    public void setBOARD_RE_REF(int bOARD_RE_REF) {
        BOARD_RE_REF = bOARD_RE_REF;
    }
    public int getBOARD_RE_LEV() {
        return BOARD_RE_LEV;
    }
    public void setBOARD_RE_LEV(int bOARD_RE_LEV) {
        BOARD_RE_LEV = bOARD_RE_LEV;
    }
    public int getBOARD_RE_SEQ() {
        return BOARD_RE_SEQ;
    }
    public void setBOARD_RE_SEQ(int bOARD_RE_SEQ) {
        BOARD_RE_SEQ = bOARD_RE_SEQ;
    }
    public int getBOARD_READCOUNT() {
        return BOARD_READCOUNT;
    }
    public void setBOARD_READCOUNT(int bOARD_READCOUNT) {
        BOARD_READCOUNT = bOARD_READCOUNT;
    }
    public Date getBOARD_DATE() {
        return BOARD_DATE;
    }
    public void setBOARD_DATE(Date bOARD_DATE) {
        BOARD_DATE = bOARD_DATE;
    }
    
    
    
  
}
