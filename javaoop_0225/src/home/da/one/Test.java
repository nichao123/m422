package javaoop_0225.src.home.da.one;
/**
 * 模拟接力赛跑
 *
 */
public class Test {
	public static void main(String[] args) {
		RunThread run = new RunThread();
		for(int i=0;i<3;i++){
			new Thread(run,(i+1)+"号选手").start();
		}
	}
}
