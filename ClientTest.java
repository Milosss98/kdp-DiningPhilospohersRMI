package kdp.phil.rmi;

public class ClientTest {
	
	public static void main(String[] args) { 
		String host=args[0];
		int port=Integer.parseInt(args[1]);
		ClientTableInterface table = new ClientTable(host,port);
		
		for (int i = 0; i < RMITableServer.numberOfPhilosophers; i++) { 
		
			new Philosopher(table, i).start(); 
		}
		
	}
}
