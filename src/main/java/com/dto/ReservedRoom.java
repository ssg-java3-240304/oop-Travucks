package com.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ReservedRoom implements Serializable {
    //예약된 방 정보를 담고 있는 객체
    private Room room;
    private LocalDateTime datetime;
    private String userId;
    private int reservationCode;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(int reservationCode) {
        this.reservationCode = reservationCode;
    }

    public ReservedRoom(Room room, LocalDateTime datetime, String userId, int reservationCode) {
        this.room = room;
        this.datetime = datetime;
        this.userId = userId;
        this.reservationCode = reservationCode;
    }

    public ReservedRoom() {
    }
//key = 객실객체
    //value = 예약정보(날짜, UserID, 예약코드)
    //hash map으로 관리
}
