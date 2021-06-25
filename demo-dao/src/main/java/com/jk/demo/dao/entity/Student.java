package com.jk.demo.dao.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Student implements Serializable {
    private Integer id;

    private String sNo;

    private String sName;

    private String sSex;

    private LocalDateTime sBirthday;

    private String classNum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public Student withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsNo() {
        return sNo;
    }

    public Student withsNo(String sNo) {
        this.setsNo(sNo);
        return this;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo == null ? null : sNo.trim();
    }

    public String getsName() {
        return sName;
    }

    public Student withsName(String sName) {
        this.setsName(sName);
        return this;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getsSex() {
        return sSex;
    }

    public Student withsSex(String sSex) {
        this.setsSex(sSex);
        return this;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex == null ? null : sSex.trim();
    }

    public LocalDateTime getsBirthday() {
        return sBirthday;
    }

    public Student withsBirthday(LocalDateTime sBirthday) {
        this.setsBirthday(sBirthday);
        return this;
    }

    public void setsBirthday(LocalDateTime sBirthday) {
        this.sBirthday = sBirthday;
    }

    public String getClassNum() {
        return classNum;
    }

    public Student withClassNum(String classNum) {
        this.setClassNum(classNum);
        return this;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum == null ? null : classNum.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sNo=").append(sNo);
        sb.append(", sName=").append(sName);
        sb.append(", sSex=").append(sSex);
        sb.append(", sBirthday=").append(sBirthday);
        sb.append(", classNum=").append(classNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getsNo() == null ? other.getsNo() == null : this.getsNo().equals(other.getsNo()))
            && (this.getsName() == null ? other.getsName() == null : this.getsName().equals(other.getsName()))
            && (this.getsSex() == null ? other.getsSex() == null : this.getsSex().equals(other.getsSex()))
            && (this.getsBirthday() == null ? other.getsBirthday() == null : this.getsBirthday().equals(other.getsBirthday()))
            && (this.getClassNum() == null ? other.getClassNum() == null : this.getClassNum().equals(other.getClassNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getsNo() == null) ? 0 : getsNo().hashCode());
        result = prime * result + ((getsName() == null) ? 0 : getsName().hashCode());
        result = prime * result + ((getsSex() == null) ? 0 : getsSex().hashCode());
        result = prime * result + ((getsBirthday() == null) ? 0 : getsBirthday().hashCode());
        result = prime * result + ((getClassNum() == null) ? 0 : getClassNum().hashCode());
        return result;
    }
}