package spring;

public class ChangePasswordService {

	private MemberDao memberDao;

	public ChangePasswordService(MemberDao memDao) {
		this.memberDao = memDao;
	}

	public void changePasswd(String email, String oldPasswd, String newPasswd) {
		Member member = this.memberDao.selectByEmail(email);

		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPasswd, newPasswd);
		this.memberDao.update(member);
	}
}
