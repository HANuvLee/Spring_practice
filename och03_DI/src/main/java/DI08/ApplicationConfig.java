package DI08;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	@Bean
	public Student student1() {
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("물내리기");
		
		//생성자로 세팅
		Student student = new Student("을지문덕", 55, hobbys);
		//나머지는 직접
		student.setHeight(170);
		student.setWeight(68);
		
		return student;
	}
}
