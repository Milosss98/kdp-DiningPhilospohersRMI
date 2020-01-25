package kdp.phil.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIClientTableInterface extends Remote{
	public void acquireLeftFork(int id) throws RemoteException;

	public void acquireRightFork(int id)throws RemoteException;

	public void releaseLeftFork(int id)throws RemoteException;

	public void releaseRightFork(int id)throws RemoteException;

	public void entry(int id)throws RemoteException;

	public void exit(int id)throws RemoteException;

}
