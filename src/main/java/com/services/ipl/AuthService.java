package com.services.ipl;

import java.sql.SQLException;

import com.github.javafaker.Faker;

import dao.AuthDao;
import pojo.AuthenticUserWithToken;
import pojo.IplUser;

public class AuthService {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		AuthService auth = new AuthService();
		auth.authentic("aryahimanshu093@gmail.com", "test123");
	}

	public AuthenticUserWithToken authentic(String email, String password) throws ClassNotFoundException, SQLException {
		Faker faker = new Faker();
		AuthenticUserWithToken authenticUserWithToken = new AuthenticUserWithToken();
		AuthDao authDao = new AuthDao();
		IplUser iplUser = authDao.authenticIplUserDao(email, password);
		if (iplUser.getEmail() != null && iplUser.getId() != null && iplUser.getPassword() != null) {
			authenticUserWithToken = authDao.getIpluserWithTokenDao(iplUser, faker);
		}
		return authenticUserWithToken;
	}
}
