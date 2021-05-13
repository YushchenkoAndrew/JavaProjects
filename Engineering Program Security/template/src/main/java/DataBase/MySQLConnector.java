package main.java.DataBase;

import java.sql.*;

public class MySQLConnector {
    public Connection connection;
    private Statement statement;
    public void setConnection(String url) throws Exception {
        Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(url, "root", "Andrew10122000");
        statement = connection.createStatement();
    }

    public String[] getResultOfCommand(String command, String columnLabel) throws SQLException {
        ResultSet resultSet = statement.executeQuery(command);
        resultSet.last();

        String[] result = new String[resultSet.getRow()];
        int i = 0;
        resultSet.beforeFirst();
        while (resultSet.next()) {
            result[i++] = resultSet.getString(columnLabel);
        }
        return result;
    }

    public int getSize(String command, String columnLabel) throws SQLException {
        ResultSet resultSet = statement.executeQuery(command);
        resultSet.last();
        return resultSet.getRow();
    }

    public void close() throws Exception {
        connection.close();
    }

    public void insertInTable(String tableName, String value) throws Exception {

    }
}
