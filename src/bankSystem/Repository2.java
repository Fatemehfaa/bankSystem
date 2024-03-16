package bankSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public final class Repository2 {
    private static Connection connection ;

    static {
        final String url = "jdbc:mysql://localhost:3306/bank";
        final String userName = "root";
        final String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Repository2() {
    }

    public static Connection getConnection() {
        return connection;
    }
}

