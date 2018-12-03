package spring;

import java.util.Date;

public class MemberRegisterService {

	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memDao) {
		this.memberDao = memDao;
	}

	public void regist(RegisterRequest req) {
		Member member = this.memberDao.selectByEmail(req.getEmail());

		if (member != null) {
			throw new AlreadyExistingMemberException("duplicate email : " + req.getEmail());
		}

		Member newMember = new Member(req.getEmail(), req.getPasswd(), req.getName(), new Date());
		this.memberDao.insert(newMember);
	}

}
