package com.run.controller;

import com.controller.DataManager;
import com.dto.Member;
import com.dto.ReservationCode;
import com.dto.ReservedRoom;

import java.util.Map;

public class CancelReservation {
    private DataManager dataManager;
    public CancelReservation(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void Cancel(Member member){
        //member를 키값으로 모든 예약정보를 출력함
        Map<String, ReservationCode> rsvCodes = dataManager.getRsvCodes();
        ReservationCode rsvCode = rsvCodes.get(member.getUserCode()); //유저 키값으로 예약코드 조회



    }
}
