package kdp.phil.rmi;

public interface ClientTableInterface {
	public void acquireLeftFork(int id);

	public void acquireRightFork(int id);

	public void releaseLeftFork(int id);

	public void releaseRightFork(int id);

	public void entry(int id);

	public void exit(int id);
}
