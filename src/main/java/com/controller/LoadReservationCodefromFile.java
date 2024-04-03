package com.controller;

import com.dto.ReservationCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

// key : userId
// 저장된 코드객체를 해쉬맵으로 가져와서 리턴
public class LoadReservationCodefromFile {
//    public static void main(String[] args) {
//        System.out.println(loadFromFile("src\\main\\java\\com\\repository\\ReservationCodeData"));
//    }
    public static Map<String, ReservationCode> loadFromFile(String fileName) {
        Map<String, ReservationCode> reservationMap = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            ReservationCode reservationCode = (ReservationCode) ois.readObject();
            reservationMap.put(reservationCode.getUserId(), reservationCode);
            System.out.println("예약 정보가 파일에서 불러와졌습니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("파일 불러오기 중 오류가 발생했습니다: " + e.getMessage());
        }
        return reservationMap;
    }

}
