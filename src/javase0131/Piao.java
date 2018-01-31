package javase0131;

public class Piao implements Runnable {
	int count=40;
	int n = 40;
	int m = 40;
	Object lock = new Object();
	@Override
	public void run() {	
		// TODO Auto-generated method stub
		while(count > 0){
			synchronized(lock){
				System.out.println(Thread.currentThread().getName()+"Âô³öµÚ"+count+"ÕÅÆ±");
				count--;
//				try {
//					Thread.currentThread().sleep(0);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			synchronized(lock){
				System.out.println(Thread.currentThread().getName()+"chushou"+n+"ticket");
				n--;
//				try {
//					Thread.currentThread().sleep(0);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			synchronized(lock){
				System.out.println(Thread.currentThread().getName()+"000000000"+m+"000");
				m--;
//				try {
//					Thread.currentThread().sleep(0);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	}
	
	
}
