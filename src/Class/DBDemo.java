import java.sql.*;
import java.util.Scanner;

public class DBDemo {
    public static void main(String[] args) {
        try {
            // dynamically loading the class files
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connection dbConn = DriverManager.getConnection("jdbc:mysql://<host>:<port>/<dbname>>","<username>","<password>");
            Connection dbConn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/sql4397391","sql4397391", "qwerty");
            System.out.println("Connected.");
            Statement stmt = dbConn.createStatement();
            try {
                stmt.execute("create table TVChannels (chname varchar(25),chtype varchar(20),chfrequency int)");
                System.out.println("Table Created.");
            }catch(SQLException e) {
                System.out.println(e.getMessage());
            }
            dbConn.setAutoCommit(false);
            PreparedStatement pstmt = dbConn.prepareStatement("insert into TVChannels values (?,?,?)");
            String chname, chtype;
            int chfreq;
            Scanner input = new Scanner(System.in);
            for(int i=1;i<=3;i++) {
                System.out.print("Enter Channel Name: ");
                chname = input.next();
                System.out.print("Enter Channel Type: ");
                chtype = input.next();
                System.out.print("Enter Channel Freq: ");
                chfreq = input.nextInt();
                pstmt.setString(1, chname);
                pstmt.setString(2, chtype);
                pstmt.setInt(3, chfreq);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            dbConn.commit();
            //stmt.executeUpdate("insert into TVChannels values ('" + chname + "','" + chtype + "'," + chfreq +")");
            stmt.executeUpdate("insert into TVChannels values ('NickJr', 'Kids', 54265)");
            System.out.println("Record(s) Inserted.");
            ResultSet rs = stmt.executeQuery("select * from TVChannels");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1).toUpperCase() + "\t" + rsmd.getColumnName(2).toUpperCase() + "\t" + rsmd.getColumnName(3).toUpperCase() + "\n--------------------------------------------------------------");
            while(rs.next())
                System.out.println(rs.getString(1) +"\t"+ rs.getString(2) +"\t"+ rs.getInt(3));

            rs.close();
            pstmt.close();
            stmt.close();
            dbConn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
//        try {
//            // dynamically loading the class files
//            Class.forName("com.mysql.cj.jdbc.Driver");
////            Connection dbConn = DriverManager.getConnection("jdbc:mysql://<host>:<port>/<dbname>>","<username>","<password>");
//            Connection dbConn = DriverManager.getConnection("jdbc:mysql://sql4.freesqldatabase.com:3306/sql4397391","sql4397391","");//                                                 "lpKWCA68bT");
//            System.out.println("Connected Successfully !!");
//            Statement stmt = dbConn.createStatement();
//            try {
//                stmt.execute("create table TVChannels (chname varchar(25),chtype varchar(20),chfrequency int)");
//                System.out.println("Table Created Successfully");
//            }catch(SQLException e) {
//                System.out.println(e.getMessage());
//            }
//            String chname, chtype;
//            int chfreq;
//            System.out.print("Enter Channel Name: ");
//            Scanner input = new Scanner(System.in);
//            chname = input.next();
//            System.out.print("Enter Channel Type: ");
//            chtype = input.next();
//            System.out.print("Enter Channel Frequency: ");
//            chfreq = input.nextInt();
//            PreparedStatement pstmt = dbConn.prepareStatement("insert into TVChannels values (?, ?, ?)");
//            pstmt.setString(1,chname);
//            pstmt.setString(2,chtype);
//            pstmt.setInt(3,chfreq);
//            pstmt.executeUpdate();
////            stmt.executeUpdate("insert into TVChannels values ('"+ chname + "','" + chtype + "'," + chfreq + ")");
//            System.out.println("1 Row Inserted");
//            ResultSet rs = stmt.executeQuery("select * from TVChannels");
//            while(rs.next())
//                System.out.println(rs.getString(1) + "\t" + rs.getString(2) +"\t" + rs.getInt(3));
//        }catch(ClassNotFoundException e){
//            System.out.println(e);
//        }catch(SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}