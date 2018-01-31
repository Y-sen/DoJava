package javase0126;

public class Mathteacher extends Teacher implements Chinese,Person {
	public Mathteacher(String name){
		super(name);
		
	}
	public void teach(){
		System.out.println(getName()+"Math teacher");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("eat");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("work");
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("chinese");
	}
}
