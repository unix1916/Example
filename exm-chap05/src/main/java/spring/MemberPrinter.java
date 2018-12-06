package spring;

public class MemberPrinter {

	public void  print(Member member) {
		System.out.printf(
				"회원 정보 : Id=%d, eMail=%s, Name=%s, RegistDate=%tF\n"
				, member.getId()
				, member.getEmail()
				, member.getName()
				, member.getRegisterDate());
	}
}
