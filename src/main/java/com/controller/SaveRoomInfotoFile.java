package com.controller;

import com.dto.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveRoomInfotoFile {
    public void saveRoom(List<Room> rooms) {
        File target = new File("src/main/java/com/repository/RoomData");
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            oos.writeObject(rooms);
            System.out.println("객실 정보가 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
