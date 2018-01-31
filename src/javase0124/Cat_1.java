package javase0124;

public class Cat_1 {
	public Cat_1(){
		
	}
//
	private String name;
	private int age;
	private char sex;
	private String type;
	
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

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	//构造方法
	public Cat_1(String name){
		this.name=name;		
	}
	
	public static void walk(){
		System.out.println("正在走猫步");
	}
	public int add(int a,int b){
		return a+b;
	}
	public float add(float a,float b){
		return a+b;
	}
	public int add(int a){
		return a;
	}
}
