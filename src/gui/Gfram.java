package gui;

import java.awt.BorderLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gfram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//创建容器
		JFrame frm = new JFrame();
		
		JPanel topPanel = new JPanel();
		JPanel cenPanel = new JPanel();
		
		//设置标题
		frm.setTitle("GUI ");
		
		
		//创建按钮
		JButton myBtn = new JButton("提交");
		JButton myBtn2 = new JButton("按钮2");
		JButton myBtn3 = new JButton("按钮3");
		JButton myBtn4 = new JButton("按钮4");
		
		
		
	/*
		//将按钮添加到容器中你
		topPanel.add(myBtn);
		topPanel.add(myBtn2);
		cenPanel.add(myBtn3);
		cenPanel.add(myBtn4);
		
		*/
		// 未添加事件
		
		//创建提示标签并设置显示信息
		JLabel show1 = new JLabel("请输入姓名：");
		
		JLabel show2 = new JLabel("请输入：");
		
		//创建输入框，设置为可编辑，左侧输入，20列
		JTextField input1 = new JTextField();
		
		input1.setEditable(true);
		input1.setHorizontalAlignment(SwingConstants.LEFT);
		
		input1.setColumns(20);
		//
//		JTextArea input1 = new JTextArea();
//		input1.setEditable(true);
////		//input1.setHorizontalAlignment(SwingConstants.LEFT);
//		input1.setRows(5);
//		input1.setColumns(20);
	
		TextArea output = new TextArea();
		
		//创建显示框
		output.setRows(5);
		output.setColumns(32);
		output.setEditable(true);
		
		
		
		
		
		//添加输入
		topPanel.add(show1);
		topPanel.add(input1);
		topPanel.add(myBtn);
		
		
				
		
		cenPanel.add(show2,BorderLayout.NORTH);
		cenPanel.add(output,BorderLayout.SOUTH);
		
//创建滚动面板
		JScrollPane topScrollPanel = new JScrollPane();
		JScrollPane cenScrollPanel = new JScrollPane();
		
		
	//为各个滚动面板添加自己的组件
		topScrollPanel.setViewportView(topPanel);
				
				
		cenScrollPanel.setViewportView(cenPanel);
				
		topScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		topScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			
		cenScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cenScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				
	
				
		
		//设置布局
		frm.setLayout(new BorderLayout());
		frm.add(topScrollPanel,BorderLayout.NORTH);
		frm.add(cenScrollPanel,BorderLayout.CENTER);
		
		//设置窗口初始位置与大小并显示
		frm.setBounds(500,200,400,200);
		
		//设置窗体关闭方式
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//让窗体显示
		frm.setVisible(true);
		

	}

}
