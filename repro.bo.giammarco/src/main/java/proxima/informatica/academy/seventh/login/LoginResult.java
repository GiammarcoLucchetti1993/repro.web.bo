package proxima.informatica.academy.seventh.login;

public class LoginResult {
	private boolean loginResponse;
	private String loginMessage;
	
	
	public LoginResult(boolean loginResponse, String loginMessage) {
		super();
		this.loginResponse = loginResponse;
		this.loginMessage = loginMessage;
	}

	public LoginResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the loginResponse
	 */
	public boolean isLoginResponse() {
		return loginResponse;
	}


	/**
	 * @param loginResponse the loginResponse to set
	 */
	public void setLoginResponse(boolean loginResponse) {
		this.loginResponse = loginResponse;
	}


	/**
	 * @return the loginMessage
	 */
	public String getLoginMessage() {
		return loginMessage;
	}


	/**
	 * @param loginMessage the loginMessage to set
	 */
	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}
	
	
	
}
