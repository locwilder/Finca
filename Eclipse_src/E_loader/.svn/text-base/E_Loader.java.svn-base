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


package E_loader;


import java.rmi.RemoteException;
import E_server.*;
import E_client.*;
import E_view.loader.*;

public class E_Loader {
	
	

	private String nickname;
	private String nameOfGame;
	private String IPAddress;
	private EE_LoaderWindow loaderWindow;
	private EE_JoinGameWindow joinGameWindow;
	private EE_HostGameWindow hostGameWindow;

//	starting point of the game.
	
	public static void main(String[] args) throws RemoteException {
		new E_Loader();
	}

	public E_Loader() {
		loaderWindow = new EE_LoaderWindow(this);
		joinGameWindow = new EE_JoinGameWindow(this);
		hostGameWindow = new EE_HostGameWindow(this);
		loaderWindow.setVisible(true);
	}

	public void openLoaderWindow() {
		loaderWindow.setVisible(true);
	}

	public void openHostGameWindow() {
		hostGameWindow.setVisible(true);
	}

	public void openJoinGameWindow() {
		joinGameWindow.setVisible(true);
	}
	
//	this method is called after a click on the "OK" button in the HostGameWindow.
//	the FincaServer will run on the computer that calls this method.

	public void hostGame(){
		try{
			new E_FincaServer(nameOfGame);
			new E_FincaClient(nickname, nameOfGame, IPAddress, true);
		} catch (RemoteException e){
			e.printStackTrace();
		}
	}
	
//	this method is called after a click on the "OK" button in the JoinGameWindow
//	it adds a FincaClient to the FincaServer

	public void joinGame(){
		try{
			new E_FincaClient(nickname, nameOfGame, IPAddress, false);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setNameOfGame(String nameOfGame) {
		this.nameOfGame = nameOfGame;
	}

	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}
}