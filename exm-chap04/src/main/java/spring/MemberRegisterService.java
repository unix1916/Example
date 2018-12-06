package spring;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {

	@Resource(name="memberDao")
	private MemberDao memberDao;

	public MemberRegisterService() {
	}

	// 의존 객체 주입이 필수가 아닌경우 required=false 설정
	@Autowired(required = false)
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
