package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SQLConnector {
    private static final String url = "jdbc:postgresql://localhost:5432/mortgage_calculator";
    private static final String user = ReadConfigFiles.getPropertyValues("DbUser");
    private static final String password = ReadConfigFiles.getPropertyValues("DbPassword");

    private static final Logger LOGGER = LogManager.getLogger(SQLConnector.class);

    /**
     * Connect to the postgreSQL database
     * @return a connection object
     */

    private static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            LOGGER.error("SQL Connection exception" + e.getMessage());
        }
        return conn;
    }


    /**
     * Reading Data from the database
     * @param SQL is the method parameter to accept the SQL query
     * @return a resultSet object
     * @throws SQLException
     */
    public static ResultSet readData(String SQL) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = connect();
            LOGGER.debug("Conneciton object value: " + conn);
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            LOGGER.error("SQL resultSet exception" + e.getMessage());
        } finally {
            conn.close();
        }
        return rs;
    }
}
