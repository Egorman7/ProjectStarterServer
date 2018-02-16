package main.server.database.connection;

import main.server.Log;

import java.sql.*;

public class ConnectionHelper {
    private static String DB_URL = "",
        DB_USER = "root", DB_PASS="root";
    private Connection connection;
    public ConnectionHelper() {
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException ex){
            Log.e(ex.getMessage());
        }
    }

    public <R> R selectQuery(String query, ResultSetTransformer<R> transformer) {
        R result = null;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            result = transformer.transform(resultSet);
        } catch (SQLException ex) {
            Log.e(ex.getMessage());
        }
        return result;
    }
    public boolean updateQuery(String query){
        boolean res = false;
        try(Statement statement = connection.createStatement()){
            res = statement.executeUpdate(query) > 0;
        } catch (SQLException ex){
            Log.e(ex.getMessage());
        }
        return res;
    }
}

