package kdp.phil.rmi;

public class Philosopher extends Thread{
	ClientTableInterface table;
	int id, num;

	public Philosopher(ClientTableInterface table, int id) {
		this.table = table;
		this.id = id;
	}

	@Override
	public void run() {
		num = 10;
		while (num > 0) {
			sleep();
			table.entry(id);
			table.acquireLeftFork(id);
			table.acquireRightFork(id);
			eat();
			table.releaseLeftFork(id);
			table.releaseRightFork(id);
			table.exit(id);
			num--;
		}
	}

	private void eat() {
		try {
			Thread.sleep((long) (5000 * Math.random()));
			System.out.println("Finished eating " + id + " turn " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void sleep() {
		try {
			Thread.sleep((long) (8000 * Math.random()));
			System.out.println("Finished sleeping " + id + " turn " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
