package com.run;

import com.controller.DataManager;
import com.dto.ReservedRoom;
import com.dto.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class testKu {
    public static void main(String[] args) {
        ReservedRoom rRoom = new ReservedRoom(1, LocalDate.now(),"1", 1234,0 );
        ReservedRoom rRoom2 = new ReservedRoom(2, LocalDate.now(),"2", 5678 , 1);
        ReservedRoom rRoom3 = new ReservedRoom(3, LocalDate.now(),"3", 91011 ,2);
        ReservedRoom rRoom4 = new ReservedRoom(4, LocalDate.now(),"4", 911 ,3);
        DataManager data = new DataManager();

        Map<Integer, ReservedRoom> rRoomMap = new HashMap<>();
        rRoomMap.put(rRoom.getRoomId(), rRoom);
        rRoomMap.put(rRoom2.getRoomId(), rRoom2);
        rRoomMap.put(rRoom3.getRoomId(), rRoom3);
        rRoomMap.put(rRoom3.getRoomId(), rRoom3);
        rRoomMap.put(rRoom4.getRoomId(), rRoom4);

        data.saveRsvRoom(rRoomMap);

        Map<Integer, ReservedRoom> loadedMap = data.getRsvRooms();

        Set<Integer> set = loadedMap.keySet();
        for(Integer roomId: set){
            System.out.println(loadedMap.get(roomId));

        }

    }
}
