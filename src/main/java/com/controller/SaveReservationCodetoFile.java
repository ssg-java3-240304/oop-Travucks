package com.controller;

import com.dto.ReservationCode;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

// Reservationcode의 객체를  ReservationCodeData 파일에 객체저장
public class SaveReservationCodetoFile {
//    public static void main(String[] args) {
//        saveToFile("src\\main\\java\\com\\repository\\ReservationCodeData",new ReservationCode("이용준","201호", LocalDate.of(2024,04,2)));
//
//    }
    public static boolean saveToFile(String fileName, ReservationCode reservationCode) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(reservationCode);

            System.out.println("예약 정보가 파일에 저장되었습니다.");
            return true; // 파일 저장 성공
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
            return false; // 파일 저장 실패
        }
    }
}
