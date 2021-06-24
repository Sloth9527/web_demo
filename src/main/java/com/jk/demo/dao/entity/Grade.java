package com.jk.demo.dao.entity;

import java.io.Serializable;

public class Grade implements Serializable {
    private Integer id;

    private Short low;

    private Short up;

    private String letterGrade;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public Grade withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getLow() {
        return low;
    }

    public Grade withLow(Short low) {
        this.setLow(low);
        return this;
    }

    public void setLow(Short low) {
        this.low = low;
    }

    public Short getUp() {
        return up;
    }

    public Grade withUp(Short up) {
        this.setUp(up);
        return this;
    }

    public void setUp(Short up) {
        this.up = up;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public Grade withLetterGrade(String letterGrade) {
        this.setLetterGrade(letterGrade);
        return this;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade == null ? null : letterGrade.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", low=").append(low);
        sb.append(", up=").append(up);
        sb.append(", letterGrade=").append(letterGrade);
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
        Grade other = (Grade) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLow() == null ? other.getLow() == null : this.getLow().equals(other.getLow()))
            && (this.getUp() == null ? other.getUp() == null : this.getUp().equals(other.getUp()))
            && (this.getLetterGrade() == null ? other.getLetterGrade() == null : this.getLetterGrade().equals(other.getLetterGrade()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLow() == null) ? 0 : getLow().hashCode());
        result = prime * result + ((getUp() == null) ? 0 : getUp().hashCode());
        result = prime * result + ((getLetterGrade() == null) ? 0 : getLetterGrade().hashCode());
        return result;
    }
}