package pojo;

public class AuthenticUserWithToken {

	private Integer id;
	private String authToken;
	private IplUser iplUser;

	public AuthenticUserWithToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticUserWithToken(Integer id, String authToken, IplUser iplUser) {
		super();
		this.id = id;
		this.authToken = authToken;
		this.iplUser = iplUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public IplUser getIplUser() {
		return iplUser;
	}

	public void setIplUser(IplUser iplUser) {
		this.iplUser = iplUser;
	}

}
