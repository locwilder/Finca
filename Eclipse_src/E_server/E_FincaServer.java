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

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


import E_player.E_Player;
import E_playing_field.E_GameBoard;

import E_client.*;

/**
 * this class represents the server of the game. every client is connected to this server and updates the states of the game
 * through this server. the server only runs on the machine of the host.
 * @author Michael KŸndig
 */
public class E_FincaServer extends UnicastRemoteObject implements E_IFincaServer {

	private static final long serialVersionUID = -6600126695611484935L;

	private E_GameBoard serverGameBoard;
	ArrayList<E_IFincaClient> fincaClients = new ArrayList<E_IFincaClient>();
	int turnCounter = 0;

	/**
	 * the constructor creates a rmi registry on the standard port (=1099) and binds the entered name of the game to the registry.
	 * for this reason more than one game can be hosted by the same client. the games just can't have the same name
	 * @author: Michael KŸndig
	 * @pre: running host
	 * @post: server bound to rmi registry 
	 */
	public E_FincaServer(String serverName) throws RemoteException {		
		super();
		try {
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		}

		catch (RemoteException ex) {
			System.out.println(ex.getMessage());
		}
		try {
			Naming.rebind(serverName, this);
		}
		catch (MalformedURLException ex) {
			System.out.println(ex.getMessage());
		}
		catch (RemoteException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Server started");
	}

	/**
	 * this method creates a new GameBoard and sends it to all the clients. the clients can't call the constructor of the GameBoard
	 * by themselves because the GameBoard constructor creates a random GameBoard and therefore every client would have
	 * a different GameBoard.
	 *
	 * @author: Michael KŸndig
	 * @pre:
	 * @post:
	 */
	public void startGame(){
		try{
			ArrayList<String> nicknames = new ArrayList<String>();
			for (int i = 0; i < fincaClients.size(); i++) {
				nicknames.add(fincaClients.get(i).getNickname());
			}
			serverGameBoard = new E_GameBoard(nicknames);
			sendFirstGameBoard();
			for (int i= 0; i < fincaClients.size(); i++) {
				fincaClients.get(i).startGUIgFrame();
			}

		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * this method sends a message to all the clients registered in the ArrayList fincaClients.
	 * @author: Michael KŸndig
	 * @pre: game has to be started
	 * @post:
	 * @param: message to be sent
	 */
	public void postMessage(String message) throws RemoteException{
		if(message.contains("/end")) {
			this.endGame();
			return;
		}

		if(message.contains("/get fruits"))
		{
			for(int i=0; i<fincaClients.size(); i++)
			{
				serverGameBoard.add_donkey_player(i);
				serverGameBoard.add_donkey_player(i);
				serverGameBoard.add_donkey_player(i);
				serverGameBoard.add_donkey_player(i);
				serverGameBoard.add_donkey_player(i);
				serverGameBoard.add_fruit_player("almond", 50, i);
				serverGameBoard.add_fruit_player("fig", 50, i);
				serverGameBoard.add_fruit_player("grape", 50, i);
				serverGameBoard.add_fruit_player("lemon", 50, i);
				serverGameBoard.add_fruit_player("olive", 50, i);
				serverGameBoard.add_fruit_player("orange", 50, i);
			}
			sendGameBoardWithoutTurnChange();
			return;
		}

		for(int i = 0; i < fincaClients.size(); i++){
			fincaClients.get(i).getIChatClient().receiveMessage(message);
		}
	}

	/**
	 * this method checks if every fincacClient has set his state to ready. the host can only start the game if everybody is ready
	 * @author Michael KŸndig
	 * @pre: game has to be started
	 * @post:
	 * @return: true if all fincaClients are ready
	 */
	public boolean everybodyReady() throws RemoteException {
		for (int i = 0; i < fincaClients.size(); i++) {
			if (!fincaClients.get(i).isReady()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * this method is called by the constructor of the FincaClient. I adds a new FincaClient to the server.
	 * @author: Michael KŸndig
	 * @pre: 
	 * @post: new client in the fincaClients ArrayList
	 */
	public void newClient(E_IFincaClient client) {
		try {
			fincaClients.add(client);
			System.out.println("New FincaClient: " + client.getNickname());
			ArrayList<String> nicknames = new ArrayList<String>();
			for (int i = 0; i < fincaClients.size(); i++) {
				nicknames.add(fincaClients.get(i).getNickname());
			}

			for (int i= 0; i < fincaClients.size(); i++) {
				fincaClients.get(i).updateLobby(nicknames);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	/**
	 * this method first overrides the serverGameBoard with the given GameBoard. then it checks if the game has ended. if it has
	 * it calls the endGame() method, if not it sends the GameBoard to every client.
	 * @author: Michael KŸndig
	 * @pre: -
	 * @post: -
	 * @throws RemoteException
	 */
	public void updateGameBoard(E_GameBoard gameBoard) throws RemoteException {

		this.serverGameBoard = gameBoard;
		if(gameBoard.hasGameEnded()) {
			this.endGame();
			return;
		}
		sendGameBoardWithTurnChange();
	}

	/**
	 * this method is called by the updateGame(E_GameBoard gameBoard) method as soon as all wooden fincas have been placed and
	 * the game has ended. the method creates two ArrayLists. it adds all players in the first ArrayList and the score and name of
	 * the players in the second one. finally it calls the endGame(scoreArray) method for every client.
	 *
	 * @author Michael KŸndig
	 * @pre:
	 * @post:
	 * @throws RemoteException
	 */
	private void endGame() throws RemoteException {
		ArrayList<E_Player> playerArray = new ArrayList<E_Player>();
		for(int i = 0; i < serverGameBoard.getNumberOfPlayers(); i++) {
			playerArray.add(serverGameBoard.getPlayer(i));
		}
		ArrayList<String> scoreArray = new ArrayList<String>();
		int tempScore;
		int tempIndex;
		while(!playerArray.isEmpty()) {
			tempScore = playerArray.get(0).get_points();
			tempIndex = 0;
			for(int i = 0; i < playerArray.size(); i++) {
				if(playerArray.get(i).get_points() > tempScore) {
					tempScore = playerArray.get(i).get_points();
					tempIndex = i;
				}
			}
			scoreArray.add(playerArray.get(tempIndex).get_username());
			scoreArray.add("" + tempScore);
			playerArray.remove(tempIndex);
		}
		for (int i = 0; i < fincaClients.size(); i++) {
			fincaClients.get(i).endGame(scoreArray);
		}
	}

	/**
	 * this method sends the first GameBoard to every client. this method is necessary because the usual updateGameBoard method
	 * refreshes the GUI as well. But at this point the GUI isn't declared yet.
	 * @author: Michael KŸndig
	 * @pre:
	 * @post: updated GameBoard on every client.
	 * @throws RemoteException
	 * */
	public void sendFirstGameBoard() throws RemoteException {
		for (int i = 0; i < fincaClients.size(); i++) {
			fincaClients.get(i).updateFirstGameBoard(serverGameBoard);
		}
	}

	/**
	 * this method sends the serverGameBoard to all clients without setting the turn to the next player.
	 * this method is used to send the first gameBoard and after a turn has been canceled.
	 * @author: Michael KŸndig
	 * @pre:
	 * @post: updated GameBoard on every client.
	 * @throws RemoteException
	 */
	public void sendGameBoardWithoutTurnChange() throws RemoteException {
		for (int i = 0; i < fincaClients.size(); i++) {
			fincaClients.get(i).updateGameBoard(serverGameBoard);
		}
	}

	/**
	 * this method sends the serverGameBoard to all clients and sets the turn to the next client.
	 * used after a regular turn.
	 * @author: Michael KŸndig
	 * @pre:
	 * @post: updated GameBoard on every client and a new client's turn.
	 * @throws RemoteException
	 */
	public void sendGameBoardWithTurnChange() throws RemoteException {
		this.setTurnToNextPlayer();
		for (int i = 0; i < fincaClients.size(); i++) {
			fincaClients.get(i).updateGameBoard(serverGameBoard);
		}
	}

	/**
	 * this method return the number of a given client
	 * @author: Michael KŸndig
	 * @pre: -
	 * @post: -
	 * @return: number of players (x = 0,1,2,3)
	 * @param: fincaClient who's player number is returned 
	 * @throws RemoteException
	 */
	public int getPlayerNumber(E_IFincaClient client) throws RemoteException {
		for (int i = 0; i < fincaClients.size(); i++) {
			if (fincaClients.get(i).equals(client))
				return i;
		}
		return 6;
	}

	/**
	 * this method return a ArrayList with a nickname of each player at every index
	 * @author: Michael KŸndig
	 * @pre: -
	 * @post: -
	 * @return: ArrayList<String> with nicknames of players
	 * @throws RemoteException
	 */
	public ArrayList<String> getAllNicknames() throws RemoteException {
		ArrayList <String> nicknames = new ArrayList<String>();
		for(int i = 0; i < fincaClients.size(); i++){
			nicknames.add(fincaClients.get(i).getNickname());
		}
		return nicknames;
	}

	/**
	 * this method returns the number of players in the game
	 * @author: Michael KŸndig
	 * @return: number of players, size of ArrayList fincaClients
	 */
	public int getNumberOfPlayers()
	{
		return fincaClients.size();
	}

	/**
	 * this method is called if a client has ended its turn. it sets the isTurn boolean of the player that has ended the turn
	 * to false and the boolean of the next player to true.
	 * @author: Michael KŸndig
	 * @pre: isTurn boolean of one client has to be true
	 * @post: isTurn boolean true of next player
	 * @throws RemoteException
	 */
	private void setTurnToNextPlayer() throws RemoteException {
		int highestIndex = (fincaClients.size() - 1);
		int indexOfNextPlayer;
		for(int i = 0; i < fincaClients.size(); i++) {
			if(i < highestIndex)
				indexOfNextPlayer = i + 1;
			else
				indexOfNextPlayer = 0;

			if(fincaClients.get(i).isMyTurn()) {
				fincaClients.get(i).setMyTurn(false);
				fincaClients.get(indexOfNextPlayer).setMyTurn(true);
				return;
			}
		}
	}

	/**
	 * checks if the server is full. not more than 4 players are allowed to join the lobby
	 * @return true if server is full
	 */
	public boolean isServerFull() throws RemoteException {
		return (getNumberOfPlayers() >= 4);
	}

	/**
	 * @return playerNumber of the player who's myTurn boolean is true
	 */
	public int getPlayerNumberOfTurn() throws RemoteException {
		for (int i = 0; i < fincaClients.size(); i++) {
			if (fincaClients.get(i).isMyTurn())
				return i;
		}
		return 6;
	}
	
	/**
	 * @param playerNumber of the player to check if it's his turn
	 * @return true if player with playerNumber's myTurn is true
	 */
	public boolean isMyTurn(int playerNumber) throws RemoteException {
		return (fincaClients.get(playerNumber).isMyTurn());
	}
}
