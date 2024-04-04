package com.controller;

import com.dto.ReservationCode;
import com.dto.ReservedRoom;
import com.dto.Room;

import java.io.*;
import java.util.Map;

public class SaveReservedRoomtoFile {

    public boolean getRRoomMap(Map<Integer, ReservedRoom> rRoomMap) {
        File target = new File("src/main/java/com/repository/ReservedRoomData");
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            oos.writeObject(rRoomMap);
        } catch (IOException exception) {
            return false;
        }
        return true;
    }
}
