package com.dto;

public class Member {
    //userId:int
    private String userId;
    //name:String
    private String name;
    //address:String
    private String address;
    //phone:String
    private String phone;

    public Member() {
    }

    public Member(String userId, String name, String address, String phone) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
