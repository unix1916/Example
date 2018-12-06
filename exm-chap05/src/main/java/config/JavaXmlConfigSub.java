package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

//spring 설정으로 사용된다는 표시의 annotation
@Configuration
public class JavaXmlConfigSub {
	
	@Autowired
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;
	
	@Bean
	public MemberRegisterService memRegSvc() {
		return new MemberRegisterService(memberDao);
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter iPrinter = new MemberInfoPrinter();
		// 명시적인 의존주입
		iPrinter.setMemberDao(memberDao);

		// Autowired 테스트를 위하여 명시적 주입을 막음
		// iPrinter.setMemberPrinter(memberPrinter());

		return iPrinter;
	}
}
