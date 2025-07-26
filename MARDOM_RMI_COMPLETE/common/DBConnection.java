package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/mardom?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";          // Cambia si usas otro usuario
    private static final String PASSWORD = "";    // Cambia si usas otra contraseña

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Registrar driver de MySQL
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver JDBC de MySQL: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
