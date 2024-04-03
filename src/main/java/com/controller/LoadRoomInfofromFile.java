package com.controller;

import com.dto.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadRoomInfofromFile {
    private File source = new File("src/main/java/com/repository/RoomData");

    public List<Room> loadRoom() throws IOException {
        List<Room> rooms = new ArrayList<>();
        if (!source.exists() || source.length() == 0) {
            return rooms; // 파일이 비었거나 존재하지 않으면 빈 리스트 반환
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(source))) {
            while (true) {
                try {
                    Room room = (Room) ois.readObject();
                    rooms.add(room);
                } catch (EOFException e) {
                    break; // 파일 끝에 도달했을 때 반복을 종료합니다.
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return rooms;
    }
}
