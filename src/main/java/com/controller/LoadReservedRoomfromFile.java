package com.controller;

import com.dto.ReservedRoom;
import com.dto.Room;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoadReservedRoomfromFile {
    public Map<Room, ReservedRoom> getRRoomMap(){
        Map<Room, ReservedRoom> rRoomMap = new HashMap<>();

        File target = new File("src/main/java/com/repository/ReservedRoomData");
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(target))){
            while(true) {
                Object obj = ois.readObject();
                ReservedRoom rRoom = (ReservedRoom) obj;
                System.out.println(obj);
                rRoomMap.put(rRoom.getRoom(), rRoom);
            }
        } catch (EOFException e){
            return rRoomMap;
        } catch(IOException | ClassNotFoundException e){
            //multicatch절 : 부모/ 자식관계가 아닌 타입을 n개 나열
            e.printStackTrace();
        }
        return null;
    }

}
