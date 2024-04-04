package com.controller;

import com.dto.ReservedRoom;
import com.dto.Room;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoadReservedRoomfromFile {
    public Map<Integer, ReservedRoom> getRRoomMap(){
        Map<Integer, ReservedRoom> rRoomMap = null;
        File target = new File("src/main/java/com/repository/ReservedRoomData");
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(target)))){
                Object obj = ois.readObject();
                rRoomMap = (Map<Integer, ReservedRoom>) obj;
            }
        catch (IOException e) {
            System.out.println("예약된 방 정보를 불러들이지 못했습니다");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("저장된 정보가 없습니다");
        }
        return rRoomMap;
    }

}
