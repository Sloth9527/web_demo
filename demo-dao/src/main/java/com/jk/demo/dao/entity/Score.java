package com.jk.demo.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Score implements Serializable {
    private Integer id;

    private String sNo;

    private String cNo;

    private BigDecimal degree;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public Score withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsNo() {
        return sNo;
    }

    public Score withsNo(String sNo) {
        this.setsNo(sNo);
        return this;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo == null ? null : sNo.trim();
    }

    public String getcNo() {
        return cNo;
    }

    public Score withcNo(String cNo) {
        this.setcNo(cNo);
        return this;
    }

    public void setcNo(String cNo) {
        this.cNo = cNo == null ? null : cNo.trim();
    }

    public BigDecimal getDegree() {
        return degree;
    }

    public Score withDegree(BigDecimal degree) {
        this.setDegree(degree);
        return this;
    }

    public void setDegree(BigDecimal degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sNo=").append(sNo);
        sb.append(", cNo=").append(cNo);
        sb.append(", degree=").append(degree);
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
        Score other = (Score) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getsNo() == null ? other.getsNo() == null : this.getsNo().equals(other.getsNo()))
            && (this.getcNo() == null ? other.getcNo() == null : this.getcNo().equals(other.getcNo()))
            && (this.getDegree() == null ? other.getDegree() == null : this.getDegree().equals(other.getDegree()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getsNo() == null) ? 0 : getsNo().hashCode());
        result = prime * result + ((getcNo() == null) ? 0 : getcNo().hashCode());
        result = prime * result + ((getDegree() == null) ? 0 : getDegree().hashCode());
        return result;
    }
}