package com.rdp.template.domain;

import java.util.Date;

public class UserMaster {
    private String userId;

    private String userName;

    private String password;

    private Integer branchCode;

    private String ipAddress;

    private Short readerType;

    private String emailAdd;

    private Date passwordExprityDate;

    private Byte statusFlag;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public Short getReaderType() {
        return readerType;
    }

    public void setReaderType(Short readerType) {
        this.readerType = readerType;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd == null ? null : emailAdd.trim();
    }

    public Date getPasswordExprityDate() {
        return passwordExprityDate;
    }

    public void setPasswordExprityDate(Date passwordExprityDate) {
        this.passwordExprityDate = passwordExprityDate;
    }

    public Byte getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(Byte statusFlag) {
        this.statusFlag = statusFlag;
    }
}