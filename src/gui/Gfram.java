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
		
		//��������
		JFrame frm = new JFrame();
		
		JPanel topPanel = new JPanel();
		JPanel cenPanel = new JPanel();
		
		//���ñ���
		frm.setTitle("GUI ");
		
		
		//������ť
		JButton myBtn = new JButton("�ύ");
		JButton myBtn2 = new JButton("��ť2");
		JButton myBtn3 = new JButton("��ť3");
		JButton myBtn4 = new JButton("��ť4");
		
		
		
	/*
		//����ť��ӵ���������
		topPanel.add(myBtn);
		topPanel.add(myBtn2);
		cenPanel.add(myBtn3);
		cenPanel.add(myBtn4);
		
		*/
		// δ����¼�
		
		//������ʾ��ǩ��������ʾ��Ϣ
		JLabel show1 = new JLabel("������������");
		
		JLabel show2 = new JLabel("�����룺");
		
		//�������������Ϊ�ɱ༭��������룬20��
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
		
		//������ʾ��
		output.setRows(5);
		output.setColumns(32);
		output.setEditable(true);
		
		
		
		
		
		//�������
		topPanel.add(show1);
		topPanel.add(input1);
		topPanel.add(myBtn);
		
		
				
		
		cenPanel.add(show2,BorderLayout.NORTH);
		cenPanel.add(output,BorderLayout.SOUTH);
		
//�����������
		JScrollPane topScrollPanel = new JScrollPane();
		JScrollPane cenScrollPanel = new JScrollPane();
		
		
	//Ϊ���������������Լ������
		topScrollPanel.setViewportView(topPanel);
				
				
		cenScrollPanel.setViewportView(cenPanel);
				
		topScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		topScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			
		cenScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cenScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				
	
				
		
		//���ò���
		frm.setLayout(new BorderLayout());
		frm.add(topScrollPanel,BorderLayout.NORTH);
		frm.add(cenScrollPanel,BorderLayout.CENTER);
		
		//���ô��ڳ�ʼλ�����С����ʾ
		frm.setBounds(500,200,400,200);
		
		//���ô���رշ�ʽ
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�ô�����ʾ
		frm.setVisible(true);
		

	}

}
