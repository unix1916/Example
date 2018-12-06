package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.AlreadyExistingMemberException;
import spring.IdPasswordNotMatchingException;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class MainForSpring5 {

	private static ApplicationContext ctx = null;

	// appCtx4.xml에 MemberDao 객체 빈을 정의하지 않았기 때문에 실행시 오류가 발생한다.
	// @Autowired(required=false) 테스트
	public static void main(String[] args) throws IOException {
		ctx = new GenericXmlApplicationContext("classpath:appCtx5.xml");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("명열어를 입력하세요 : ");
			String command = reader.readLine();
			if (command.startsWith("new ")) {
				ProcessNewCommand(command.split(" "));
				continue;

				// } else if (command.startsWith("change ")) {
				// ProcessChangeCommand(command.split(" "));
				// continue;
				// } else if (command.startsWith("print")) {
				// ProcessPrintMember(command.split(" "));
				// } else if (command.startsWith("version")) {
				// ProcessPrintVersion(command.split(" "));

			} else if (command.startsWith("info")) {
				ProcessPrintInfo(command.split(" "));
			} else if (command.startsWith("exit")) {
				System.out.println("종료합니다. (with spring)");
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

		MemberRegisterService regSvc = ctx.getBean("regSvc", MemberRegisterService.class);

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

	// private static void ProcessChangeCommand(String[] args) {
	// if (args.length != 4) {
	// printHelp();
	// return;
	// }
	//
	// ChangePasswordService chgSvc = ctx.getBean("chgSvc",
	// ChangePasswordService.class);
	//
	// try {
	// chgSvc.changePasswd(args[1], args[2], args[3]);
	// System.out.println("암호를 변경하였습니다.\n");
	// } catch (MemberNotFoundException e) {
	// System.out.println("존재하지 않는 이메일입니다.\n");
	// } catch (IdPasswordNotMatchingException e) {
	// System.out.println("이메일과 암호가 일치하지 않습니다.\n");
	// }
	// }

	// private static void ProcessPrintMember(String[] args) {
	// MemberListPrinter printSvc = ctx.getBean("printSvc",
	// MemberListPrinter.class);
	//
	// printSvc.printAll();
	// }

	private static void ProcessPrintInfo(String[] args) {
		if (args.length < 2) {
			printHelp();
			return;
		}

		MemberInfoPrinter printInfo = ctx.getBean("printInfo", MemberInfoPrinter.class);
		printInfo.printInfo(args[1]);
	}

	// private static void ProcessPrintVersion(String[] args) {
	// VersionPrinter printer = ctx.getBean("versionPrint",
	// VersionPrinter.class);
	// printer.print();
	// }

}
