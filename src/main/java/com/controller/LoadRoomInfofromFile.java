package com.controller;

import com.dto.Room;

import java.io.*;
import java.util.List;

public class LoadRoomInfofromFile {
    public List<Room> loadRoom() {
        File source = new File("src/main/java/com/repository/RoomData");
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(source)))) {
            return (List<Room>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
