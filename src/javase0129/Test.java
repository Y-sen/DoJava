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
		 * ��������
		 * 		��������           ����������Ĭ��ֵ  �޷������Ǵ���Ĭ��ֵ��ֵ����û�д���
		 * ��λ����  ֱ�Ӵӻ�������  ��ַһ��    ������-128    127   ����Ҫ����������   intValue
		 * 		byte	1
		 * 		short	2
		 * int			4		Integer
		 * long			8
		 * float		4
		 * double		8
		 * boolean		1
		 * char			2		Character
		 * С��ת��� ��ֱ��ת���Ϳ���   ���תС����Ҫǿ��ת��  
		 * ��������
		 * 	��  	������   --
		 * 		����		��private���β���������get��set����
		 * 		����--- �����ϵ�ͬ�ں���
		 * 		������--�������� ��˽�����Ը���ʼֵ    �����дĬ�������޲ι��췽��
		 * ����
		 * 		�ڶ����д�����һ���������ڴ�ռ����������������
		 * 
		 * �ӿ�	����ӿ�   �ļ����ͽӿ�����ͬ
		 * 		���󷽷�    
		 * 		����   ��static final ���Σ�Լ���������Ҫ ��д�ķ���
		 * 
		 * �ڴ�ģ��
		 *  ��������new�ؼ��ʴ����Ķ���  1.7֮���ַ����������ڶ����д��
		 *  ջ���� ջ֡   ÿ����һ����������һ��ջ֡��ջ֡�±�����ʱ����
		 *  ������--��̬��Ա�������Ϣjdk1.7֮ǰ�ַ����ڷ��������
		 *  ���÷������в������ݵ�ʱ�򣬻������ʹ��ݵ���ֵ��Ӧ�����ʹ��ݵ��ǵ�ַ 
		 *  javap -c   ���������
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
		list.contains("e");  // �ж���û�����ֵ
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
