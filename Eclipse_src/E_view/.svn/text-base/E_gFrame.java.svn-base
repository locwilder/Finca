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


package E_view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import E_view.player.E_BluePlayerInfo;
import E_view.player.E_PlayerInfos;
import E_view.player.E_GreenPlayerInfo;
import E_view.player.E_RedPlayerInfo;
import E_view.player.E_YellowPlayerInfo;

import E_client.E_FincaClient;


/**
 * This class is the frame of the GUI and through this class you can access
 * to the other classes that have something to do with the GUI.
 * This class contains the background, the map, the different panels and
 * the buttons.
 * The GUI is started through this class.
 * 
 * @author thavo, mkuendig, michael_keller, malib, locwilder
 * 
 */
public class E_gFrame extends JFrame {


	private JLabel endTurnButton;
	private JLabel cancelTurnButton;
	private JLabel myTurnLabel;
	private JLabel gameInfoLabel;
	private Color seaBlue;
	private Color backgroundPanelColor;

	private E_FincaClient fincaClient;
	private ArrayList<E_PlayerInfos> playerInfos;
	private E_gBackgroundImage gback;
	private E_gMapImage gmap;
	private E_gPanel gpanel;
	private E_ChatPanel chatPanel;
	private E_SupplyPanel spanel;
	private JMenuBar mbar;
	private JMenu mFile;
	private JMenu mHelp;
	private JMenuItem miQuit;
	private JMenuItem miRules;
	private E_BluePlayerInfo bluePlayerInfo;
	private E_RedPlayerInfo redPlayerInfo;
	private E_YellowPlayerInfo yellowPlayerInfo;
	private E_GreenPlayerInfo greenPlayerInfo;

	public E_gFrame(E_FincaClient client) throws RemoteException {
		this.fincaClient = client;		
		init();
		this.setVisible(true);

	}

	/**
	 * refreshes all Communities
	 * @pre...
	 * @post...
	 * @throws RemoteException
	 */
	public void refreshAll() throws RemoteException{
		this.refreshPlayerInfos();
		spanel.refresh();
		gpanel.updateAllFarmerSpots();
		gpanel.refresh_community("alcudia");
		gpanel.refresh_community("andratix");
		gpanel.refresh_community("arta");
		gpanel.refresh_community("campos");
		gpanel.refresh_community("inca");
		gpanel.refresh_community("llucmajor");
		gpanel.refresh_community("palma");
		gpanel.refresh_community("santanyi");
		gpanel.refresh_community("sonsevera");
		gpanel.refresh_community("villafranca");
		this.repaint();
	}
	
	/**
	 * refreshes the information about the players
	 * @pre...
	 * @post...
	 * @throws RemoteException
	 */
	public void refreshPlayerInfos() throws RemoteException{
		for(int i = 0; i < playerInfos.size(); i++) {
			playerInfos.get(i).refresh();
		}
	}
	

