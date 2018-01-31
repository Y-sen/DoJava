package gui;

import java.util.Scanner;

public class Chushou {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int money=0;
		int price=0;
		boolean boo=false;
		String[] arr = new String[999];
		int count=999;
		
		
		int banner=0;
		if(banner==1){
		Scanner s=new Scanner(System.in);
		int number=s.nextInt();
		
		for(int i=0;i<count;i++)
		{
			if(i==number)
			{
				if(boo==true){
					arr[i]=null;
					money+=price;
				}
			}
			else if(count<100)
				System.out.println("库存剩余过小，请及时补充");
				
			else
				System.out.println("找不到该产品");
		}
		}
		else if(banner==2)
		{
			Scanner s=new Scanner(System.in);
			int number=s.nextInt();
			
			for(int i=0;i<count;i++)
			{
				if(i==number)
				{
					if(boo==true){
						arr[i]=null;
						
					}
				}
					
				else
					System.out.println("找不到该产品");
			}
		}
		

	}

}
