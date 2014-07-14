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
import java.util.ArrayList;


import E_player.E_Turn;
import E_playing_field.E_GameBoard;

public interface E_IFincaClient extends Remote {
	public String getNickname() throws RemoteException;
	public E_IChatClient getIChatClient() throws RemoteException;
	public void updateFirstGameBoard(E_GameBoard board) throws RemoteException;
    public void updateGameBoard(E_GameBoard board) throws RemoteException;
	public void sendGameBoard() throws RemoteException;
	public void startGUIgFrame() throws RemoteException;
	public void updateLobby(ArrayList<String> nicknames) throws RemoteException;
	public boolean isReady() throws RemoteException;
	public boolean isMyTurn() throws RemoteException;
	public void setMyTurn(boolean turn) throws RemoteException;
	public void endGame(ArrayList<String> scoreArrayList) throws RemoteException;
}
