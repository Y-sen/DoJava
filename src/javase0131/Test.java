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
		System.out.println("�ļ������ļ����Ƿ����"+file.exists());  //�ļ������ļ����Ƿ����
		System.out.println("�ж��Ƿ����ļ�"+file.isFile());//�ж��Ƿ����ļ�
		System.out.println("�ļ���"+file.getName());//�ļ���
		System.out.println("����·��"+file.getAbsolutePath());//����·��
		System.out.println("���·��"+file.getPath());//���·��
		System.out.println("����Ŀ¼"+file.getParent());//����Ŀ¼
		System.out.println("�ļ���С����λ�ֽڣ�"+file.length());//�ļ���С����λ�ֽ�
//		System.out.println("�����ļ����ļ����벻���ڣ�"+file.createNewFile());//�����ļ�,�ļ����벻����
//		System.out.println("�����ļ���"+file.mkdir());//�����ļ��У��ҵ����һ�������ڴ���
//		System.out.println("�ݹ鴴���ļ���"+file.mkdirs());//�����ļ��У��Ҳ��ž�ֱ�Ӵ���
		
		
	}
	//ת�����ֽ���
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
		
	//ת�����ַ���
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
		/*OutputStream ofile = new FileOutputStream(file);   //���û�У��򴴽����ļ�
		String str = "demo4 demo 4demo4 demo4";
		//str.getBytes("UTF-8");//������gb2312  big5��������
		ofile.write(str.getBytes());
		ofile.close();
		System.out.println("demo4 д��ɹ�");*/
		
		OutputStream ofile = new FileOutputStream(file,true);   //���û�У��򴴽����ļ�
		String str = "demo4 demo 4demo4 demo4  add demo4";
		//str.getBytes("UTF-8");//������gb2312  big5��������
		ofile.write(str.getBytes());
		ofile.close();
		System.out.println("demo4 д��ɹ�");
	}
	public static void demo4_2() throws IOException{
		File file = new File("E:\\AAAA\\demo4.txt");
		Writer wr = new FileWriter(file,true);
		String str ="sdfssddfssv add";
		wr.write(str);
//		wr.flush();   //ˢ��
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













