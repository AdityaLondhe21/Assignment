package application;

import java.sql.Connection;
import javax.sql.*;
import javax.sql.RowSet.*;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	private static final String url = "jdbc:postgresql://localhost:5432/EmployeeDB";
	private static final String username = "postgres";
	private static final String password = "tiger";
	public static JdbcRowSet getConnection() {
		try {
            JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet();
            rs.setUrl(url);
            rs.setUsername(username);
            rs.setPassword(password);
            return rs;
		}
		catch (SQLException e) {
			e.printStackTrace();
		};
		return null;
	}
	public static void closeConnection(JdbcRowSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
