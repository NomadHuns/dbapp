package dbtest.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/metadb", "root", "1234");
            conn.setAutoCommit(false);
            System.out.println("DB 연결성공");
            return conn;
        } catch (Exception e) {
            System.out.println("DB 연결실패");
            e.printStackTrace();
            return null;
        }
    }
}
