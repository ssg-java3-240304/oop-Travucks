package com.run;

import com.controller.DataManager;
import com.controller.SaveRoomInfotoFile;
import com.dto.Member;
import com.dto.Room;
import com.run.controller.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static Scanner sc;

    public static void main(String[] args) {
        Application app = new Application();
        DataManager manager = new DataManager();
        ShowReservation showReservation = new ShowReservation(manager);
        CancelReservation cancelReservation = new CancelReservation(manager);

        sc = new Scanner(System.in);
        int choose=0;
       // DataManager manager = new DataManager();
        //로그인 모듈 작성 필요
        Login login=new Login(manager);
        Member logedMember = login.checkmember();    //로그인 멤버
        System.out.println(logedMember.getName()+"님 환영합니다");

        //메뉴 호출
        do{
            try{
                app.menu();
                choose = sc.nextInt();
                switch (choose){
                    case 1 :    //객실 정보 조회
                        RoomInfo roomInfo = new RoomInfo(manager);
                        roomInfo.roominfo();
                        break;
                    case 2 :    //객실예약
                        DataManager dataManager = new DataManager(); // 데이터 매니저 생성
                        RoomSearch roomSearch = new RoomSearch(logedMember,manager);
                        roomSearch.makeReservation();
                        break;
                    case 3 :    //예약한 객실 조회
                        showReservation.printResRoomByCode(logedMember.getUserId());
                        break;
                    case 4 :    //예약 취소
                        cancelReservation.cancel(logedMember);
                        break;
                    case 5 :    //종료
                        return;
                    default :
                        System.out.println("잘못 입력 하셨습니다");
                }
            }catch (InputMismatchException e){
                System.out.println("잘못 입력하셨습니다");
                sc.nextLine();
            }
        }while(true);
    }

    public void menu(){
        String menustr = """
                ========================
                원하시는 메뉴를 선택 하세요
                ========================
                1. 객실 정보 조회
                2. 객실 예약
                3. 예약한 객실 조회
                4. 예약 취소
                5. 종료
                ========================""";
        System.out.println(menustr);
    }
}
