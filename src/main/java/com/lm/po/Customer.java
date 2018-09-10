package com.lm.po;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class Customer {
    private Short customerId;

    private Byte storeId;

    @Pattern(regexp = "(^[a-zA-Z0-9_-]{3,10}$)|(^[\\u2E80-\\u9FFF]{1,2}$)",message = "{customer_firstName}")
    private String firstName;

    @Pattern(regexp = "(^[a-zA-Z0-9_-]{3,10}$)|(^[\\u2E80-\\u9FFF]{1,2}$)",message = "{customer_lastName}")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z\\d]+(\\.[a-zA-Z\\d]+)*@([\\da-zA-Z](-[\\da-zA-Z])?)+(\\.{1,2}[a-zA-Z]+)+$",message = "{customer_email}")
    private String email;

    private Short addressId;

    private Boolean active;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;

    public Short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Short customerId) {
        this.customerId = customerId;
    }

    public Byte getStoreId() {
        return storeId;
    }

    public void setStoreId(Byte storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Short getAddressId() {
        return addressId;
    }

    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}