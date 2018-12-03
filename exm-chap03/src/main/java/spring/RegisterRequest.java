package spring;

public class RegisterRequest {

	private String email;
	private String name;
	private String passwd;
	private String confirmPasswd;

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setConfirmPasswd(String confirmPasswd) {
		this.confirmPasswd = confirmPasswd;
	}

	public String getEmail() {
		return this.email;
	}

	public String getName() {
		return this.name;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public String getConfirmPasswd() {
		return this.confirmPasswd;
	}

	public boolean isPasswdEqualConfirmPasswd() {
		return this.passwd.equals(this.confirmPasswd);
	}
}
