package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
	// memDao 를 필수가 아님으로 설정 required=false
	@Autowired(required = false)
	@Qualifier("memberDao2")
	private MemberDao memDao;
	private MemberPrinter mPrinter;

	// public void setMemberDao(MemberDao memDao) {
	// this.memDao = memDao;
	// }

	@Autowired
	// @Qualifier("memPrinter1")
	public void setMemPrinter(MemberPrinter memPrinter) {
		this.mPrinter = memPrinter;
	}

	public void printInfo(String email) {
		Member member = this.memDao.selectByEmail(email);
		if (member != null)
			this.mPrinter.print(member);
		else
			System.out.println(email + " 데이터가 없음.");
	}
}
