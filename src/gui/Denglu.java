package gui;

import java.awt.*;
import javax.swing.*;

public class Denglu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jme=new JFrame();
		jme.setTitle("��¼����");
		jme.setLayout(new BorderLayout());
		
		JButton mybut= new JButton("��ť");
		 jme.add(mybut);
		 jme.setBounds(200, 200, 300, 200);
		 jme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jme.setVisible(true);
		

	}

}
