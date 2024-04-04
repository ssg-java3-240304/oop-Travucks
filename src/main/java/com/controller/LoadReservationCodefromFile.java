package com.controller;

import com.dto.ReservationCode;

import java.io.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// key : userId
// 저장된 코드객체를 해쉬맵으로 가져와서 리턴
public class LoadReservationCodefromFile {
//    public static void main(String[] args) {
//
//        List<ReservationCode> reservationCodes = loadFromFile("src\\main\\java\\com\\repository\\ReservationCodeData");
//        for (ReservationCode reservationCode : reservationCodes) {
//            System.out.print(reservationCode); // 예약 정보 출력
//            System.out.println(" 해시코드: " + reservationCode.hashCode()); // 해시코드 출력
//            System.out.println(); // 줄 바꿈
//        }
//
//    }

//public static List<ReservationCode> loadFromFile(String fileName) {
//    List<ReservationCode> reservationCodes = new ArrayList<>();
//
//    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
//        String line;
//        while ((line = reader.readLine()) != null) {
//
//            String[] parts = line.split(",");
//            if (parts.length == 4) {
//                String userId = parts[0].trim();
//                String roomId = parts[1].trim();
//                LocalDate reservationDate = LocalDate.parse(parts[2].trim());
//
//                // 예약 정보 객체 생성
//                ReservationCode reservationCode = new ReservationCode(userId, roomId, reservationDate);
//                // 해시코드 설정
//                reservationCode.hashCode();
//
//                // 리스트에 추가
//                reservationCodes.add(reservationCode);
//            } else {
//                System.out.println("잘못된 형식의 데이터: " + line);
//            }
//        }
//        System.out.println("예약 정보가 파일에서 불러와졌습니다.");
//    } catch (IOException e) {
//        System.out.println("파일 불러오기 중 오류가 발생했습니다: " + e.getMessage());
//    }
//
//    return reservationCodes;
//}


    public static void main(String[] args) {
        Map<String, ReservationCode> reservationCodeMap = null;
        try {
            reservationCodeMap = loadFromFile("src\\main\\java\\com\\repository\\ReservationCodeData");

            for (Map.Entry<String, ReservationCode> entry : reservationCodeMap.entrySet()) {
                ReservationCode reservationCode = entry.getValue();
                String userId = entry.getKey();
                System.out.print("예약 정보: " + reservationCode); // 예약 정보 출력
                System.out.println(" 해시코드: " + reservationCode.hashCode()); // 해시코드 출력
            }
        } catch (IOException e) {
            System.out.println("파일 불러오기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public static Map<String, ReservationCode> loadFromFile(String fileName) throws IOException {
        Map<String, ReservationCode> reservationCodeMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String userId = parts[0].trim();
                    String roomId = parts[1].trim();
                    LocalDate reservationDate = LocalDate.parse(parts[2].trim());

                    // 예약 정보 객체 생성
                    ReservationCode reservationCode = new ReservationCode(userId, roomId, reservationDate);

                    // 해시코드 설정
                    int hashCode = reservationCode.hashCode();

                    // 맵에 추가
                    reservationCodeMap.put(userId, reservationCode);
                } else {
                    System.out.println("잘못된 형식의 데이터: " + line);
                }
            }
            System.out.println("예약 정보가 파일에서 불러와졌습니다.");
        }

        return reservationCodeMap;
    }
}