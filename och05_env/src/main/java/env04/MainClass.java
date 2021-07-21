package env04;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String config = null;
		System.out.println("System을 입력하세요?");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		//dev는 개발환경,  run은 실행환경
		if(str.contentEquals("dev")) {
			config = "dev";
		}
		else if(str.equals("run")) {
			config = "run";
		}
		
		scanner.close();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.getEnvironment().setActiveProfiles(config);  //ctx환경에다가 활동가능한 프로파일을 cofig에 넣어줌 (dev냐 run 이냐) , ActiveProfiles => xml에 조건을 걸어준 profile과 연관됨
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		
		ctx.close();

	}

}
