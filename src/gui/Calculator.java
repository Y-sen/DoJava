package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;


public class Calculator extends JFrame {
	private double saveNum = 0;					// һʱ����
	private boolean isSave = false;				// �Ƿ�������һʱ����
	private JTextField tf;
	private JPanel panel1, panel2, panel3, panel4;
	private boolean IfResult = true, flag = false;
	private String oper = "=";
	private double result = 0;
	private Num numActionListener;
	private DecimalFormat df;
	private JButton btns;

	public Calculator() {
		super("������");							// ���ñ�����

		df = new DecimalFormat("#.#####");		// ������λС��
		this.setLayout(new BorderLayout(5, 5));
		panel1 = new JPanel(new GridLayout(1, 3, 5, 10));
		panel2 = new JPanel(new GridLayout(5, 6, 5, 5));			// 5��6��
		panel3 = new JPanel(new GridLayout(5, 1, 5, 5));
		panel4 = new JPanel(new BorderLayout(5, 5));
		/**
		 * �˵���
		 */
		
		numActionListener = new Num();								// ʵ�����ּ���

		/**
		 * �ı��򣬼�Ϊ����������Ļ��ʾ����
		 */
		tf = new JTextField();
		tf.setEditable(false); 									   	 // �ı����򲻿ɱ༭
		tf.setBackground(Color.white);								 // �ı�����ı���ɫ
		tf.setHorizontalAlignment(JTextField.RIGHT);				 // �����Ҷ���
		tf.setText("0");
		tf.setBorder(BorderFactory.createLoweredBevelBorder());
		tf.addKeyListener(new MyKey());
		init(); 														// �Լ��������г�ʼ��
	}

	/**
	 * ��ʼ������ ��Ӱ�ť
	 */
	private void init() {
		addButton(panel1, "Backspace", new Clear(), Color.red);
		addButton(panel1, "CE", new Clear(), Color.red);
		addButton(panel1, "C", new Clear(), Color.red);

		addButton(panel2, "sqrt", new Signs(), Color.magenta);
		addButton(panel2, "n!", new Signs(), Color.magenta);
		addButton(panel2, "7", numActionListener, Color.black);
		addButton(panel2, "8", numActionListener, Color.black);
		addButton(panel2, "9", numActionListener, Color.black);
		addButton(panel2, "+", new Signs(), Color.red);

		addButton(panel2, "log", new Signs(), Color.magenta);
		addButton(panel2, "1/x", new Signs(), Color.magenta);
		addButton(panel2, "4", numActionListener, Color.black);
		addButton(panel2, "5", numActionListener, Color.black);
		addButton(panel2, "6", numActionListener, Color.black);
		addButton(panel2, "-", new Signs(), Color.red);

		addButton(panel2, "sin", new Signs(), Color.magenta);
		addButton(panel2, "x^2", new Signs(), Color.magenta);
		addButton(panel2, "1", numActionListener, Color.black);
		addButton(panel2, "2", numActionListener, Color.black);
		addButton(panel2, "3", numActionListener, Color.black);
		addButton(panel2, "/", new Signs(), Color.red);

		addButton(panel2, "cos", new Signs(), Color.magenta);
		addButton(panel2, "x^3", new Signs(), Color.magenta);
		addButton(panel2, "-/+", new Clear(), Color.black);
		addButton(panel2, "0", numActionListener, Color.black);
		addButton(panel2, ".", new Dot(), Color.black);
		addButton(panel2, "*", new Signs(), Color.red);

		addButton(panel2, "tan", new Signs(), Color.magenta);
		addButton(panel2, "%", new Signs(), Color.magenta);
		addButton(panel2, "��", numActionListener, Color.blue);
		addButton(panel2, "e", numActionListener, Color.blue);
		addButton(panel2, "'", new Signs(), Color.blue);
		addButton(panel2, "=", new Signs(), Color.red);

		panel3.addKeyListener(new MyKey());
		addButton(panel3, "��", new Signs(), Color.orange);
		addButton(panel3, "MC", new SM(), Color.pink);
		addButton(panel3, "MR", new SM(), Color.pink);
		addButton(panel3, "MS", new SM(), Color.pink);
		addButton(panel3, "M+", new SM(), Color.pink);

		panel4.addKeyListener(new MyKey());
		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel2, BorderLayout.CENTER);

