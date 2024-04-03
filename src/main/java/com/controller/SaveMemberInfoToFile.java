package com.controller;

import com.dto.Member;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SaveMemberInfoToFile {
    /**public static void main(String[] args) {
        String filepath = "/Users/yoondohwan/java_workspace/project/oop-Travucks/src/main/java/com/repository/memberData";
        List<Member> members = List.of(
                new Member(1, "윤도환", "서울시 노원구", "010-8011-4122"),
                new Member(2, "구민상", "서울시 동대문구", "010-1234-1234"),
                new Member(3, "이용준", "경기도 이천시", "010-2342-2319"),
                new Member(4, "신윤정", "경기도 안산시", "010-9999-0009")
        );
        saveMembersToFile(members,filepath);

    }**/

    public static void saveMembersToFile(List<Member> members, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Member member : members) {

                // Write each member's information to the file
                writer.write(member.getUserId() + "," + member.getName() + "," + member.getAddress() + "," + member.getPhone());
                writer.newLine(); // Move to the next line
            }
            System.out.println("Member information saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
