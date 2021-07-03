package DI03;

public class Student {
	private String name;
	private int age;
	private String gradeNum;
	private String classNum;
	
	//생성자 주입 (DI의 세터 인젝션과 컨스트럭터 인젝션 중 2번째)
	public Student (String name, int age, String gradeNum, String classNum) {
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGradeNum() {
		return gradeNum;
	}

	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

}