	/**
	 * creates and loads all the images in the GUI like Map, Background Image,
	 * different Panels for the supply, players etc.
	 * @pre
	 * @post
	 * @throws RemoteException
	 */
	private void init() throws RemoteException {

		endTurnButton = new JLabel();
		cancelTurnButton = new JLabel();
		myTurnLabel = new JLabel();
		gameInfoLabel = new JLabel();
		seaBlue = new Color(19, 56, 116);
		backgroundPanelColor = new Color(131, 182, 168);

		gback = new E_gBackgroundImage();
		gmap = new E_gMapImage(fincaClient);
		spanel = new E_SupplyPanel(fincaClient);
		gpanel = new E_gPanel(gmap,fincaClient);
		mbar = new JMenuBar();
		mFile = new JMenu();
		mHelp = new JMenu();
		miQuit = new JMenuItem();
		miRules = new JMenuItem();
		chatPanel = new E_ChatPanel();
		bluePlayerInfo = new E_BluePlayerInfo(fincaClient);
		redPlayerInfo = new E_RedPlayerInfo(fincaClient);
		playerInfos = new ArrayList<E_PlayerInfos>();
		playerInfos.add(bluePlayerInfo);
		playerInfos.add(redPlayerInfo);
		if(this.fincaClient.getGameBoard().getNumberOfPlayers() == 3)
		{
			yellowPlayerInfo = new E_YellowPlayerInfo(fincaClient);
			playerInfos.add(yellowPlayerInfo);
		} else if (this.fincaClient.getGameBoard().getNumberOfPlayers() == 4)
		{
			yellowPlayerInfo = new E_YellowPlayerInfo(fincaClient);
			greenPlayerInfo = new E_GreenPlayerInfo(fincaClient);
			playerInfos.add(yellowPlayerInfo);
			playerInfos.add(greenPlayerInfo);
		}



		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//sets the size of the frame
		this.setPreferredSize(new Dimension(1100,730));

		this.setLocation(120,25);
		this.setTitle(fincaClient.getNickname());

		{	//adds the background to (over) the frame
			this.getContentPane().add(gback);
			gback.setPreferredSize(new Dimension(1050,700));
			{
				//sets the layout without a layout manager
				gback.setLayout(null);//new BorderLayout());
				//adds the gMapImage class to (over) the background

				gmap.setBounds(0, 0, 800, 500);
				spanel.setBounds(10,510,400,150);
				chatPanel.setBounds(520, 510, 280, 150);
				bluePlayerInfo.setBounds(810, 5, 270 ,162);
				redPlayerInfo.setBounds(810, 170, 270, 162);

				//Label to show the turn of the a player
				myTurnLabel.setBounds(420, 510, 90, 50);
				myTurnLabel.setHorizontalAlignment(SwingConstants.CENTER);
				myTurnLabel.setVerticalAlignment(SwingConstants.CENTER);
				myTurnLabel.setBorder(BorderFactory.createLineBorder (seaBlue, 2));
				myTurnLabel.setForeground(seaBlue);
				myTurnLabel.setBackground(backgroundPanelColor);
				myTurnLabel.setFont(new java.awt.Font("Lucida Grande", Font.BOLD, 12));
				myTurnLabel.setOpaque(true);
				myTurnLabel.setVisible(true);
				gback.add(myTurnLabel);

				//Label to end the turn
				endTurnButton.setBounds(420, 570, 90, 40);
				endTurnButton.setText("End Turn");
				endTurnButton.setHorizontalAlignment(SwingConstants.CENTER);
				endTurnButton.setVerticalAlignment(SwingConstants.CENTER);
				endTurnButton.setBorder(BorderFactory.createLineBorder (seaBlue, 2));
				endTurnButton.setForeground(seaBlue);
				endTurnButton.setBackground(backgroundPanelColor);
				endTurnButton.setFont(new java.awt.Font("Lucida Grande", Font.BOLD, 12));
				endTurnButton.setOpaque(true);
				endTurnButton.setVisible(true);
				gback.add(endTurnButton);


				endTurnButton.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						try {
							if (fincaClient.isMyTurn() && fincaClient.getTurn().hasPlayerMadeTurn()) 
							{
								fincaClient.getTurn().endTurn();
								fincaClient.sendGameBoard();
								gpanel.setHasMovedYet(false);
							}
							else if(!fincaClient.isMyTurn())
							{
								chatPanel.printMessage("It's not your Turn!");
							}
							else
							{
								chatPanel.printMessage("You have to make a full Turn first!");
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				
				//Label to cancel the turn
				cancelTurnButton.setBounds(420, 620, 90	, 40);
				cancelTurnButton.setText("Cancel Turn");
				cancelTurnButton.setHorizontalAlignment(SwingConstants.CENTER);
				cancelTurnButton.setVerticalAlignment(SwingConstants.CENTER);
				cancelTurnButton.setBorder(BorderFactory.createLineBorder (seaBlue, 2));
				cancelTurnButton.setForeground(seaBlue);
				cancelTurnButton.setBackground(backgroundPanelColor);
				cancelTurnButton.setFont(new java.awt.Font("Lucida Grande", Font.BOLD, 12));
				cancelTurnButton.setOpaque(true);
				endTurnButton.setVisible(true);
				gback.add(cancelTurnButton);
				
				//sets the GUI back 
				cancelTurnButton.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						try {
							if (fincaClient.isMyTurn()) {
								fincaClient.getTurn().cancelTurn();
								fincaClient.getServer().sendGameBoardWithoutTurnChange();
								refreshAll();
								chatPanel.printMessage("Your Moves have been reset");
								gpanel.setHasMovedYet(false);
							}
							else {
								chatPanel.printMessage("It's not your Turn!");
							}
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				gameInfoLabel.setBounds(10, 660, 1040, 32);
				gameInfoLabel.setFont(new Font("Tahoma", 0, 15));
				gameInfoLabel.setVerticalAlignment(SwingConstants.CENTER);
				gameInfoLabel.setOpaque(false);
				gameInfoLabel.setVisible(true);
				gback.add(gameInfoLabel);

				
				
				//includes the different Panels like supply, chat, player etc.
				//into the background Panel
				gback.add(gmap);
				gback.add(spanel);
				gback.add(chatPanel);
				gback.add(bluePlayerInfo);
				gback.add(redPlayerInfo);
				if(this.fincaClient.getGameBoard().getNumberOfPlayers() == 3)
				{
					gback.add(yellowPlayerInfo);
					yellowPlayerInfo.setBounds(810, 335, 270, 162);
				}else if (this.fincaClient.getGameBoard().getNumberOfPlayers() == 4)
				{
					gback.add(yellowPlayerInfo);
					yellowPlayerInfo.setBounds(810, 335, 270, 162);
					gback.add(greenPlayerInfo);
					greenPlayerInfo.setBounds(810,500, 270, 162);
				}


				//sets the places and sizes of both classes

				{
					//adds the gPanel to gMapImage
					gmap.setLayout(null);
					gmap.add(gpanel);
					gpanel.setBounds(5, 5, 790, 490);

				}
			}
		}

		//adds a Menu file
		mFile.setText("File");

		//adds MenuItem quit
		miQuit.setText("Quit");
		miQuit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				miQuit_ActionPerformed(evt);
			}
		});


		mFile.add(miQuit);

		mbar.add(mFile);

		mHelp.setText("Help");

		miRules.setText("Finca Rules");
		
		miRules.setText("Finca Rules");
		
		//opens the pdf
		miRules.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent evt){
				miRules_ActionPerformed(evt);
			}
		});
		
		mHelp.add(miRules);

		mbar.add(mHelp);

		setJMenuBar(mbar);

		this.pack();
	}


	//opens the Rules of the Finca game as pdf format
	protected void miRules_ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		E_FincaPDF test = new E_FincaPDF();
	}

	//performs by clicking the quit MenuItem to show up the class exitGame 
	protected void miQuit_ActionPerformed(ActionEvent evt) {
		E_exitGame exit = new E_exitGame();
	}
	
	//shows on the Label myTurnLabel whos turn is it
	public void setMyTurnLabel(boolean myTurn) {
		if (myTurn == true) {
			myTurnLabel.setText("Your Turn");
			myTurnLabel.setBackground(new Color(92, 155, 182));
		}
		else {
			myTurnLabel.setText("Please Wait");
			myTurnLabel.setBackground(backgroundPanelColor);
		}
	}

	
	public E_ChatPanel getChatPanel() {
		return this.chatPanel;
	}
	
	public E_gPanel getgPanel() {
		return this.gpanel;
	}
	
	public void setGameInfoLabelText(String text) {
		gameInfoLabel.setText(text);
	}
}
