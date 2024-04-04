package com.controller;

import com.dto.Member;
import com.dto.ReservationCode;
import com.dto.ReservedRoom;
import com.dto.Room;

import java.util.List;
import java.util.Map;

public class DataManager {
    private LoadManager loadControl;
    private SaveManager saveControl;

    public DataManager() {
        loadControl = new LoadManager();
        saveControl = new SaveManager();
    }

    public boolean saveMember(Member ){
    }

    public boolean saveRoom(){

    }

    public boolean saveRCode(){

    }

    public boolean saveRsvRoom(){

    }

    public Map<String, ReservationCode> getRsvCode(){

    }

    public Map<Integer, ReservedRoom> getRsvRoom(){

    }

    public List<Room> getRoomInfo(){

    }

    public List<Member> getMemberInfo(){

    }


}
