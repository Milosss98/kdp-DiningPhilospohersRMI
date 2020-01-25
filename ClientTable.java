package kdp.phil.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientTable implements ClientTableInterface {

	RMIClientTableInterface table;
	String host;
	int port;
	public ClientTable(String host,int port){
		try{
			if (System.getSecurityManager()==null) {
		
			System.setSecurityManager(new SecurityManager());
		}
		this.host=host;
		this.port=port;
		Registry registry=LocateRegistry.getRegistry(host, port);
		
		String name="/RMITable";
		table=(RMIClientTableInterface) registry.lookup(name);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void acquireLeftFork(int id) {
		try {
			table.acquireLeftFork(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void acquireRightFork(int id) {
		try {
			table.acquireRightFork(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void releaseLeftFork(int id) {
		try {
			table.releaseLeftFork(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void releaseRightFork(int id) {
		try {
			table.releaseRightFork(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void entry(int id) {
		try {
			table.entry(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exit(int id) {
		try {
			table.exit(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
