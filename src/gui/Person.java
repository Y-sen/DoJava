package gui;

public class Person {

	
	private String name;
	private char sex;
	private int age;
	
	public void setAge(int age){
		if(age<0||age>130){
			System.out.println("�����������");
			this.age=0;
		}else
			this.age=age;
	}
	public int getAge(){
		return age;
	}
	public void setSex(char sex){
		if(sex!='��'||sex!='Ů'){
			System.out.println("�Ա��������");
		}else
			this.sex=sex;
	}
	public void method(){
		System.out.println("�ҽ�"+name+"�ҵ��Ա���"+sex+"�ҵ�������"+age);
	}
}
