package com.dto;

import java.io.Serializable;

public class Room implements Serializable {
    //roomID:int
    //name:String
    private int roomID;
    private String name;

    public Room() {
    }

    public Room(int roomID, String name) {
        this.roomID = roomID;
        this.name = name;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "객실 : " +
                " 객실 번호 = " + roomID +
                ", 객실명 ='" + name + '\'';
    }
}
