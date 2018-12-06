package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	private MemberDao memDao;
	private MemberPrinter memPrinter;

	public void setMemberDao(MemberDao memDao) {
		this.memDao = memDao;
	}

	@Autowired
	public void setMemberPrinter(MemberPrinter memPrt) {
		this.memPrinter = memPrt;
	}

	public void printInfo(String email) {
		Member member = this.memDao.selectByEmail(email);
		if (member != null)
			this.memPrinter.print(member);
		else
			System.out.println(email + " 데이터가 없음.");
	}
}
