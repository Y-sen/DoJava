package javase0131;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*Runnable r = new Piao();
		Thread  t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();*/
		
		
		demo1();
//		demo2();
//		demo3();
		
//		demo4();
//		demo4_2();
		
	}
	public static void demo1() throws IOException{
		File file = new File("E:/AAAA/BB/CC/se.txt");
		System.out.println("文件或者文件夹是否存在"+file.exists());  //文件或者文件夹是否存在
		System.out.println("判断是否是文件"+file.isFile());//判断是否是文件
		System.out.println("文件名"+file.getName());//文件名
		System.out.println("绝对路径"+file.getAbsolutePath());//绝对路径
		System.out.println("相对路径"+file.getPath());//相对路径
		System.out.println("父级目录"+file.getParent());//父级目录
		System.out.println("文件大小（单位字节）"+file.length());//文件大小，单位字节
//		System.out.println("创建文件（文件必须不存在）"+file.createNewFile());//创建文件,文件必须不存在
//		System.out.println("创建文件夹"+file.mkdir());//创建文件夹，找到最后一个不存在创建
//		System.out.println("递归创建文件夹"+file.mkdirs());//创建文件夹，找不着就直接创建
		
		
	}
	//转换成字节流
	public static void demo2() throws IOException{
		File file = new File("E:\\AAAA\\1.png");
		InputStream input = new FileInputStream(file);
		byte[] b = new byte[(int)file.length()];
		input.read(b);
		for (int i :b) {
			System.out.println(i);
		}
//		String str = new String(b);
//		System.out.println(new String(b));
	}
		
	//转换成字符流
	public static void demo3() throws IOException{
		File fread = new File("E:/AAAA/se.java");
		System.out.println(fread.createNewFile());
		Reader reader = new FileReader(fread);
		char[] c = new char[(int)fread.length()];
		reader.read(c);
		String strc = new String(c);
		reader.close();//******************************************
		System.out.println(strc);
	}
	/**   ***********************************************************************  */
	public static void demo4() throws IOException{
		File file = new File("E:\\AAAA\\demo4.txt");
		/*OutputStream ofile = new FileOutputStream(file);   //如果没有，则创建此文件
		String str = "demo4 demo 4demo4 demo4";
		//str.getBytes("UTF-8");//中文是gb2312  big5繁体中文
		ofile.write(str.getBytes());
		ofile.close();
		System.out.println("demo4 写入成功");*/
		
		OutputStream ofile = new FileOutputStream(file,true);   //如果没有，则创建此文件
		String str = "demo4 demo 4demo4 demo4  add demo4";
		//str.getBytes("UTF-8");//中文是gb2312  big5繁体中文
		ofile.write(str.getBytes());
		ofile.close();
		System.out.println("demo4 写入成功");
	}
	public static void demo4_2() throws IOException{
		File file = new File("E:\\AAAA\\demo4.txt");
		Writer wr = new FileWriter(file,true);
		String str ="sdfssddfssv add";
		wr.write(str);
//		wr.flush();   //刷新
		wr.close();
		System.out.println("success");
	}
	public static void demo5() throws IOException{
		File file = new File("E:\\AAAA\\demo5.txt");
		Reader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String str1 = br.readLine();
		Writer writer = new FileWriter(file);
	
	}
	

}













