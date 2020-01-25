package kdp.phil.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMITableServer {
	
	static final int numberOfPhilosophers = 5;

	public static void main(String[] args) {
		try {
			if (System.getSecurityManager()==null) {
				System.setSecurityManager(new SecurityManager());
			}
			Table table=new Table();
			RMIClientTableInterface rmiTable=new RMIClientTable(table);
			RMIClientTableInterface stub=(RMIClientTableInterface) UnicastRemoteObject.exportObject(rmiTable,0);

			String name="/RMITable";
			Registry registry=LocateRegistry.createRegistry(Integer.parseInt(args[0]));
			registry.rebind(name, rmiTable);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
