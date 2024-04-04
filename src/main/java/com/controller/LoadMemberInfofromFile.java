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


    public static List<Member> loadTextFile(String filePath) {
        List<Member>members=new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length==5){
                String userId = parts[0];
                String userCode =parts[1];
                String name = parts[2];
                String address = parts[3];
                String phone = parts[4];
                members.add(new Member(userId,userCode,name,address,phone));}
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




