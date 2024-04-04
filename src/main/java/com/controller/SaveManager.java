package com.controller;

import com.dto.Member;
import com.dto.ReservationCode;
import com.dto.ReservedRoom;
import com.dto.Room;

import java.util.List;
import java.util.Map;

public class SaveManager {
    private SaveRoomInfotoFile roomSaver = new SaveRoomInfotoFile();
    private SaveReservedRoomtoFile reservedRoomSaver = new SaveReservedRoomtoFile();
    private SaveReservationCodetoFile reservationSaver = new SaveReservationCodetoFile();
    private SaveMemberInfoToFile memberSaver = new SaveMemberInfoToFile();

    public boolean saveRoom(Room room) {
        return roomSaver.saveRoom(room);
    }

    public boolean saveReservedRoomMap(Map<Integer, ReservedRoom> rRoomMap) {
        return reservedRoomSaver.getRRoomMap(rRoomMap);
    }

    public boolean saveReservationCodes(List<ReservationCode> reservationCodes, String fileName) {
        return reservationSaver.saveToFile(reservationCodes, fileName);
    }

    public boolean saveMembers(List<Member> members, String filePath) {
        return memberSaver.saveMembersToFile(members, filePath);
    }
}
