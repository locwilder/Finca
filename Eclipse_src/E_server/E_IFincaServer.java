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


package E_server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import E_playing_field.E_GameBoard;
import E_client.*;

public interface E_IFincaServer extends Remote {
	public void postMessage(String message) throws RemoteException;
	public void newClient(E_IFincaClient client) throws RemoteException;

	public ArrayList<String> getAllNicknames() throws RemoteException;

	public int getPlayerNumber(E_IFincaClient client) throws RemoteException;
	public void startGame() throws RemoteException;


	public void updateGameBoard(E_GameBoard board) throws RemoteException;
	public void sendGameBoardWithTurnChange() throws RemoteException;
	public void sendGameBoardWithoutTurnChange() throws RemoteException;
	public boolean everybodyReady() throws RemoteException;
	public int getNumberOfPlayers() throws RemoteException;
	public boolean isServerFull() throws RemoteException;
	public int getPlayerNumberOfTurn() throws RemoteException;
	public boolean isMyTurn(int playerNumber) throws RemoteException;
}
