package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;


public class Calculator extends JFrame {
	private double saveNum = 0;					// 一时保存
	private boolean isSave = false;				// 是否启动了一时保存
	private JTextField tf;
	private JPanel panel1, panel2, panel3, panel4;
	private boolean IfResult = true, flag = false;
	private String oper = "=";
	private double result = 0;
	private Num numActionListener;
	private DecimalFormat df;
	private JButton btns;

	public Calculator() {
		super("计算器");							// 设置标题栏

		df = new DecimalFormat("#.#####");		// 保留五位小数
		this.setLayout(new BorderLayout(5, 5));
		panel1 = new JPanel(new GridLayout(1, 3, 5, 10));
		panel2 = new JPanel(new GridLayout(5, 6, 5, 5));			// 5行6列
		panel3 = new JPanel(new GridLayout(5, 1, 5, 5));
		panel4 = new JPanel(new BorderLayout(5, 5));
		/**
		 * 菜单栏
		 */
		
		numActionListener = new Num();								// 实现数字监听

		/**
		 * 文本域，即为计算器的屏幕显示区域
		 */
		tf = new JTextField();
		tf.setEditable(false); 									   	 // 文本区域不可编辑
		tf.setBackground(Color.white);								 // 文本区域的背景色
		tf.setHorizontalAlignment(JTextField.RIGHT);				 // 文字右对齐
		tf.setText("0");
		tf.setBorder(BorderFactory.createLoweredBevelBorder());
		tf.addKeyListener(new MyKey());
		init(); 														// 对计算器进行初始化
	}

	/**
	 * 初始化操作 添加按钮
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
		addButton(panel2, "π", numActionListener, Color.blue);
		addButton(panel2, "e", numActionListener, Color.blue);
		addButton(panel2, "'", new Signs(), Color.blue);
		addButton(panel2, "=", new Signs(), Color.red);

		panel3.addKeyListener(new MyKey());
		addButton(panel3, "余", new Signs(), Color.orange);
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
		this.setResizable(false); 					// 窗口不可改变大小
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * 统一设置按钮的的使用方式
	 * 
	 * @param panel
	 * @param name
	 * @param action
	 * @param color
	 */
	private void addButton(JPanel panel, String name, ActionListener action, Color color) {
		JButton bt = new JButton(name);
		panel.add(bt); 									// 在面板上增加按钮
		bt.setForeground(color); 						// 设置前景（字体）颜色
		bt.addActionListener(action); 					// 增加监听事件
		bt.addKeyListener(new MyKey());
	}

	/**
	 * 计算器的基础操作（+ - ?á ??）
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
		} else if (oper == "余") {
			result %= x;
		}
		tf.setText(df.format(result));
	}

	/**
	 * 运算符号的事件监听
	 */
	class Signs implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			/*
			 * 用ActionEvent对象的getActionCommand()方法 取得与引发事件对象相关的字符串
			 */
			String str = e.getActionCommand();
			/* sqrt求平方根 */
			if (str.equals("sqrt")) {
				double i = Double.parseDouble(tf.getText());
				if (i >= 0) {
					/*
					 * String.valueOf() 转换为字符串 df.format() 按要求保留五位小数 Math.sqrt()
					 * 求算数平方根
					 */
					tf.setText(String.valueOf(df.format(Math.sqrt(i))));
					IfResult = true;
				} else {
					tf.setText("不能开平方根");
				}
			}

			/* log求常用对数 */
			else if (str.equals("log")) {
				double i = Double.parseDouble(tf.getText());
				if (i > 0) {
					tf.setText(String.valueOf(df.format(Math.log(i))));
					IfResult = true;
				} else {
					tf.setText("不能求对数");
				}
			}

			/* %求百分比 */
			else if (str.equals("%")) {
				tf.setText(df.format(Double.parseDouble(tf.getText()) / 100));
				IfResult = true;
			}

			/* 1/x求倒数 */
			else if (str.equals("1/x")) {
				if (Double.parseDouble(tf.getText()) == 0) {
					tf.setText("除数不能为零");
				} else {
					tf.setText(df.format(1 / Double.parseDouble(tf.getText())));
					IfResult = true;
				}
			}

			/* sin求正弦函数 */
			else if (str.equals("sin")) {
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.sin(i))));
				IfResult = true;
			}

			/* cos求余弦函数 */
			else if (str.equals("cos")) {
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.cos(i))));
				IfResult = true;
			}

			/* tan求正切函数 */
			else if (str.equals("tan")) {
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(Math.tan(i))));
				IfResult = true;
			}

			/* n!求阶乘 */
			else if (str.equals("n!")) {
				double i = Double.parseDouble(tf.getText());
				if ((i % 2 == 0) || (i % 2 == 1)) // 判断为整数放进行阶乘操作
				{
					long j = (long) i; // 强制类型转换
					long result = 1;
					for (long k = 1; k <= j; k++)
						result *= k;
					tf.setText(String.valueOf(result));
					IfResult = true;

				} else {
					tf.setText("无法进行阶乘");
				}
			}

			/* x^2求平方 */
			else if (str.equals("x^2")) {
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(i * i)));
				IfResult = true;
			}

			/* x^3求立方 */
			else if (str.equals("x^3")) {
				double i = Double.parseDouble(tf.getText());
				tf.setText(String.valueOf(df.format(i * i * i)));
				IfResult = true;
			}

			/* ′″角度转换 */
			/**
			 * 将角度值转换成弧度值，方便三角函数的计算
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
	 * 清除按钮的事件监听
	 */
	class Clear implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			/*
			 * 用ActionEvent对象的getActionCommand()方法 取得与引发事件对象相关的字符串
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

						// 使用退格删除最后一位字符
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
	 * 数字输入的事件监听
	 */
	class Num implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
			if (IfResult) {
				tf.setText("");
				IfResult = false;
			}
			if (str == "π") {
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
	 * 小数点的事件监听
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

						// 使用退格删除最后一位字符
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
	 * main方法
	 */
	public static void main(String[] args) {
		new Calculator().setVisible(true);
	}
}
