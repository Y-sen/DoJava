package javase0126;

public abstract class Teacher {
//	public void teach(){
//		System.out.println("授课");
//	}
	public Teacher(String name){
		this.name=name;
	}
	//抽象方法   一个类下可以定义几个抽象方法   子类必须重写
	private String name;
	private Integer age;
	private String add;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}
//======================================================
	public abstract void teach();
	
	public void method(){
		System.out.println(name+"method");
	}
}
