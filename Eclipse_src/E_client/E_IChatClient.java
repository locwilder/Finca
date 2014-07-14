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

import java.rmi.Remote;
import java.rmi.RemoteException;

import E_view.E_ChatPanel;

/**
 *
 * @author mkimac
 */
public interface E_IChatClient extends Remote{
    public void sendMessage(String message) throws RemoteException;
    public void receiveMessage(String message) throws RemoteException;
	public void setChatPanel(E_ChatPanel chatPanel) throws RemoteException;
}
