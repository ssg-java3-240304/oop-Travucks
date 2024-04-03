package com.controller;

import com.dto.Member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadMemberInfofromFile {
  /** public static void main(String[] args) {
        String filePath="/Users/yoondohwan/java_workspace/project/oop-Travucks/src/main/java/com/repository/memberData";
        List<Member> lines = loadTextFile(filePath);

        // Print the loaded information
        System.out.println(lines);

    }*/


    private static List<Member> loadTextFile(String filePath) {
        List<Member>members=new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length==4){
                String userId = parts[0];
                String name = parts[1];
                String address = parts[2];
                String phone = parts[3];
                members.add(new Member(userId,name,address,phone));}
                else{
                    System.err.println("Invalid Line : "+line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return members;
    }
}




