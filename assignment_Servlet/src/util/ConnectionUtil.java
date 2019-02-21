package util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbUrl="jdbc:mysql://localhost:3306/login";
    private String dbUser="root";
    private String dbPw="123";
    private Connection conn = null;

    public Connection getConn() {
        try{
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPw);
        }catch(ClassNotFoundException|SQLException e){
            e.printStackTrace();
        }
        return conn;

    }
    public static void main(String[] args){
        ConnectionUtil db = new ConnectionUtil();
        Connection con = db.getConn();
        if(con!=null){
            System.out.println("数据库连接成功");
        }
    }
}
