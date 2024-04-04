package com.run;

import com.controller.LoadReservedRoomfromFile;
import com.controller.SaveReservedRoomtoFile;
import com.dto.ReservedRoom;
import com.dto.Room;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class testKu {
    public static void main(String[] args) {
        ReservedRoom rRoom = new ReservedRoom(1, LocalDateTime.now(),"1", 1234,0 );
        ReservedRoom rRoom2 = new ReservedRoom(2, LocalDateTime.now(),"2", 5678 , 1);
        ReservedRoom rRoom3 = new ReservedRoom(3, LocalDateTime.now(),"3", 91011 ,2);
        ReservedRoom rRoom4 = new ReservedRoom(4, LocalDateTime.now(),"4", 911 ,3);
        SaveReservedRoomtoFile save = new SaveReservedRoomtoFile();

        Map<Integer, ReservedRoom> rRoomMap = new HashMap<>();
        rRoomMap.put(rRoom.getRoomId(), rRoom);
        rRoomMap.put(rRoom2.getRoomId(), rRoom2);
        rRoomMap.put(rRoom3.getRoomId(), rRoom3);
        rRoomMap.put(rRoom3.getRoomId(), rRoom3);
        rRoomMap.put(rRoom4.getRoomId(), rRoom4);

        save.getRRoomMap(rRoomMap);

        LoadReservedRoomfromFile load = new LoadReservedRoomfromFile();
        Map<Integer, ReservedRoom> loadedMap = load.getRRoomMap();

        Set<Integer> set = loadedMap.keySet();
        for(Integer roomId: set){
            System.out.println(loadedMap.get(roomId));

        }

    }
}
