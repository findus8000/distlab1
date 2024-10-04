package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    private static DBManager instance = null;
    private Connection conn = null;

    private static DBManager getInstance(){
        if(instance == null)
            instance = new DBManager();
        return instance;
    }

    private DBManager(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "1234");
        }catch (Exception e){ e.printStackTrace(); }
    }

    public static Connection getConnection(){
        return getInstance().conn;
    }
}
