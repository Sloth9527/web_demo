package com.jk.demo.dao.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FlywaySchemaHistory implements Serializable {
    private Integer installedRank;

    private String version;

    private String description;

    private String type;

    private String script;

    private Integer checksum;

    private String installedBy;

    private LocalDateTime installedOn;

    private Integer executionTime;

    private Boolean success;

    private static final long serialVersionUID = 1L;

    public Integer getInstalledRank() {
        return installedRank;
    }

    public FlywaySchemaHistory withInstalledRank(Integer installedRank) {
        this.setInstalledRank(installedRank);
        return this;
    }

    public void setInstalledRank(Integer installedRank) {
        this.installedRank = installedRank;
    }

    public String getVersion() {
        return version;
    }

    public FlywaySchemaHistory withVersion(String version) {
        this.setVersion(version);
        return this;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getDescription() {
        return description;
    }

    public FlywaySchemaHistory withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getType() {
        return type;
    }

    public FlywaySchemaHistory withType(String type) {
        this.setType(type);
        return this;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getScript() {
        return script;
    }

    public FlywaySchemaHistory withScript(String script) {
        this.setScript(script);
        return this;
    }

    public void setScript(String script) {
        this.script = script == null ? null : script.trim();
    }

    public Integer getChecksum() {
        return checksum;
    }

    public FlywaySchemaHistory withChecksum(Integer checksum) {
        this.setChecksum(checksum);
        return this;
    }

    public void setChecksum(Integer checksum) {
        this.checksum = checksum;
    }

    public String getInstalledBy() {
        return installedBy;
    }

    public FlywaySchemaHistory withInstalledBy(String installedBy) {
        this.setInstalledBy(installedBy);
        return this;
    }

    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy == null ? null : installedBy.trim();
    }

    public LocalDateTime getInstalledOn() {
        return installedOn;
    }

    public FlywaySchemaHistory withInstalledOn(LocalDateTime installedOn) {
        this.setInstalledOn(installedOn);
        return this;
    }

    public void setInstalledOn(LocalDateTime installedOn) {
        this.installedOn = installedOn;
    }

    public Integer getExecutionTime() {
        return executionTime;
    }

    public FlywaySchemaHistory withExecutionTime(Integer executionTime) {
        this.setExecutionTime(executionTime);
        return this;
    }

    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    public Boolean getSuccess() {
        return success;
    }

    public FlywaySchemaHistory withSuccess(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", installedRank=").append(installedRank);
        sb.append(", version=").append(version);
        sb.append(", description=").append(description);
        sb.append(", type=").append(type);
        sb.append(", script=").append(script);
        sb.append(", checksum=").append(checksum);
        sb.append(", installedBy=").append(installedBy);
        sb.append(", installedOn=").append(installedOn);
        sb.append(", executionTime=").append(executionTime);
        sb.append(", success=").append(success);
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
        FlywaySchemaHistory other = (FlywaySchemaHistory) that;
        return (this.getInstalledRank() == null ? other.getInstalledRank() == null : this.getInstalledRank().equals(other.getInstalledRank()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getScript() == null ? other.getScript() == null : this.getScript().equals(other.getScript()))
            && (this.getChecksum() == null ? other.getChecksum() == null : this.getChecksum().equals(other.getChecksum()))
            && (this.getInstalledBy() == null ? other.getInstalledBy() == null : this.getInstalledBy().equals(other.getInstalledBy()))
            && (this.getInstalledOn() == null ? other.getInstalledOn() == null : this.getInstalledOn().equals(other.getInstalledOn()))
            && (this.getExecutionTime() == null ? other.getExecutionTime() == null : this.getExecutionTime().equals(other.getExecutionTime()))
            && (this.getSuccess() == null ? other.getSuccess() == null : this.getSuccess().equals(other.getSuccess()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInstalledRank() == null) ? 0 : getInstalledRank().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getScript() == null) ? 0 : getScript().hashCode());
        result = prime * result + ((getChecksum() == null) ? 0 : getChecksum().hashCode());
        result = prime * result + ((getInstalledBy() == null) ? 0 : getInstalledBy().hashCode());
        result = prime * result + ((getInstalledOn() == null) ? 0 : getInstalledOn().hashCode());
        result = prime * result + ((getExecutionTime() == null) ? 0 : getExecutionTime().hashCode());
        result = prime * result + ((getSuccess() == null) ? 0 : getSuccess().hashCode());
        return result;
    }
}