/**
 * Finca Gruppe 2
 * --------------
 * Michael Kündig 09-737-552
 * Michael Keller 07-708-506
 * Loc Nguyen 06-918-932
 * Thavorith Hean 07-741-127
 * Mehmet Ali Bekooglu 06-920-771 
 * 
 * Assistent: Konstantin Zherebtsov
 */


package E_client;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import E_server.E_IFincaServer;
import E_view.E_ChatPanel;

/**
 *
 * @author Michael KŸndig
 */
public class E_ChatClient extends UnicastRemoteObject implements Serializable, E_IChatClient {

	private E_ChatPanel chatPanel;
	private E_IFincaServer chatServer;
	private String myNickname;


	public E_ChatClient(E_IFincaServer server, String nickname) throws RemoteException {
		this.chatServer = server;
		this.myNickname = nickname;

	}

//	sends the message to the server which then sends it to all clients
	
	public void sendMessage(String message) throws RemoteException {
		chatServer.postMessage(myNickname + ": " + message);
	}

//	prints out the message on the GUI
	
	public void receiveMessage(String message) throws RemoteException {
		chatPanel.printMessage(message);
	}

		
	public void setChatPanel(E_ChatPanel chatPanel) throws RemoteException {
		this.chatPanel = chatPanel;

	}
}