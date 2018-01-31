package javase0131;

public class Static implements Runnable{

	int num = 40;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(num>0){
			sale();
		}
	}
	public synchronized void sale(){     //同步方法，此时锁旗标为this  即当前对象
		System.out.println(Thread.currentThread().getName()+"卖出第"+num+"张票");
		num--;
//		try {
//			Thread.currentThread().sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
}
