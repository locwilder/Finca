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


package E_view.loader;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import E_client.E_FincaClient;


/**
 * this class contains the window that opens when you join a lobby
 * @author mkmacbook
 *
 */
public class EE_LobbyWindow extends JFrame {

	private E_FincaClient myClient;
	private JLabel lobbyLabel;
	private JTextArea lobbyTextArea;
	private JLabel infoLabel;
	private JLabel readyButton;
	private JLabel startButton;
	private JLabel background;
	private URL path;
	private Toolkit tk;
	private MediaTracker m;
	private Image image;


	public EE_LobbyWindow(E_FincaClient client) {
		this.myClient = client;
		init();
		if (myClient.isHost()) {
			readyButton.setVisible(false);
			infoLabel.setVisible(false);
		}
		else {
			startButton.setVisible(false);
			infoLabel.setVisible(false);
		}

	}


	private void init() {
		lobbyLabel = new JLabel("Lobby");
		lobbyTextArea = new JTextArea();
		infoLabel = new JLabel("I'm Ready");
		readyButton = new JLabel("Ready");
		startButton = new JLabel("Start");
		
		path = getClass().getResource("/media/finca map/Background.png");
		tk = Toolkit.getDefaultToolkit();
		try{
			m = new MediaTracker(this);
			image = tk.getImage(path);
			m.addImage(image,0);
			m.waitForAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		background = new JLabel(new ImageIcon(image));
		background.setBounds(0, 0, 430, 450);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("FINCA");
		this.setSize(430, 450);
		this.setLocation(400, 150);
		this.add(background);

		background.add(lobbyLabel);
		background.add(readyButton);
		background.add(infoLabel);
		background.add(startButton);
		background.add(lobbyTextArea);

		lobbyLabel.setBounds(80, 80, 270, 40);
		lobbyLabel.setVerticalAlignment(SwingConstants.CENTER);
		lobbyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lobbyLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));

		lobbyTextArea.setBounds(80, 140, 270, 160);
		lobbyTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		lobbyTextArea.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lobbyTextArea.setBackground(new Color(242, 209, 148));
		lobbyTextArea.setOpaque(true);
		lobbyTextArea.setEditable(false);
		

		readyButton.setBounds(165, 360, 100, 50);
		readyButton.setVerticalAlignment(SwingConstants.CENTER);
		readyButton.setHorizontalAlignment(SwingConstants.CENTER);
		readyButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		readyButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		readyButton.setBackground(new Color(242, 209, 148));
		readyButton.setOpaque(true);

		startButton.setBounds(165, 360, 100, 50);
		startButton.setVerticalAlignment(SwingConstants.CENTER);
		startButton.setHorizontalAlignment(SwingConstants.CENTER);
		startButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		startButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		startButton.setBackground(new Color(242, 209, 148));
		startButton.setOpaque(true);

		infoLabel.setBounds(120, 320, 190, 30);
		infoLabel.setVerticalAlignment(SwingConstants.CENTER);
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		infoLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		infoLabel.setBackground(new Color(137, 140, 35));
		infoLabel.setOpaque(true);


		readyButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				readyButtonMouseClicked(evt);
			}
		});

		startButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				startButtonMouseClicked(evt);
			}
		});

	}

	private void readyButtonMouseClicked(MouseEvent evt) {
		if (myClient.isReady()) {
			myClient.setReady(false);
			infoLabel.setVisible(false);
			return;
		}
		if (!myClient.isReady()) {
			myClient.setReady(true);
			infoLabel.setText("I am Ready");
			infoLabel.setVisible(true);
		}
	}

	private void startButtonMouseClicked(MouseEvent evt) {
		try {
			if (myClient.getServer().getNumberOfPlayers() > 1) {
				myClient.initializeGame();
			}
			
			else {
				infoLabel.setText("Only 1 Player");
				infoLabel.setVisible(true);
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void notEverybodyReady() {
		infoLabel.setText("Not Everybody Ready");
		infoLabel.setVisible(true);
	}

	public void updateLobby(ArrayList<String> nicknames) {
		if (myClient.isHost())
			infoLabel.setVisible(false);
		lobbyTextArea.setText("");
		for(int i=0; i<nicknames.size(); i++) {
			lobbyTextArea.append(nicknames.get(i) + "      " + "\n");
		}	
	}
}
