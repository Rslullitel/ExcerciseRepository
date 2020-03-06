import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

	
	public static void main(String[] args) {
			
			
			BlockingQueue<String> board = new LinkedBlockingQueue<>();
			AtomicInteger generalCount = new AtomicInteger(0);
			
			Player playerA = new Player(board, true, "ana", generalCount);
			Player playerB = new Player(board, false, "juan", generalCount);
			
			playerA.start();
			playerB.start();

	}
		
}
