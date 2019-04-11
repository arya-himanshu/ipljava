package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.javafaker.Faker;

import pojo.AuthenticUserWithToken;
import pojo.IplUser;
import utils.MysqlCon;

public class AuthDao {

	public IplUser authenticIplUserDao(String email, String password) throws ClassNotFoundException, SQLException {
		Statement stmt;
		ResultSet rs;
		IplUser iplUser = new IplUser();
		MysqlCon con = new MysqlCon();
		stmt = con.getConn().createStatement();
		String sql = "select * from ipluser where email LIKE '%" + email + "%' and password LIKE '%" + password + "%'";
		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			iplUser.setId(rs.getInt(1));
			iplUser.setFirstname(rs.getString(2));
			iplUser.setLastname(rs.getString(3));
			iplUser.setPassword(rs.getString(5));
			iplUser.setEmail(rs.getString(4));
		}
		return iplUser;
	}

	public AuthenticUserWithToken getIpluserWithTokenDao(IplUser iplUser, Faker faker)
			throws ClassNotFoundException, SQLException {
 		Statement stmt;
		ResultSet rs;
		MysqlCon con = new MysqlCon();
		stmt = con.getConn().createStatement();
		AuthenticUserWithToken authenticUserWithToken = new AuthenticUserWithToken();
		authenticUserWithToken.setAuthToken(faker.number().randomDigit() + faker.hashCode() + "");
		String sqlAuth = "insert into authToken (authtoken ,ipluser)values ('" + authenticUserWithToken.getAuthToken()
				+ "' , '" + iplUser.getId() + "') ";
 		stmt.executeUpdate(sqlAuth);
 		authenticUserWithToken.setIplUser(iplUser);
		return authenticUserWithToken;
	}
}
