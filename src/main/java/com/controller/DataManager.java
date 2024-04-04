package com.controller;

import com.dto.Member;
import com.dto.ReservationCode;
import com.dto.ReservedRoom;
import com.dto.Room;

import java.io.File;
import java.util.List;
import java.util.Map;

public class DataManager {
    final String path = "src/main/java/com/repository/";
    private LoadManager loadControl;
    private final SaveManager saveControl;


    public DataManager() {
        loadControl = new LoadManager();
        saveControl = new SaveManager();
    }

    public boolean saveMember(List<Member> member){
        if(member != null){
            saveControl.saveMembers(member, path+"memberData");
            return true;
        }else{
            System.out.println("회원저장 실패, 회원 정보를 찾을수 없습니다");
            return false;
        }
    }

    public boolean saveRoom(Room room){
        if(room != null){
            saveControl.saveRoom(room);
            return true;
        }else{
            System.out.println("객실 정보 저장 실패, 객실 정보를 찾을수 없습니다");
            return false;
        }
    }

    public boolean saveRsvCode(Map<String, ReservationCode> rsvCodeMap){
        if(rsvCodeMap != null) {
            saveControl.saveReservationCodes(rsvCodeMap, path + "ReservationCode");
            return true;
        }else{
            System.out.println("예약코드 저장 실패, 예약 코드를 찾을 수 없습니다 ");
            return false;
        }
    }

    public boolean saveRsvRoom(Map<Integer, ReservedRoom> rsvRoomMap){
        if(rsvRoomMap!=null){
           saveControl.saveReservedRoomMap(rsvRoomMap);
            return true;
        }else{
            System.out.println("객실 예약 정보 저장 실패, 예약객실 정보를 찾을 수 없습니다");
            return false;
        }
    }

    public Map<String, ReservationCode> getRsvCodes(){
        Map<String, ReservationCode> RsvCodeMap =  loadControl.resCode(path+"ReservationCode");
        if(RsvCodeMap != null)
            return RsvCodeMap;
        else {
            System.out.println("예약코드 불러오기에 실패 했습니다");
            return null;
        }
    }

    public Map<Integer, ReservedRoom> getRsvRooms(){
        Map<Integer, ReservedRoom> RsvRoomMap = loadControl.resRoomInfo();
        if(RsvRoomMap != null)
            return RsvRoomMap;
        else{
            System.out.println("객실 예약정보 불러오기에 실패했습니다");
            return null;
        }
    }

    public List<Room> getRoomInfos(){

        List<Room> rooms = loadControl.roomInfo();
        if(rooms != null){
            return rooms;
        }else{
            System.out.println("객실 정보 불러오기에 실패했습니다");
            return null;
        }
    }

    public List<Member> getMemberInfos(){
        List<Member> members = loadControl.memberInfo(path+"memberData");
        if(members != null){
            return members;
        }else{
            System.out.println();
            return null;
        }
    }


}
