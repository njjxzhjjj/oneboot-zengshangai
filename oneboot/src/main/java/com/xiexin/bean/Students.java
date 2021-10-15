package com.xiexin.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * students
 * @author 
 */
public class Students implements Serializable {
    private Integer studentId;

    private String studentName;

    private Integer studentSex;

    private String studentCardId;

    private String studentPhone;

    private String studentAddress;
    //    修改日期时间格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date studentComeDate;

    private Integer jiaoSeId;

    private static final long serialVersionUID = 1L;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(Integer studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentCardId() {
        return studentCardId;
    }

    public void setStudentCardId(String studentCardId) {
        this.studentCardId = studentCardId;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Date getStudentComeDate() {
        return studentComeDate;
    }

    public void setStudentComeDate(Date studentComeDate) {
        this.studentComeDate = studentComeDate;
    }

    public Integer getJiaoSeId() {
        return jiaoSeId;
    }

    public void setJiaoSeId(Integer jiaoSeId) {
        this.jiaoSeId = jiaoSeId;
    }
}