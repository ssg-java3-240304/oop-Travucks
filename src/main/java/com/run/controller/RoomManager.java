package com.run.controller;

import com.controller.DataManager;
import com.dto.Room;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomManager {
    public Room manager(){
        RoomManager roomManager = new RoomManager();
        DataManager dataManager = new DataManager();
        Scanner sc = new Scanner(System.in);
        int choose =0;

        do{
            try{
                roomManager.menu();
                choose = sc.nextInt();
                switch (choose){
                    case 1 :
                        break;
                    case 2 :
                        break;
                    case 3 :
                        break;
                    case 4 :
                        break;
                    case 5 :
                        break;
                    default :
                        System.out.println("잘못 입력 하셨습니다");
                }
            }catch (InputMismatchException e){
                System.out.println("잘못 입력하셨습니다");
                sc.nextLine();
            }
        }while(true);
    }

    private void menu() {
        String menustr = """
                ========================
                원하시는 메뉴를 선택 하세요
                ========================
                1. 객실 예약
                2. 객실 예약 취소
                3. 객실 정보 추가
                4. 객실 정보 삭제
                5. 종료
                ========================""";
        System.out.println(menustr);
    }
}
