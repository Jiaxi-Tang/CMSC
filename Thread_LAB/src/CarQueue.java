import java.util.ArrayList;
import java.util.Random;

public class CarQueue{
	private ArrayList<Integer> queue;

	public CarQueue() {
		queue = new ArrayList<>();
		Random r = new Random();
		for(int i  = 0; i < 30; i++)
			queue.add(r.nextInt(4));
	}

	public void addToQueue() {
		class SomeRunnable implements Runnable{

			@Override
			public void run() {
				Random r = new Random();
				int count = r.nextInt(15)+15;
				for(int i  = 0; i < count; i++)
					queue.add(r.nextInt(4));
				try {
					Thread.sleep(100000);
				}
				catch(InterruptedException e) {

				}
			}

		}
		SomeRunnable r = new SomeRunnable();
		Thread t = new Thread(r);
		t.start();
		t.interrupt();
	}

	public int deleteQueue() {
		if(queue.size() > 0)
			return queue.remove(0);
		else {
			Random r = new Random();
			return r.nextInt(4);
		}
	}

}
