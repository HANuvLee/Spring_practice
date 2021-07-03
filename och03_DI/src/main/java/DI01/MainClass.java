package DI01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		MyCalculator myCalculator = new MyCalculator();
//      
//		setter 메소드 사용
//		myCalculator.setCalculator(new Calculator());
//		myCalculator.setFirstNum(50);
//		myCalculator.setSecondNum(5);
//		
//		myCalculator.add();
//		myCalculator.sub();
//		myCalculator.mul();
//		myCalculator.div();
		
//		DI 구현
		String configLocation ="classpath:applicationCTX.xml";
		System.out.println(configLocation);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		System.out.println(ctx);
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
		System.out.println(myCalculator + "=");
		// 여기까지가 MyCalculator myCalculator = new MyCalculator();랑 똑같음
		myCalculator.add();
		System.out.println("+");
		myCalculator.sub();
		System.out.println("-");
		myCalculator.mul();
		System.out.println("*");
		myCalculator.div();
		System.out.println("/");
	}
}
