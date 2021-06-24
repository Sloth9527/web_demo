package com.jk.demo.dao.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Teacher implements Serializable {
    private Integer id;

    private String tNo;

    private String tName;

    private String tSex;

    private LocalDateTime tBirthday;

    private String prof;

    private String depart;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public Teacher withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettNo() {
        return tNo;
    }

    public Teacher withtNo(String tNo) {
        this.settNo(tNo);
        return this;
    }

    public void settNo(String tNo) {
        this.tNo = tNo == null ? null : tNo.trim();
    }

    public String gettName() {
        return tName;
    }

    public Teacher withtName(String tName) {
        this.settName(tName);
        return this;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettSex() {
        return tSex;
    }

    public Teacher withtSex(String tSex) {
        this.settSex(tSex);
        return this;
    }

    public void settSex(String tSex) {
        this.tSex = tSex == null ? null : tSex.trim();
    }

    public LocalDateTime gettBirthday() {
        return tBirthday;
    }

    public Teacher withtBirthday(LocalDateTime tBirthday) {
        this.settBirthday(tBirthday);
        return this;
    }

    public void settBirthday(LocalDateTime tBirthday) {
        this.tBirthday = tBirthday;
    }

    public String getProf() {
        return prof;
    }

    public Teacher withProf(String prof) {
        this.setProf(prof);
        return this;
    }

    public void setProf(String prof) {
        this.prof = prof == null ? null : prof.trim();
    }

    public String getDepart() {
        return depart;
    }

    public Teacher withDepart(String depart) {
        this.setDepart(depart);
        return this;
    }

    public void setDepart(String depart) {
        this.depart = depart == null ? null : depart.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tNo=").append(tNo);
        sb.append(", tName=").append(tName);
        sb.append(", tSex=").append(tSex);
        sb.append(", tBirthday=").append(tBirthday);
        sb.append(", prof=").append(prof);
        sb.append(", depart=").append(depart);
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
        Teacher other = (Teacher) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.gettNo() == null ? other.gettNo() == null : this.gettNo().equals(other.gettNo()))
            && (this.gettName() == null ? other.gettName() == null : this.gettName().equals(other.gettName()))
            && (this.gettSex() == null ? other.gettSex() == null : this.gettSex().equals(other.gettSex()))
            && (this.gettBirthday() == null ? other.gettBirthday() == null : this.gettBirthday().equals(other.gettBirthday()))
            && (this.getProf() == null ? other.getProf() == null : this.getProf().equals(other.getProf()))
            && (this.getDepart() == null ? other.getDepart() == null : this.getDepart().equals(other.getDepart()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((gettNo() == null) ? 0 : gettNo().hashCode());
        result = prime * result + ((gettName() == null) ? 0 : gettName().hashCode());
        result = prime * result + ((gettSex() == null) ? 0 : gettSex().hashCode());
        result = prime * result + ((gettBirthday() == null) ? 0 : gettBirthday().hashCode());
        result = prime * result + ((getProf() == null) ? 0 : getProf().hashCode());
        result = prime * result + ((getDepart() == null) ? 0 : getDepart().hashCode());
        return result;
    }
}