		addKeyListener(new MyKey());
		add(tf, BorderLayout.NORTH);
		add(panel3, BorderLayout.WEST);
		add(panel4,BorderLayout.CENTER);
		pack();
		this.setResizable(false); 					// ���ڲ��ɸı��С
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * ͳһ���ð�ť�ĵ�ʹ�÷�ʽ
	 * 
	 * @param panel
	 * @param name
	 * @param action
	 * @param color
	 */
	private void addButton(JPanel panel, String name, ActionListener action, Color color) {
		JButton bt = new JButton(name);
		panel.add(bt); 									// ����������Ӱ�ť
		bt.setForeground(color); 						// ����ǰ�������壩��ɫ
		bt.addActionListener(action); 					// ���Ӽ����¼�
		bt.addKeyListener(new MyKey());
	}

	/**
	 * �������Ļ���������+ - ?�� ??��
	 * 
	 * @param x
	 */
	private void getResult(double x) {
		if (oper == "+") {
			result += x;
		} else if (oper == "-") {
			result -= x;
		} else if (oper == "*") {
			result *= x;
		} else if (oper == "/") {
			result /= x;
		} else if (oper == "=") {
			result = x;
		} else if (oper == "��") {
			result %= x;
		}
		tf.setText(df.format(result));
	}

	/**
	 * ������ŵ��¼�����
	 */
	class Signs implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			/*
			 * ��ActionEvent�����getActionCommand()���� ȡ���������¼�������ص��ַ���
			 */
			String str = e.getActionCommand();
			/* sqrt��ƽ���� */
			if (str.equals("sqrt")) {
				double i = Double.parseDouble(tf.getText());
				if (i >= 0) {
					/*
					 * String.valueOf() ת��Ϊ�ַ��� df.format() ��Ҫ������λС�� Math.sqrt()
					 * ������ƽ����
					 */
					tf.setText(String.valueOf(df.format(Math.sqrt(i))));
					IfResult = true;
				} else {
					tf.setText("���ܿ�ƽ����");
				}
			}

			/* log���ö��� */
			else if (str.equals("log")) {
				double i = Double.parseDouble(tf.getText());
				if (i > 0) {
					tf.setText(String.valueOf(df.format(Math.log(i))));
					IfResult = true;
				} else {
					tf.setText("���������");
				}
			}

			/* %��ٷֱ� */
			else if (str.equals("%")) {
				tf.setText(df.format(Double.parseDouble(tf.getText()) / 100));
				IfResult = true;
			}

			/* 1/x���� */
			else if (str.equals("1/x")) {
				if (Double.parseDouble(tf.getText()) == 0) {
					tf.setText("��������Ϊ��");
				} else {
					tf.setText(df.format(1 / Double.parseDouble(tf.getText())));
					IfResult = true;
				}
			}

