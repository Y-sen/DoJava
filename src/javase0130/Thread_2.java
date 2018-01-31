package javase0130;

public class Thread_2 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++){
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("bbbbb"+i);
		}
	}
	
	
}
