package com.run.controller;

import com.controller.DataManager;
import com.dto.Room;

import java.util.List;

public class RoomInfo {
    private DataManager dataManager;

    public RoomInfo(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void roominfo() {
        // DataManager를 통해 객실 정보를 가져옴
        List<Room> rooms = dataManager.getRoomInfos();
        if (rooms.isEmpty()) {
            System.out.println("잔여 객실 정보가 없습니다.");
        } else {
            System.out.println("============");
            System.out.println("객실 정보 조회");
            System.out.println("============");

            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }
}