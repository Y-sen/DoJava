package javase0126;

public class Mainboard {
	Cpu cpu;

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}
	public void method(){
		cpu.method();
	}
}
