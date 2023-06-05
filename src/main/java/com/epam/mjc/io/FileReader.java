package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    private String name;
    private int age;
    private String email;
    private long phone;
    public Profile getDataFromFile(File file) {

        try(BufferedReader br = new BufferedReader(new java.io.FileReader(file))){;
            String line;
            while ((line = br.readLine()) != null) {
                String[] keyValue = line.split(":");

                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();

                    switch (key) {
                        case "Name":
                            name = value;
                            break;
                        case "Age":
                            age = Integer.parseInt(value);
                            break;
                        case "Email":
                            email = value;
                            break;
                        case "Phone":
                            phone = Long.parseLong(value);
                            break;
                    }
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return new Profile(getName(), getAge(), getEmail(), getPhone());
    }
    public String getName(){
        return name;
    }
    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }




    }
//    public static void main(String[] args) {
//       FileReader fr = new FileReader();
//       fr.getDataFromFile(new File("C:\\Users\\aaaud_3unkhoj\\Documents\\Audrius\\Epam\\mjc-school\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt"));
//    }
