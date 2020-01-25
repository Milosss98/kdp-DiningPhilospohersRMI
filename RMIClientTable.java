package kdp.phil.rmi;

import java.rmi.RemoteException;

public class RMIClientTable implements RMIClientTableInterface {

	Table table;
	
	public RMIClientTable(Table table) {
		super();
		this.table = table;
	}

	@Override
	public void acquireLeftFork(int id) throws RemoteException {
		table.acquireLeftFork(id);
	}

	@Override
	public void acquireRightFork(int id) throws RemoteException {
	   table.acquireRightFork(id);	
	}

	@Override
	public void releaseLeftFork(int id) throws RemoteException {
		table.releaseLeftFork(id);
	}

	@Override
	public void releaseRightFork(int id) throws RemoteException {
		table.releaseRightFork(id);
	}

	@Override
	public void entry(int id) throws RemoteException {
		table.entry(id);
	}

	@Override
	public void exit(int id) throws RemoteException {
		table.exit(id);
	}

}
