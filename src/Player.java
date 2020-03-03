import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Player extends Thread{

	private BlockingQueue<String> board;
	private boolean isMyTurn;
	private String name;
	private AtomicInteger generalCount;
	
	public Player(BlockingQueue<String> board, boolean isMyTurn, String name, AtomicInteger generalCount) {
		this.board = board;
		this.isMyTurn = isMyTurn;
		this.name = name;
		this.generalCount = generalCount;
	}
	
	@Override
	public void run() {
		try {
			for(int i = 0; i <10 ; i++) {
				play(i);
			}
		} catch (InterruptedException e) {
			System.out.println("Waking");
		}
	}
	
	private synchronized void play(int i) throws InterruptedException {
		String coord = "";
		if(isMyTurn) {
			coord = "A " + i;
			isMyTurn = false;
			sleep(1000);
		} else {
			coord = "B " + i;
			isMyTurn = true;
			sleep(1500);
		}
		board.put(coord);
//		notify();
		generalCount.incrementAndGet();
		System.out.println(this.name + " - Adding coordinate: " + coord + " - " + generalCount);
	}
	
}
