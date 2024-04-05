package com.run.controller;

import com.controller.DataManager;

import com.dto.ReservationCode;
import com.dto.ReservedRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShowReservation {
    private DataManager dataManager;

    public ShowReservation(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void printResRoomByCode(String id) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, ReservedRoom> reservedRooms = dataManager.getRsvRooms();
        boolean found = false;

        System.out.println("예약된 정보를 확인합니다.");
        System.out.println();
        for (ReservedRoom room : reservedRooms.values()) {
            if(room.getUserId().equals(id)){
                System.out.println(
                        "예약 코드 = " + room.getReservationCode());
                found = true;
                break;
            }
        }
        if(found == false)
            System.out.println("예약 정보가 없습니다.");

        found = false;
        System.out.println("예약 코드를 입력해주세요.");
        int rcode = sc.nextInt();

        for (ReservedRoom room : reservedRooms.values()) {
            if (room.getReservationCode() == rcode) {

                System.out.println(
                        "일치하는 방 정보: 객실 번호 = " + room.getRoomId() +
                        ", 날짜 = " + room.getDatetime() +
                        ", 아이디 = " + room.getUserId() +
                        ", 예약 코드 = " + room.getReservationCode());
                found = true;
            }
        }

        if (!found) {
            System.out.println("예약 코드 " + rcode + "에 해당하는 예약된 방이 없습니다.");
        }
    }

}
