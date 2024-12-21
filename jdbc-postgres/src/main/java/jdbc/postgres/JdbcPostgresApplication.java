package jdbc.postgres;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcPostgresApplication {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/liquibasepg_db";
        Properties properties = new Properties();
        properties.setProperty("user", "postgres");
        properties.setProperty("password", "password");
        properties.setProperty("escapeSyntaxCallMode", "callIfNoReturn");

        Connection connection = DriverManager.getConnection(url, properties);
        CallableStatement statement = connection.prepareCall("{call commitproc( ? )}");
        statement.setInt(1, 100);
        statement.execute();
        statement.close();
    }
}