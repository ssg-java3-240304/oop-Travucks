package com.controller;

import com.dto.ReservationCode;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Reservationcode의 객체를  ReservationCodeData 파일에 객체저장
public class SaveReservationCodetoFile {
public static boolean saveToFile(List<ReservationCode> reservationCodes, String fileName) {
    try (FileOutputStream fos = new FileOutputStream(fileName)) {
        Map<String, ReservationCode> reservationCodeMap = new HashMap<>();
        for (ReservationCode reservationCode : reservationCodes) {
            reservationCodeMap.put(reservationCode.getUserId(), reservationCode);
        }

        // 맵의 각 값들을 파일에 저장
        for (Map.Entry<String, ReservationCode> entry : reservationCodeMap.entrySet()) {
            ReservationCode reservationCode = entry.getValue();
            String line = String.format("%s,%s,%s,%d%n",
                    reservationCode.getUserId(),
                    reservationCode.getRoomId(),
                    reservationCode.getReservationDate(),
                    reservationCode.hashCode());
            fos.write(line.getBytes());
        }

        System.out.println("예약 정보가 파일에 저장되었습니다.");
        return true; // 파일 저장 성공
    } catch (IOException e) {
        System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        return false; // 파일 저장 실패
    }
}
}
