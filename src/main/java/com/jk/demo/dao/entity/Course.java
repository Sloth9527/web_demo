package com.jk.demo.dao.entity;

import java.io.Serializable;

public class Course implements Serializable {
    private Integer id;

    private String cNo;

    private String cName;

    private String tNo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public Course withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcNo() {
        return cNo;
    }

    public Course withcNo(String cNo) {
        this.setcNo(cNo);
        return this;
    }

    public void setcNo(String cNo) {
        this.cNo = cNo == null ? null : cNo.trim();
    }

    public String getcName() {
        return cName;
    }

    public Course withcName(String cName) {
        this.setcName(cName);
        return this;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String gettNo() {
        return tNo;
    }

    public Course withtNo(String tNo) {
        this.settNo(tNo);
        return this;
    }

    public void settNo(String tNo) {
        this.tNo = tNo == null ? null : tNo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cNo=").append(cNo);
        sb.append(", cName=").append(cName);
        sb.append(", tNo=").append(tNo);
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
        Course other = (Course) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getcNo() == null ? other.getcNo() == null : this.getcNo().equals(other.getcNo()))
            && (this.getcName() == null ? other.getcName() == null : this.getcName().equals(other.getcName()))
            && (this.gettNo() == null ? other.gettNo() == null : this.gettNo().equals(other.gettNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getcNo() == null) ? 0 : getcNo().hashCode());
        result = prime * result + ((getcName() == null) ? 0 : getcName().hashCode());
        result = prime * result + ((gettNo() == null) ? 0 : gettNo().hashCode());
        return result;
    }
}