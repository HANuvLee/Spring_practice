package sdlc02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX02.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("student1 이름: " + student1.getName());
		System.out.println("student1 나이: " + student1.getAge());
		
		System.out.println("===================================");
		Student student2 = ctx.getBean("student", Student.class);
		//setter이용 다른값을 집어넣음
		student2.setName("강유");
		student2.setAge(55);
		
		System.out.println("student2 이름: " + student2.getName());
		System.out.println("student2 나이: " + student2.getAge());
		
		//student1도 강유대장군으로 바뀜 그리고 두개의 객체는 같은것으로 나옴
		//같은 xml에 빈으로 선언 빈을 뽑으면서(ctx.getbean) 타 인스턴스(1과 2)를 만들고 2의 값을 세터로 바꿔줌
		//
		System.out.println("===================================");
		System.out.println("student1 이름: " + student1.getName());
		System.out.println("student1 나이: " + student1.getAge());
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		else {
			System.out.println("student1 != student2");
		}
		ctx.close();
	}

}
