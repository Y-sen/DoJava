package javase0124;

public class Work {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=1;
		for(int i=0;i<5;i++){
			a=a++;
			System.out.println(a);
		}
		
//		nishu(9654);
//		shui();
//		triangle(5);
//		huiwen(12322);
		//sum(5);
		//mm(20,15);
		/*
		//小的转大的可以  大的转小的小心溢出
		int i=65;
		int sum=(int)Math.pow(5, 3)*2;
		double ss=Math.sqrt(4);
		System.out.println(sum+"  "+ss);
		byte j=(byte)i;
		
		
		//char类型如果进行计算 ，转换成ASCII码进行计算 
		char a=(char)i;
		char b='a';
		char c=(char)((int)b+1);
		System.out.println(a);
		
		
		//float类型后边加个f   结果 3.3333333 精确到七位小数
		float f=10f;
		float ff=f/3;
		System.out.println(ff);
		
		
		//double类型   结果 3.3333333333333335  
		double d=10;
		double dd=d/3;
		System.out.println(dd);
		
		
		//String  引用类型   有属性 有方法   
		//String name="张三";
		 * 
		 */
		//******************************************
//		Cat cat1=new Cat("二胖");
//		cat1.setAge(2);
//		cat1.setSex('男');
//		cat1.setType("橘猫");
//		System.out.println(cat1.getName());
//		cat1.walk();
		
		
	}
	
	public static void nishu(int n){
		int num=n;
		System.out.println(num);
		int o=num/1000;
		int p=(num%1000)/100;
		int q=(num%100)/10;
		int r=num%10;
		System.out.println(r*1000+q*100+p*10+o);
	}
	public static void shui(){
		for(int i=100;i<1000;i++){
			int o=i/100;
			int p=(i%100)/10;
			int q=i%10;
			int s=o*o*o+p*p*p+q*q*q;
			if(i==s){
			   System.out.println(i);
			}
		}
	}
	public static void triangle(int n){
		int row=n;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void huiwen(int n){
		int num=n;
		int o=num/10000;
		int p=(num%10000)/1000;
		int q=(num%1000)/100;
		int r=(num%100)/10;
		int s=num%10;
		if(o==s&&p==r){
			System.out.println(num+"是回文数");
		}else
			System.out.println(num+"不是回文数");
	}
	public static void sum(int n){
		double num= n;
		double s=0;
		for(double i=2;i<=num;i++){
			double x=1/(i*(i+1));
			s=s+x;
		}
		System.out.println(s);
	}
	public static void mm(int m,int n){
		int max=m;
		int min=n;
		if(max<min){
			int temp=max;
			max=min;
			min=temp;
		}
		if(max%min==0){
			System.out.println(m+"和"+n+"的最大公约数为"+min);
			System.out.println(m+"和"+n+"的最小公倍数为"+max);
		}else{
			for (int i = min-1; i >=1; i--) {
				if(min%i==0&&max%i==0){
					System.out.println(m+"和"+n+"的最大公约数为"+i);
					break;
				}
			}
			for (int i =1; i<=min; i++) {
				int sum=max*i;
				if(sum%min==0){
					System.out.println(m+"和"+n+"的最小公倍数数为"+sum);
					break;
				}
			}
		}
//		}
	}
	
}
