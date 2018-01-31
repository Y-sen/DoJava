package javase0131;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new Piao();
		Thread  t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		
	}

}
