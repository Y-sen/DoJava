package gui;

public class Primesum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a={2,5,8,9,65,6,455,55,48};
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]<a[j+1]){
					int tep=a[j];
					a[j]=a[j+1];
					a[j+1]=tep;
				}
			}
			for(int x:a){
			
			}
			System.out.println();
		}
		for(int i:a){
			System.out.println(i);
		}
		/*
		//Ñ¡ÔñÅÅÐò
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]<a[j]){
					int swap=a[i];
					a[i]=a[j];
					a[j]=swap;
				}
			}
		}
		/*
		for(int i:a){
		System.out.println(i);
		}
		/*for(int i:a){
			System.out.println(i);
		}*/
		/*int a=11;
		int b=5;
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a+"   "+b);
		
		*/
//		int sum=0;
//		for(int i=1;i<=100;i++){
//			boolean b=false;
//			int s=0;
//			if(i==2){
//				sum=sum+2;
//			}else{
//				for(int j=2;j<i;j++){
//					s=i%j;  
//					if(s==0){
//						 b=false;
//						 break;
//					}else{
//						b=true;
//					}
//				}
//				if(b){
//					System.out.println(i+"  shisushu");
//					sum=sum+i;
//				}
//			}
//		}
//		System.out.println(sum);
	}

}
