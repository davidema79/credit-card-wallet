package eu.davidem.wallet.gateway.rest.to;

/**
 * Body Request for Sing up operation.
 * 
 * @author Davide Martorana
 *
 */
public class SignUpUser {

	private String username;
	private String password;

	public SignUpUser() {

	}

	public SignUpUser(final String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
