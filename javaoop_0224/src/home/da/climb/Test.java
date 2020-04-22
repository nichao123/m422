package javaoop_0224.src.home.da.climb;
/**
 * 模拟多人爬山
 */
public class Test {
	public static void main(String[] args) {
		ClimbThread youngMan = new ClimbThread("年轻人",500,1);
		ClimbThread oldMan = new ClimbThread("老年人",1500,1);
		System.out.println("********开始爬山*********");
		youngMan.start();
		oldMan.start();
	}
}


class ClimbThread extends Thread {
	private int time; // 爬100米的时间
	public int num = 0; // 爬多少个100米

	public ClimbThread(String name, int time, int kilometer) {
		super(name);  //调用父类的线程名
		this.time = time;
		this.num = kilometer * 1000 / 100;
	}

	public void run() {
		//循环有几个100米
		while (num > 0) {
			try {
				Thread.sleep(this.time);  //
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "爬完100米！");
			num--;  //减一
		}
		System.out.println(Thread.currentThread().getName()+"到达终点！");
	}
}
