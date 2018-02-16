package main.server.database.connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetTransformer<R>{
    R transform(ResultSet res) throws SQLException;
}