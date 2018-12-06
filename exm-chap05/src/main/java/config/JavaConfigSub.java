package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberInfoPrinter;
import spring.MemberRegisterService;

//spring 설정으로 사용된다는 표시의 annotation
@Configuration
public class JavaConfigSub {
	
	@Autowired
	private JavaConfigMain cfgMain;
	
	@Bean
	public MemberRegisterService memRegSvc() {
		return new MemberRegisterService(cfgMain.memberDao());
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter iPrinter = new MemberInfoPrinter();
		// 명시적인 의존주입
		iPrinter.setMemberDao(cfgMain.memberDao());

		// Autowired 테스트를 위하여 명시적 주입을 막음
		// iPrinter.setMemberPrinter(memberPrinter());

		return iPrinter;
	}
}
