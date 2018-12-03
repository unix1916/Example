package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class MemberAssembler {

	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService chgSvc;

	public MemberAssembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		chgSvc = new ChangePasswordService(memberDao);
	}

	public MemberDao getMemberDao() {
		return this.memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return this.regSvc;
	}

	public ChangePasswordService getChagePassswordServicd() {
		return this.chgSvc;
	}

}
