package gui;

public class Person {

	
	private String name;
	private char sex;
	private int age;
	
	public void setAge(int age){
		if(age<0||age>130){
			System.out.println("年龄输入错误");
			this.age=0;
		}else
			this.age=age;
	}
	public int getAge(){
		return age;
	}
	public void setSex(char sex){
		if(sex!='男'||sex!='女'){
			System.out.println("性别输入错误");
		}else
			this.sex=sex;
	}
	public void method(){
		System.out.println("我叫"+name+"我的性别是"+sex+"我的年龄是"+age);
	}
}
