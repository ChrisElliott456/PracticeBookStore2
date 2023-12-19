import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/p2bsdb";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL,DB_NAME,DB_PASSWORD);
            System.out.println("Database connected successfully.");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
