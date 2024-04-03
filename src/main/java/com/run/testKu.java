package com.run;

import com.controller.LoadReservedRoomfromFile;
import com.controller.SaveReservedRoomtoFile;
import com.dto.ReservedRoom;
import com.dto.Room;

import java.time.LocalDateTime;
import java.util.Map;

public class testKu {
    public static void main(String[] args) {
        ReservedRoom rRoom = new ReservedRoom(new Room(), LocalDateTime.now(),"1", 1234 );
        ReservedRoom rRoom2 = new ReservedRoom(new Room(), LocalDateTime.now(),"2", 5678 );
        ReservedRoom rRoom3 = new ReservedRoom(new Room(), LocalDateTime.now(),"3", 91011 );
        SaveReservedRoomtoFile save = new SaveReservedRoomtoFile();
        /*
        save.saveToFile(rRoom);
        save.saveToFile(rRoom2);
        save.saveToFile(rRoom3);

         */
        LoadReservedRoomfromFile load = new LoadReservedRoomfromFile();
        Map<Room, ReservedRoom> map = load.getRRoomMap();
        System.out.println(map);

    }
}
