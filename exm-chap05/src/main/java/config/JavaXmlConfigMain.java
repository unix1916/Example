package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import spring.MemberDao;
import spring.MemberPrinter;

//spring 설정으로 사용된다는 표시의 annotation
@Configuration
@ImportResource("classpath:sub-conf.xml")
public class JavaXmlConfigMain {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}

}
