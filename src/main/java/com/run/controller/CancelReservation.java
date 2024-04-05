package com.run.controller;

import com.controller.DataManager;
import com.dto.Member;
import com.dto.ReservationCode;
import com.dto.ReservedRoom;

import java.util.Map;
import java.util.Scanner;

public class CancelReservation {
    private DataManager dataManager;
    private Scanner sc = new Scanner(System.in);
    public CancelReservation(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void cancel(Member member){
        //member를 키값으로 모든 예약정보를 출력함
        Map<String, ReservationCode> rsvCodes = dataManager.getRsvCodes();
        Map<Integer, ReservedRoom> rsvRooms = dataManager.getRsvRooms();
        ReservationCode rsvCode = rsvCodes.get(member.getUserId()); //유저 키값으로 예약코드 조회
        if(rsvCode != null) {
            System.out.println(member.getName() + "님의 예약 정보 입니다");
            System.out.println(rsvCode + " " + rsvCode.hashCode());
            System.out.println("삭제 하시겠습니까?\n(Y/N) :");
            if (sc.next().equalsIgnoreCase("y")) {   //삭제 입력
                for (Map.Entry<Integer, ReservedRoom> entry : rsvRooms.entrySet()) {
                    int roomId = entry.getKey();
                    ReservedRoom rRoom = entry.getValue();

                    if (rRoom.getReservationCode() == rsvCode.hashCode()) {   //예약코드를 비교
                        rsvRooms.remove(roomId);    //같은 예약코드를 가진 주문을 객실예약 맵에서 삭제
                        break;
                    }
                }
                //예약코드 삭제
                rsvCodes.remove(member.getUserId());
                dataManager.saveRsvRoom(rsvRooms);
                dataManager.saveRsvCode(rsvCodes);
            } else {
                return;
            }
        }else{
            System.out.println("예약정보가 없습니다");
        }
    }
}