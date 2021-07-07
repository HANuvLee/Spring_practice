package sdlc01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean {
	private String name;
	private int age;
	
	//DisposableBean 에 해당 
	public void destroy() throws Exception {
		System.out.println("Student의 destory()==> 소멸자가 소멸되기 전...");

	}
	
	//InitializingBean 에 해당 
	public void afterPropertiesSet() throws Exception {
		System.out.println("Student afterPropertiesSet==> 생성자 생성 이후 자동 수행");

	}
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}


	
	
	
}
