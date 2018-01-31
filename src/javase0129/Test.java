package javase0129;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 数据类型
		 * 		基本类型           基本类型有默认值  无法区分是传了默认值的值还是没有传递
		 * 八位以内  直接从缓存中拿  地址一样    超出了-128    127   则需要拆箱来处理   intValue
		 * 		byte	1
		 * 		short	2
		 * int			4		Integer
		 * long			8
		 * float		4
		 * double		8
		 * boolean		1
		 * char			2		Character
		 * 小的转大的 。直接转换就可以   大的转小的需要强制转换  
		 * 引用类型
		 * 	类  	定义类   --
		 * 		属性		用private修饰并且生成了get和set方法
		 * 		方法--- 基本上等同于函数
		 * 		构造器--创建对象 给私有属性赋初始值    如果不写默认生成无参构造方法
		 * 数组
		 * 		在堆区中创建出一个连续的内存空间来保存对象或变量名
		 * 
		 * 接口	定义接口   文件名和接口名相同
		 * 		抽象方法    
		 * 		常量   用static final 修饰，约束子类必须要 重写的方法
		 * 
		 * 内存模型
		 *  堆区：用new关键词创建的对象  1.7之后字符串常量池在堆区中存放
		 *  栈区： 栈帧   每调用一个方法创建一个栈帧，栈帧下保存临时变量
		 *  方法区--静态成员，类的信息jdk1.7之前字符串在方法区存放
		 *  调用方法进行参数传递的时候，基本类型传递的是值，应用类型传递的是地址 
		 *  javap -c   反汇编命令
		 * 
		 * 
		 */
		
		
		
/*	
*/		
		
//		demo3();	
//		demo2();
		demo4();
	}
	public static void sort(){
		int[] arr = new int[6];
		arr[0] = 5;
		arr[1] = 6;
		int[] arr2 = {10,95,23,3,25,56,9,87,577,2,70};
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		for(int i : arr2){
			System.out.println(i);
		}
		/*first circle*/
		for (int i = 0; i < arr2.length-1; i++) {
			if(arr2[i]>arr2[i+1]){
				int tem = arr2[i];
				arr2[i] = arr2[i+1];
				arr2[i+1] = tem;
			}
		}
		System.out.println("first :");
		for(int i : arr2){
			System.out.print(i+" ");
		}
//		/*second circle*/
		for (int i = 0; i < arr2.length-2; i++) {
			if(arr2[i]>arr2[i+1]){
				int tem = arr2[i];
				arr2[i] = arr2[i+1];
				arr2[i+1] = tem;
			}
		}
		System.out.println();
		System.out.println("second :");
		for(int i : arr2){
			System.out.print(i+" ");
		}
		//========================================
		for (int i = 1; i < arr2.length-1; i++) {
			for (int j = 0; j < arr2.length-i; j++) {
				if(arr2[j]>arr2[j+1]){
					int tem = arr2[j];
					arr2[j] = arr2[j+1];
					arr2[j+1] = tem;
				}
			}
		}
		System.out.println("second :");
		for(int i : arr2){
			System.out.print(i+" ");
		}
		for(int i = 0; i<arr2.length;i++){
			for(int j=0;j<arr2.length-1-i;j++){
				if(arr2[j]>arr2[j+1]){
					int tem = arr2[j];
					arr2[j] = arr2[j+1];
					arr2[j+1] = tem;
					
				}
			}
			for(int x : arr2){
				System.out.print(x+" ");
			}
			System.out.println();
		}
		System.out.println("maopao :");
		for(int i : arr2){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("===================================");
		int[] arr3 = {10,95,23,3,25,56,9,87,577,2,70};
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]>arr[j]) {
					int tem = arr[i];
					arr[i] = arr[j];
					arr[j] = tem;
				}
				
			}
			for(int x : arr){
				System.out.print(x+" ");
			}
			System.out.println();
			
		}
		System.out.println("select :");
		for(int i : arr){
			System.out.print(i+" ");
		}
		int[] arr0 = new int[10];
		System.out.println("\n"+arr0.length);
		for(int i : arr0){
			System.out.print(i+" ");
		}
	}
	public static void listdemo(){
		ArrayList list = new ArrayList();
		list.add(25);
		list.add(58);
		list.add(2, 50);
		list.contains("e");  // 判断有没有这个值
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		list.addAll(list);
		//System.out.println(list.get(2));
		System.out.println(list);
	
	}
	public static void demo1(){
		Set set = new HashSet();
		set.add("e");
		set.add("y");
		set.add("d");
		set.add("ww");
		set.add("h");
		for(Object obj:set){
			System.out.println(obj);
		}
	}
	//HashMap  
	public static  void demo2(){
		Map map = new HashMap();
		map.put("a", "abc");
		map.put(2, "bcd");
		map.put(3, "cde");
		map.get(2);
		Set set = map.keySet();
		
		map.containsKey("a");
		map.containsValue("abc");
		for(Object key:set){
		System.out.println(map.get(key));
		}
	}
	public static void demo3(){
		int i = 1;
		String a = String.valueOf(i);
		System.out.println(a+2);
	}
	//string bulider
	public static void demo4(){
		int i = 1;
		String a = String.valueOf(i);
		StringBuilder	bulider = new StringBuilder("a");
		bulider.append("bb");
		StringBuffer buffer = new StringBuffer("b");
		buffer.append("eee");
		System.out.println(a+2);
		System.out.println(bulider);
		System.out.println(buffer);
	}
}
