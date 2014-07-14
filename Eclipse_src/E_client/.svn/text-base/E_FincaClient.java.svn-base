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
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import E_server.*;
import E_player.E_Turn;
import E_playing_field.E_GameBoard;
import E_view.E_gFrame;
import E_view.loader.*;

/**
 * this class represents a client in the game. only one player can be the host (if isHost == true). he is able to press
 * the start button.
 * @author Michael KŸndig
 */

public class E_FincaClient extends UnicastRemoteObject implements Serializable, E_IFincaClient {

	private static final long serialVersionUID = -456836614449802476L;

	private String myNickname;
	private E_IFincaServer myServer;

	private E_GameBoard myGameboard;
	private E_Turn myTurn;

	private int myPlayerNumber;
	private boolean isHost;
	private boolean isReady;
	private boolean isMyTurn;

	private E_gFrame mygFrame;
	private EE_LobbyWindow lobbyWindow;
	private EE_EndGameWindow endGameWindow;

	/**
	 * locates the rmi registry on the virtual machine with the hostIP given in the constructor
	 * isHost in the constructor is only true after a call of the hostGame() method in the Loader class. 
	there is only one host. only the host can see the "start" button in the lobbyWindow. he is the only one
	able to call the initializeGame() method. the clients who join the game can see a ready button. that's
	why the isReady boolean is set to false at the beginning.
	 * @param nickname of the player
	 * @param serverName = name of the game
	 * @param hostIP = IP address of the host
	 * @param isHost = true if this client is the host
	 * @throws RemoteException
	 */
	public E_FincaClient(String nickname, String serverName, String hostIP, boolean isHost) throws RemoteException{
		super();
		try {

			Registry registry = LocateRegistry.getRegistry(hostIP);
			this.myServer = (E_IFincaServer) registry.lookup(serverName);
			this.myNickname = nickname;

			this.isHost = isHost;					
			if (this.isHost) {
				this.isReady = true;
				this.isMyTurn = true;
			}
			else {
				this.isReady = false;
				this.isMyTurn = false;
			}

			this.lobbyWindow = new EE_LobbyWindow(this);
			this.endGameWindow = new EE_EndGameWindow();
			this.myServer.newClient(this);
			this.myGameboard = new E_GameBoard();
			this.myPlayerNumber = myServer.getPlayerNumber(this);	
			this.lobbyWindow.setVisible(true);

		} catch (Exception e) {
			System.err.println("FincaServer exception:");
			e.printStackTrace();
		}
	}

	/**
	 * opens up the GUI of the game and starts a ChatClient so you can chat in the GUI.
	 * @pre GUI elements aren't initialized
	 * @post GUI elements initialized
	 * @throws RemoteException
	 */

	public void startGUIgFrame() throws RemoteException {
		mygFrame = new E_gFrame(this);
		myTurn = new E_Turn(myPlayerNumber, myServer.getNumberOfPlayers());
		E_IChatClient chatClient = new E_ChatClient(myServer, myNickname);
		mygFrame.getChatPanel().setChatClient(chatClient);
		chatClient.setChatPanel(mygFrame.getChatPanel());
		mygFrame.setMyTurnLabel(isMyTurn);
		lobbyWindow.setVisible(false);
	}

	/**
	 * this method is called after the click on the "start" button in the LobbyWindow
	 * --> only the host can call this method
	 */
	public void initializeGame() throws RemoteException {
		if(myServer.everybodyReady())
			myServer.startGame();
		else
			lobbyWindow.notEverybodyReady();
	}

	/**
	 * updates the TextArea in the LobbyWindow after a new Client has connected to the server.
	 */
	public void updateLobby(ArrayList<String> nicknames) {
		lobbyWindow.updateLobby(nicknames);
	}

	/**
	 * updates the own GameBoard without refreshing the GUI because the GUI hasn't been initialized at the start
	 */
	public void updateFirstGameBoard(E_GameBoard board) throws RemoteException {
		myGameboard = board;
	}

	/**
	 * updates the own GameBoard and refreshes the GUI
	 */
	public void updateGameBoard(E_GameBoard board) throws RemoteException {
		myGameboard = board;
		mygFrame.refreshAll();
	}

	/**
	 * sends the updated GameBoard to the server which will send it then to all the other clients.
	 */

	public void sendGameBoard() throws RemoteException {
		myServer.updateGameBoard(myGameboard);
	}

	/**
	 * used by Turn to reset itself, in case the player wants to cancel the turn made.
	 * @param turn E_Turn to update myTurn
	 */
	public void updateTurn(E_Turn turn)
	{
		myTurn = turn;
	}
	
	/**
	 * this method closes the main window and opens the EndGameWindow that shows the score.
	 * @param ArrayList with the scores in it
	 */
	public void endGame(ArrayList<String> scoreArrayList) throws RemoteException {
		for(int i = 0; i < scoreArrayList.size(); i++) {
			endGameWindow.addScore(scoreArrayList.get(i));
		}
		mygFrame.setVisible(false);
		endGameWindow.openEndGameWindow();
	}

	public boolean isHost() {
		return isHost;
	}


	public boolean isReady() {
		return this.isReady;
	}

	public void setReady(boolean ready) {
		this.isReady = ready;
	}

	//used by GUI

	public E_GameBoard getGameBoard()
	{
		return myGameboard;
	}

	//used by GUI

	public E_Turn getTurn()
	{
		return myTurn;
	}

	public E_gFrame getgFrame() throws RemoteException {
		return mygFrame;
	}

	public String getNickname() throws RemoteException {
		return myNickname;
	}

	public E_IFincaServer getServer(){
		return myServer;
	}

	public E_IChatClient getIChatClient() throws RemoteException {
		return mygFrame.getChatPanel().getChatClient();
	}

	public boolean isMyTurn() throws RemoteException {
		return isMyTurn;
	}

	public void setMyTurn(boolean isMyTurn) throws RemoteException {
		this.isMyTurn = isMyTurn;
		this.mygFrame.setMyTurnLabel(isMyTurn);
	}
}