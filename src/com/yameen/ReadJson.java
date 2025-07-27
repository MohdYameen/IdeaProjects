//package com.yameen;
//
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.lang.reflect.Type;
//import java.util.List;
//
//class User {
//    String name;
//    int age;
//    List<String> emailAddresses;
//}
//
//public class ReadJson {
//
//    public static void printUserWithHighestAge(String filePath) {
//        try (FileReader reader = new FileReader(filePath)) {
//            Gson gson = new Gson();
//            Type listType = new TypeToken<List<User>>() {}.getType();
//            List<User> users = gson.fromJson(reader, listType);
//
//            if (users == null || users.isEmpty()) {
//                System.out.println("No users found in the file.");
//                return;
//            }
//
//            User maxAgeUser = users.get(0);
//            for (User user : users) {
//                if (user.age > maxAgeUser.age) {
//                    maxAgeUser = user;
//                }
//            }
//
//            System.out.println("👤 User with the highest age:");
//            System.out.println("Name: " + maxAgeUser.name);
//            System.out.println("Age: " + maxAgeUser.age);
//            System.out.println("Emails:");
//            for (String email : maxAgeUser.emailAddresses) {
//                System.out.println("  - " + email);
//            }
//
//        } catch (IOException e) {
//            System.err.println("❌ Error reading JSON file: " + e.getMessage());
//        }
//    }
//
//    public static void printJsonFile(String filePath) {
//        try (FileReader reader = new FileReader(filePath)) {
//            Gson gson = new Gson();
//            Type listType = new TypeToken<List<User>>() {}.getType();
//            List<User> users = gson.fromJson(reader, listType);
//
//            for (User user : users) {
//                System.out.println("Name: " + user.name);
//                System.out.println("Age: " + user.age);
//                System.out.println("Emails:");
//                for (String email : user.emailAddresses) {
//                    System.out.println("  - " + email);
//                }
//                System.out.println();
//            }
//        } catch (IOException e) {
//            System.err.println("❌ Failed to read or parse the JSON file: " + e.getMessage());
//        }
//    }
//
//    public static void main(String[] args) {
//        String filePath = "/home/yameen/Projects/NewProject/src/com/yameen/Users.json";
//        printJsonFile(filePath);
//        System.out.println("print age");
//        printUserWithHighestAge(filePath);
//
//
////        try (FileReader reader = new FileReader(filePath)) {
////            Gson gson = new Gson();
////            Type userListType = new TypeToken<List<User>>() {}.getType();
////            List<User> users = gson.fromJson(reader, userListType);
////
////            System.out.println("Parsed Users:\n");
////
////            for (User user : users) {
////                System.out.println("Name: " + user.name);
////                System.out.println("Age: " + user.age);
////                System.out.println("Emails:");
////                for (String email : user.emailAddresses) {
////                    System.out.println("  - " + email);
////                }
////                System.out.println();
////            }
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }
//}
