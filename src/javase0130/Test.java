package javase0130;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		//demo1();
		//demo2();
		demo3();
	}
	public static void demo1(){
		List<String> list = new ArrayList<String>();
		list.add("list1");
		list.add("list 2");
		
		List<Integer> intlist = new ArrayList<Integer>();
		Scanner s = new Scanner(System.in);
		//String str = s.next();
		//int istr = s.nextInt();
		String listr = s.nextLine();
		int inta = Integer.parseInt(listr);
		System.out.println("接收到的为："+inta);
		
	}
	public static void demo2(){
		Cat cat = new Cat<String>("fat");
		Date d = new Date();
		
		System.out.println();
	}
	public static void demo3(){
		
		Thread_1 th1 = new Thread_1();
		Thread_2 th2 = new Thread_2();
		Thread_3 r = new Thread_3() ;
		Thread th3 = new Thread(r);
		th1.start();
		th2.start();
		th3.start();
	}
}
