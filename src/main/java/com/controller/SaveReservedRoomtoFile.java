package com.controller;

import com.dto.ReservationCode;
import com.dto.ReservedRoom;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SaveReservedRoomtoFile {

    public boolean saveToFile(ReservedRoom rRoom){
        File target = new File("src/main/java/com/repository/ReservedRoomData");
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(target)))){
        //try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(target, true)))){
            oos.writeObject(rRoom);
            return true;
        }catch(IOException exception){
            exception.printStackTrace();
            return false;
        }
    }
}