			/* sin�����Һ��� */
			else if (str.equals("sin")) {
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.sin(i))));
				IfResult = true;
			}

			/* cos�����Һ��� */
			else if (str.equals("cos")) {
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.cos(i))));
				IfResult = true;
			}

			/* tan�����к��� */
			else if (str.equals("tan")) {
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.tan(i))));
				IfResult = true;
			}

			/* n!��׳� */
			else if (str.equals("n!")) {
				double i = Double.parseDouble(tf.getText());
				if ((i % 2 == 0) || (i % 2 == 1)) // �ж�Ϊ�����Ž��н׳˲���
				{
					long j = (long) i; // ǿ������ת��
					long result = 1;
					for (long k = 1; k <= j; k++)
						result *= k;
					tf.setText(String.valueOf(result));
					IfResult = true;

				} else {
					tf.setText("�޷����н׳�");
				}
			}

			/* x^2��ƽ�� */
			else if (str.equals("x^2")) {
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(i * i)));
				IfResult = true;
			}

			/* x^3������ */
			else if (str.equals("x^3")) {
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(i * i * i)));
				IfResult = true;
			}

			/* ���Ƕ�ת�� */
			/**
			 * ���Ƕ�ֵת���ɻ���ֵ���������Ǻ����ļ���
			 */
			else if (str.equals("'")) {
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(i / 180 * Math.PI));
				IfResult = true;
			}

			else {
				if (flag) {
					IfResult = false;
				}
				if (IfResult) {
					oper = str;
				} else {
					getResult(Double.parseDouble(tf.getText()));
					oper = str;
					IfResult = true;
				}
			}
		}
	}

	/**
	 * �����ť���¼�����
	 */
	class Clear implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			/*
			 * ��ActionEvent�����getActionCommand()���� ȡ���������¼�������ص��ַ���
			 */
			String str = e.getActionCommand();
			if (str == "C") {
				tf.setText("0");
				IfResult = true;
				result = 0;
			} else if (str == "-/+") {
				double i = 0 - Double.parseDouble(tf.getText().trim());
				tf.setText(df.format(i));
			} else if (str == "Backspace") {
				if (Double.parseDouble(tf.getText()) > 0) {
					if (tf.getText().length() > 1) {
						tf.setText(tf.getText().substring(0, tf.getText().length() - 1));

						// ʹ���˸�ɾ�����һλ�ַ�
					} else {
						tf.setText("0");
						IfResult = true;
					}
				} else {
					if (tf.getText().length() > 2) {
						tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
					} else {
						tf.setText("0");
						IfResult = true;
					}
				}
			} else if (str == "CE") {
				tf.setText("0");
				IfResult = true;
			}
		}
	}

	/**
	 * ����������¼�����
	 */
	class Num implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
			if (IfResult) {
				tf.setText("");
				IfResult = false;
			}
			if (str == "��") {
				tf.setText(String.valueOf(Math.PI));
			} else if (str == "e") {
				tf.setText(String.valueOf(Math.E));
			} else {
				tf.setText(tf.getText().trim() + str);
				if (tf.getText().equals("0")) {
					tf.setText("0");
					IfResult = true;
					flag = true;
				}
			}
		}
	}

	/**
	 * С������¼�����
	 */
	class Dot implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (tf.getText().trim().indexOf(".") == -1) {
				tf.setText(tf.getText() + ".");

			}

		}
	}

	class SM implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
			if ("MS" == str) {
				btns.setText("M");
				saveNum = Double.parseDouble(tf.getText());
				isSave = true;
				IfResult = true;
			} else if ("MC" == str) {
				isSave = false;
				saveNum = 0;
				btns.setText("Java");
			} else if ("M+" == str) {
				isSave = true;
				saveNum += Double.parseDouble(tf.getText());
				btns.setText("M");
			} else if ("MR" == str && isSave) {
				tf.setText(df.format(saveNum));
				IfResult = false;
			}
		}
	}

	class MyKey extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			boolean bFlag = false;
			switch (c) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				if (IfResult) {
					tf.setText("");
					IfResult = false;
				}
				tf.setText(tf.getText().trim() + c);
				bFlag = true;
				break;
				
			
			case '.':

				if (tf.getText().trim().indexOf(".") == -1) {
					tf.setText(tf.getText() + ".");
				}
				bFlag = true;
				break;
			case '_':
				if (Double.parseDouble(tf.getText()) > 0) {
					if (tf.getText().length() > 1) {
						tf.setText(tf.getText().substring(0, tf.getText().length() - 1));

						// ʹ���˸�ɾ�����һλ�ַ�
					} else {
						tf.setText("0");
						IfResult = true;
					}
				} else {
					if (tf.getText().length() > 2) {
						tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
					} else {
						tf.setText("0");
						IfResult = true;
					}
				}
				bFlag = true;
				break;
			case '+':
				if (flag) {
					IfResult = false;
				}
				if (IfResult) {
					oper = "+";
				} else {
					getResult(Double.parseDouble(tf.getText()));
					oper = "+";
					IfResult = true;
				}
				bFlag = true;
				break;
			case '-':
				if (flag) {
					IfResult = false;
				}
				if (IfResult) {
					oper = "-";
				} else {
					getResult(Double.parseDouble(tf.getText()));
					oper = "-";
					IfResult = true;
				}
				bFlag = true;
				break;
			case '*':
				if (flag) {
					IfResult = false;
				}
				if (IfResult) {
					oper = "*";
				} else {
					getResult(Double.parseDouble(tf.getText()));
					oper = "*";
					IfResult = true;
				}
				bFlag = true;
				break;
			case '/':
				if (flag) {
					IfResult = false;
				}
				if (IfResult) {
					oper = "/";
				} else {
					getResult(Double.parseDouble(tf.getText()));
					oper = "/";
					IfResult = true;
				}
				bFlag = true;
				break;
			case '=':
				if (flag) {
					IfResult = false;
				}
				if (IfResult) {
					oper = "=";
				} else {
					getResult(Double.parseDouble(tf.getText()));
					oper = "=";
					IfResult = true;
				}
				bFlag = true;
				break;
			}
			if (bFlag && tf.getText().equals("0")) {
				tf.setText("0");
				IfResult = true;
				flag = true;
			}
		}
	}

	/**
	 * main����
	 */
	public static void main(String[] args) {
		new Calculator().setVisible(true);
	}
}
