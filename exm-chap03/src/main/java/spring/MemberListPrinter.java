package spring;

import java.util.Collection;

public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter memPrinter;

	public MemberListPrinter(MemberDao memDao, MemberPrinter memPrt) {
		this.memberDao = memDao;
		this.memPrinter = memPrt;
	}

	public void printAll() {
		Collection<Member> members = this.memberDao.selectAll();

		if (members.size() == 0) {
			System.out.println("멤버 정보가 비어있습니다.");
			return;
		}

		for (Member m : members) {
			this.memPrinter.print(m);
		}
	}
}
