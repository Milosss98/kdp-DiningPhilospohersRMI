package kdp.phil.rmi;

public class Table implements ClientTableInterface {

	int num = 0;
	boolean[] forks = new boolean[RMITableServer.numberOfPhilosophers];

	@Override
	synchronized public void acquireLeftFork(int id) {
		try {
			while (forks[id])
				wait();
			forks[id] = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	synchronized public void acquireRightFork(int id) {
		try {
			while (forks[(id + 1) % RMITableServer.numberOfPhilosophers])
				wait();
			forks[id + 1] = true;
		} catch (Exception e) {

		}
	}

	@Override
	synchronized public void releaseLeftFork(int id) {
		forks[id] = false;
		notifyAll();
	}

	@Override
	synchronized public void releaseRightFork(int id) {
		forks[(id + 1) % RMITableServer.numberOfPhilosophers] = false;
		notifyAll();
	}

	@Override
	synchronized public void entry(int id) {
		try {
			while (num == RMITableServer.numberOfPhilosophers - 1)
				wait();
			num++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	synchronized public void exit(int id) {
		num--;
		notifyAll();
	}

}
