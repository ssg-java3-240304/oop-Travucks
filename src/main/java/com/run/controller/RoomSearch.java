package com.run.controller;

import com.controller.DataManager;
import com.dto.Member;
import com.dto.ReservationCode;
import com.dto.ReservedRoom;
import com.dto.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RoomSearch {
    private Member member;
    private Room selectedRoom;
    private LocalDate startDate;
    private ReservationCode reservationCode;

    private final DataManager dataManager;

    public RoomSearch(Member member, DataManager dataManager) {
        this.member = member;
        this.dataManager = dataManager;
    }

    public void makeReservation() {
        Scanner sc = new Scanner(System.in);

        // 날짜 입력 받기
        System.out.print("예약 시작 날짜를 입력하세요 (yyyy-MM-dd): ");
        String startDateString = sc.nextLine();
        // "-" 제거
        startDateString = startDateString.replace("-", "");
        startDate = LocalDate.parse(startDateString, DateTimeFormatter.ofPattern("yyyyMMdd"));

        // 머무를 일 수 입력 받기
        System.out.print("머무를 일 수를 입력하세요: ");
        int stayDays = sc.nextInt();
        sc.nextLine(); // 개행문자 제거

        // 예약 가능한 객실 찾기
        List<Room> availableRooms = findAvailableRooms(LocalDate.from(startDate), stayDays);

        // 예약 가능한 객실 출력
        System.out.println("예약 가능한 객실 목록:");
        for (int i = 0; i < availableRooms.size(); i++) {
            System.out.println((i + 1) + ". " + availableRooms.get(i));
        }

        // 사용자가 선택한 객실 번호 입력 받기
        System.out.print("예약할 객실 번호를 선택하세요: ");
        int selectedRoomIndex = sc.nextInt() - 1;
        sc.nextLine();

        // 선택한 객실 예약하기
        if (selectedRoomIndex >= 0 && selectedRoomIndex < availableRooms.size()) {
            selectedRoom = availableRooms.get(selectedRoomIndex);
            System.out.println("선택한 객실 정보: " + selectedRoom);
            System.out.println("예약을 진행합니다.");
            reservationCode = Creatrsv();
            // 예약 정보 저장
            ReservedRoom reservedRoom = new ReservedRoom(selectedRoom.getRoomID(), startDate, member.getUserId(), reservationCode.hashCode(), stayDays);
            Map<Integer, ReservedRoom> rsvRooms = dataManager.getRsvRooms();
            rsvRooms.put(reservedRoom.getRoomId(),reservedRoom);
            dataManager.saveRsvRoom(rsvRooms);

            // 예약 정보 출력
            System.out.println("예약이 완료되었습니다.");

        } else {
            System.out.println("잘못된 객실 번호입니다. 예약을 취소합니다.");
        }
    }

    private List<Room> findAvailableRooms(LocalDate startDate, int stayDays) {
        // 예약 가능한 방을 저장할 리스트
        List<Room> availableRooms = new ArrayList<>();

        // 예약 가능한 날짜 계산
        LocalDate endDate = startDate.plusDays(stayDays);

        // 예약 가능한 방 찾기
        List<Room> allRooms = dataManager.getRoomInfos();
        Map<String, ReservationCode> reservedRooms = dataManager.getRsvCodes();

        for (Room room : allRooms) {
            boolean isAvailable = true;
            for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
                String key = room.getRoomID() + "_" + date.toString();
                if (reservedRooms.containsKey(key)) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }

    public ReservationCode Creatrsv(){
        ReservationCode reservationCode = new ReservationCode();
        reservationCode.setUserId(member.getUserId());
        reservationCode.setRoomId(String.valueOf(selectedRoom.getRoomID()));
        reservationCode.setReservationDate(LocalDate.from(startDate));
        return reservationCode;
    }

}

