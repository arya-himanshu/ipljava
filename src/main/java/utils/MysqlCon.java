package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlCon {
	public  Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
		return con;
	}
}
