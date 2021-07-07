package sdlc01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("1 ctx. load Before");
		
		ctx.load("classpath:applicationCTX01.xml");
		System.out.println("2 ctx. load After");
		
		//생성자 관련(Student의 생성자(public Student) 생성이후 자동으로 afterPropertiesSet으로 이동(로직이 필요하면 미리 작성해 놓으면 됨))
		ctx.refresh();
		System.out.println("3 ctx.refresh After");
		//소멸자 관련
		ctx.close();
		System.out.println("4 ctx.clos After");
	}

}
