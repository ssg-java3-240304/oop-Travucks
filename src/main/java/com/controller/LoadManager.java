package com.controller;

import com.dto.Member;
import com.dto.ReservationCode;
import com.dto.ReservedRoom;
import com.dto.Room;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoadManager {
    public List<Member> memberInfo(String Filepath){

        LoadMemberInfofromFile member = new LoadMemberInfofromFile();
        List<Member> members = member.loadTextFile(Filepath);
        return members;

    }
    public List<ReservationCode> resCode(String Filepath){

        LoadReservationCodefromFile codes = new LoadReservationCodefromFile();
        List<ReservationCode> code = codes.loadFromFile(Filepath);
        return code;
    }
    public Map<Integer,ReservedRoom> resRoomInfo(){
        LoadReservedRoomfromFile loader = new LoadReservedRoomfromFile();
        Map<Integer, ReservedRoom> rRoomMap = loader.getRRoomMap();
        if (rRoomMap == null) {
            return null;
        }
        return rRoomMap;

    }
    public List<Room> roomInfo() {
        LoadRoomInfofromFile loader = new LoadRoomInfofromFile();
        try {
            List<Room> rooms = loader.loadRoom();
            return rooms;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
