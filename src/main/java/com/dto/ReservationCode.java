package com.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ReservationCode implements Serializable {

    // key: userId, value: ReservationDetails - roomNumber,reservationDate
    private String userId;
    private String roomId;
    private LocalDate reservationDate;

    public ReservationCode() {
    }

    public ReservationCode(String userId, String roomId, LocalDate reservationDate) {
        this.userId = userId;
        this.roomId = roomId;
        this.reservationDate = reservationDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationCode that = (ReservationCode) o;
        return Objects.equals(userId, that.userId) && Objects.equals(roomId, that.roomId) && Objects.equals(reservationDate, that.reservationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roomId, reservationDate);
    }

    @Override
    public String toString() {
        return "ReservationCode{" +
                "userId='" + userId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", reservationDate=" + reservationDate +
                '}';
    }
}

