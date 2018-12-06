package spring;

import java.util.Date;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;

	public Member(String email, String passwd, String name, Date regDate) {
		this.email = email;
		this.password = passwd;
		this.name = name;
		this.registerDate = regDate;
	}

	void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPasswd() {
		return this.password;
	}

	public String getName() {
		return this.name;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void changePassword(String oldPasswd, String newPasswd) {
		if (!this.password.equals(oldPasswd))
			throw new IdPasswordNotMatchingException();
		else
			this.password = newPasswd;
	}

}
