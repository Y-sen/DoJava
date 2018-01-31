package gui;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * if(){
		 * 
		 * }else{
		 * }
		 * 
		 * */

/*		通过数据类型创建对象的方式 
 * 		数据类型  变量名=new 构造方法；
 *  */
		Person p=new Person();
		p.setAge(10);
		System.out.println(p.getAge());
		p.method();
		System.out.println("hello!");
	}

}
