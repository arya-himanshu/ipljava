package com.ipl;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.services.ipl.AuthService;

import pojo.AuthenticUserWithToken;
import pojo.ErrorResponse;
import pojo.IplUser;

@Path("/auth")
public class AuthRest {

	@Path("/authenticUser")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response testRest(@FormParam("username") String username, @FormParam("password") String password)
			throws ClassNotFoundException, SQLException {
		Gson gson = new Gson();
		AuthService auth = new AuthService();
		AuthenticUserWithToken iplUser = auth.authentic(username, password);
		if (iplUser.getAuthToken() != null && iplUser.getIplUser().getEmail() != null && iplUser.getIplUser().getId() != null
				&& iplUser.getIplUser().getPassword() != null) {
			return Response.status(200).entity(gson.toJson(iplUser)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
		} else {
			ErrorResponse errorResponse = new ErrorResponse("user not found with given username and password");
			return Response.status(200).entity(gson.toJson(errorResponse)).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
		}
	}
}
