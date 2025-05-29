package jdbc.postgres.procedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UsingPreparedStatement {
    private static final Logger _log = LoggerFactory.getLogger(UsingPreparedStatement.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/liquibasepg_db";
        Properties properties = new Properties();
        properties.setProperty("user", "postgres");
        properties.setProperty("password", "password");

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, properties);
        PreparedStatement preparedStatement = connection.prepareStatement("CALL player_by_birth(?, ?, ?, ?, ?)");
        try(connection; preparedStatement) {
            preparedStatement.setString(1, "VK16");
            preparedStatement.setString(2, "Virat");
            preparedStatement.setString(3, "Kohli");
            preparedStatement.setLong(4, Long.parseLong("1988"));
            preparedStatement.setLong(5, Long.parseLong("2011"));
            preparedStatement.executeUpdate();
        }

        _log.info("Prepared Statement closed: {}", preparedStatement.isClosed());
        _log.info("Connection closed: {}", connection.isClosed());

    }
}

