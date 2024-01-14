package Class;

import java.nio.file.Path;
import java.nio.file.Paths;

// static import

public class NIODemo {
    public static void main(String[] args) {
/*
        Path p = Paths.get("/home/sss/Desktop/../IdeaProjects");
        System.out.println(p);
        System.out.println(p.normalize());

        Path p1 = p.resolve("/JavaCSE406/src");
        System.out.println(p1);

        Path p2 = p.normalize().subpath(1,3); //end path index is not inclusive
        System.out.println(p2);*/

        Path p4 = Paths.get("miFile").resolve("/home/yameen/Desktop");
        System.out.println(p4);
        Path p5 = Paths.get("/home/yameen/../etc/./apt/../zsh");
        System.out.println(p5.normalize());
/*
        Path p3 = Paths.get("/home/sss/Desktop/mysql-connector-java-8.0.21.jar");
        File f1 = p3.toFile();
        System.out.println("Using File class -> "+f1.length());
        System.out.println(f1.lastModified()); // milliseconds

        Path p4 = Paths.get("src/NIODemo.java");
        System.out.println(Files.exists(p4));

        Path p5 = Paths.get("/home/sss/Desktop/April/Documents/Notes");
        try {
            Files.createDirectory(p5); // for one directory mentioned at last level
            //Files.createDirectories(p5); // to complete directory structure as mentioned from root
            //Files.createFile(Paths.get("/home/sss/Desktop/MyJava.txt"));
            System.out.println("Using Files class -> "+Files.size(Paths.get("/home/sss/Desktop/Desktop/mysql-connector-java-8.0.21.jar")));
            Path sourcePath = Paths.get("/home/sss/Desktop/mysql-connector-java-8.0.21.jar");
            Path targetPath = Paths.get("/home/sss/Desktop/Desktop/mysql-connector-java-8.0.21.jar");
            //Files.move(sourcePath,targetPath, COPY_ATTRIBUTES);
            Stream<Path> directoryContent = Files.list(Paths.get("/home/sss/Desktop"));
            directoryContent.forEach(System.out::println);

        }catch(IOException e) {
            System.out.println(e);
        }

        try {
            Stream<Path> dirStructure = Files.list(Paths.get("src/"));
            dirStructure.filter((v)->v.toString().toLowerCase().endsWith(".jpg")).forEach(System.out::println);
        }catch(IOException e) {
            System.out.println(e);
        }


        try {
            Stream<Path> dirStructure = Files.walk(Paths.get("/home/sss/Desktop"),1);
            dirStructure.forEach(System.out::println);
        }catch(IOException e) {
            System.out.println(e);
        }

        try(Stream<String> fileData = Files.lines(Paths.get("src/NIODemo.java"))) {
            fileData.forEach(System.out::println);
        }catch(IOException e) {
            System.out.println(e);
        }



        try(BufferedReader reader = Files.newBufferedReader(Paths.get("src/NIODemo.java"))) {
            Stream<String> fileData = reader.lines();
            fileData.forEach(System.out::println);

//            int ch = reader.read();
//            while(ch!=-1) {
//                System.out.print((char)ch);
//                ch = reader.read();
//            }
//            reader.close();


        }catch(IOException e) {
            System.out.println(e);
        }
        Path p = Paths.get("/ghar/sss/Desktop/2021/March");
        try {
            Files.createDirectories(p);
            System.out.println("The directory "+p+" is created.");
        }catch(IOException e) {
            System.out.println(e);
        }


        try {
            Files.copy(Paths.get("/home/sss/Desktop/MyDocumentDetails.txt"),
                    Paths.get("/home/sss/Desktop/March/DocDetails.txt"),
                    REPLACE_EXISTING);
            Files.deleteIfExists(Paths.get("."));
        }catch(IOException e) {
            System.out.println(e);
        }



        Path p = Paths.get("/home/sss/IdeaProjects/JavaCSE406"); //Paths.get(".");
        try {
            Stream<Path> dirContent = Files.walk(p,1);  // Files.list(p);
            dirContent.forEach(System.out::println);
        }catch(IOException e) {
            System.out.println(e);
        }

        Path p = Paths.get("src/NIODemo.java");
        try {
            Stream<String> contents = Files.lines(p);
            contents.forEach((line)->System.out.println(line.toUpperCase()));
        }catch (IOException e) {
            System.out.println(e);
        }

        Path p22 = Paths.get("src/NIODemo.java");
        try {
            BufferedReader reader = Files.newBufferedReader(p);
            int ch = reader.read();
            while(ch!=-1) {
                System.out.print((char)ch);
                ch = reader.read();
            }
            reader.close();
        }catch (IOException e) {
            System.out.println(e);
        }*/

    }
}