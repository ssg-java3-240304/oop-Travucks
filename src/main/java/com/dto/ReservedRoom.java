package com.dto;

import java.io.Serializable;
import java.time.LcalDate;
import java.time.LocalDate;
import java.util.Objects;

public class  ReservedRoom implements Serializable {
    //예약된 방 정보를 담고 있는 객체
    private int roomId;
    private LocalDate datetime;
    private String userId;
    private int reservationCode;
    private int moreDays;

    public int getMoreDays() {
        return moreDays;
    }

    public void setMoreDays(int moreDays) {
        this.moreDays = moreDays;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
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

    public ReservedRoom(int roomId, LocalDate datetime, String userId, int reservationCode, int moreDays) {
        this.roomId = roomId;
        this.datetime = datetime;
        this.userId = userId;
        this.reservationCode = reservationCode;
        this.moreDays = moreDays;
    }

    public ReservedRoom() {
    }

    @Override
    public String toString(){
        return String.format("객실번호 %s, 예약일: %s , 예약자: %s, 예약코드: %d, 숙박일수: %d", this.roomId, this.datetime, this.userId, this.reservationCode, this.moreDays );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservedRoom that = (ReservedRoom) o;
        return roomId == that.roomId && reservationCode == that.reservationCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, reservationCode);
    }

    //key = 객실객체
    //value = 예약정보(날짜, UserID, 예약코드)
    //hash map으로 관리
}
