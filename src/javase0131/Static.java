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
	public synchronized void sale(){     //ͬ����������ʱ�����Ϊthis  ����ǰ����
		System.out.println(Thread.currentThread().getName()+"������"+num+"��Ʊ");
		num--;
//		try {
//			Thread.currentThread().sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
}
