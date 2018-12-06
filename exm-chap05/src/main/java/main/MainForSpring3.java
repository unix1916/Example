package main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.JavaXmlConfigMain;
import spring.AlreadyExistingMemberException;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;


public class MainForSpring3 {

	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext(JavaXmlConfigMain.class);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("명열어를 입력하세요 : ");
			String command = reader.readLine();
			if (command.startsWith("new ")) {
				ProcessNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("info")) {
				ProcessPrintInfo(command.split(" "));

				// } else if (command.startsWith("change ")) {
				// ProcessChangeCommand(command.split(" "));
				// continue;
				// } else if (command.startsWith("print")) {
				// ProcessPrintMember(command.split(" "));
				// } else if (command.startsWith("version")) {
				// ProcessPrintVersion(command.split(" "));
			} else if (command.startsWith("exit")) {
				System.out.println("종료합니다. (spring example chap05)-"+ MainForSpring3.class);
				break;
			} else {
				printHelp();
			}
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 호가인하세요.");
		System.out.println("명령어 사용법 :");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 신규암호");
		System.out.println("info 이메일");
		System.out.println("list");
		System.out.println();
	}

	private static void ProcessNewCommand(String[] args) {
		if (args.length != 5) {
			printHelp();
			return;
		}

		MemberRegisterService regSvc = ctx.getBean("memRegSvc", MemberRegisterService.class);

		RegisterRequest req = new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
		req.setPasswd(args[3]);
		req.setConfirmPasswd(args[4]);

		if (!req.isPasswdEqualConfirmPasswd()) {
			System.out.println("암호가 일지하지 않습니다. 확인하세요.\n");
			return;
		}

		try {
			regSvc.regist(req);
			System.out.println("신규 등록하였습니다.\n");
		} catch (AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}

	private static void ProcessPrintInfo(String[] args) {
		if (args.length < 2) {
			printHelp();
			return;
		}

		MemberInfoPrinter printInfo = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		printInfo.printInfo(args[1]);
	}


}
