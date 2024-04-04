package com.run.controller;

import com.controller.DataManager;
import com.controller.LoadMemberInfofromFile;
import com.dto.Member;

import java.util.List;
import java.util.Scanner;


public class Login {
    private DataManager dataManager;

    public Login(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public Member checkmember() {
        Scanner sc = new Scanner(System.in);
        Member loggedInmember = null;
        while (loggedInmember == null) {
            System.out.println("아이디를 입력하세요 : ");
            String id = sc.nextLine();
            LoadMemberInfofromFile lmif = new LoadMemberInfofromFile();
            List<Member> members = lmif.loadTextFile("/Users/yoondohwan/java_workspace/project/oop-Travucks/src/main/java/com/repository/memberData");
            Member loggedInMember = findMember(id, members);
            if (loggedInMember != null) {
                System.out.println("로그인 되었습니다. 회원 정보: " + loggedInMember);
                break;
            } else {
                System.out.println("아이디가 없습니다. 다시 입력해주세요 : ");
            }
        }
            return loggedInmember;
        }


    private static Member findMember(String id, List<Member> members) {
        for (Member member : members) {
            if (member.getUserId().equals(id)) {
                return member;
            }
        }
        return null;
    }
}
