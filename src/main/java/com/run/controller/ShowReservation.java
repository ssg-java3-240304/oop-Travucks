package com.run.controller;

import com.controller.DataManager;

import com.dto.ReservationCode;
import com.dto.ReservedRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowReservation {
    private DataManager dataManager;

    public ShowReservation(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void printResRoomByCode(int reservationCode) {

        Map<String, ReservationCode> reservedRooms = dataManager.getRsvCodes();
        System.out.println("예약된 정보를 확인합니다.");
        System.out.println();

        boolean found = false;

        for (ReservationCode room : reservedRooms.values()) {
            if (room.hashCode() == reservationCode) {

                System.out.println(
                        "일치하는 방 정보: 객실 번호 = " + room.getRoomId() +
                        ", 날짜 = " + room.getReservationDate() +
                        ", 아이디 = " + room.getUserId() +
                        ", 예약 코드 = " + room.hashCode());
                found = true;
            }
        }

        if (!found) {
            System.out.println("예약 코드 " + reservationCode + "에 해당하는 예약된 방이 없습니다.");
        }
    }

}
