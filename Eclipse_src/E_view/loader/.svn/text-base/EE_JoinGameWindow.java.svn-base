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
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import E_loader.E_Loader;
import E_server.E_IFincaServer;

/**
 * this class contains the window that opens if you join a game
 * 
 * @author mkmacbook
 *
 */
public class EE_JoinGameWindow extends JFrame implements Serializable {
	
	private E_Loader loader;
	private JLabel background;
	private JTextField gameNameTextField;
	private JTextField ipAddressTextField;
	private JLabel enterIPLabel;
	private JLabel enterGameNameLabel;
	private JLabel okButton;
	private JLabel backButton;
	private JLabel serverFullLabel;
	private boolean serverFull;
	private URL path;
	private Toolkit tk;
	private MediaTracker m;
	private Image image;
	
	public EE_JoinGameWindow(E_Loader loader) {
		this.loader = loader;
		init();
	}
	
	private void init() {
		
		gameNameTextField =  new JTextField();
		ipAddressTextField = new JTextField();
		enterIPLabel = new JLabel("Enter The IP Of The Game");
		enterGameNameLabel = new JLabel("Enter The Name Of The Game");
		serverFullLabel = new JLabel("The Server Is Full!");
		okButton = new JLabel("OK");
		backButton = new JLabel("Back");
		
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

		background.add(gameNameTextField);
		background.add(ipAddressTextField);
		background.add(enterGameNameLabel);
		background.add(enterIPLabel);
		background.add(okButton);
		background.add(backButton);
		background.add(serverFullLabel);
		
		
		enterGameNameLabel.setBounds(40, 40, 350, 40);
		enterGameNameLabel.setVerticalAlignment(SwingConstants.CENTER);
		enterGameNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enterGameNameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		
		serverFullLabel.setBounds(115, 240, 200, 40);
		serverFullLabel.setVerticalAlignment(SwingConstants.CENTER);
		serverFullLabel.setHorizontalAlignment(SwingConstants.CENTER);
		serverFullLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		serverFullLabel.setBackground(new Color(242, 209, 148));
		serverFullLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		serverFullLabel.setOpaque(true);
		serverFullLabel.setVisible(false);
		
		gameNameTextField.setBounds(80, 80, 270, 40);
		gameNameTextField.setFont(new Font("Lucida Grande", 0, 20));
		gameNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		
		enterIPLabel.setBounds(40, 150, 350, 40);
		enterIPLabel.setVerticalAlignment(SwingConstants.CENTER);
		enterIPLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enterIPLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		
		ipAddressTextField.setBounds(80, 190, 270, 40);
		ipAddressTextField.setFont(new Font("Lucida Grande", 0, 20));
		ipAddressTextField.setHorizontalAlignment(SwingConstants.CENTER);

		okButton.setBounds(80, 300, 100, 50);
		okButton.setVerticalAlignment(SwingConstants.CENTER);
		okButton.setHorizontalAlignment(SwingConstants.CENTER);
		okButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		okButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		okButton.setBackground(new Color(242, 209, 148));
		okButton.setOpaque(true);

		backButton.setBounds(250, 300, 100, 50);
		backButton.setVerticalAlignment(SwingConstants.CENTER);
		backButton.setHorizontalAlignment(SwingConstants.CENTER);
		backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		backButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		backButton.setBackground(new Color(242, 209, 148));
		backButton.setOpaque(true);

		okButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				okButtonMouseClicked(evt);
			}
		});

		backButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				backButtonMouseClicked(evt);
			}
		});
		
	}
	
	private void okButtonMouseClicked(MouseEvent evt) {
		try {
			Registry registry = LocateRegistry.getRegistry(ipAddressTextField.getText());
			E_IFincaServer myServer = (E_IFincaServer) registry.lookup(gameNameTextField.getText());
			
			if (!myServer.isServerFull()) {
			loader.setNameOfGame(gameNameTextField.getText());
	    	loader.setIPAddress(ipAddressTextField.getText());
	    	loader.joinGame();
	    	this.setVisible(false);
			}
			else
				serverFullLabel.setVisible(true);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	private void backButtonMouseClicked(MouseEvent evt) {
		 this.setVisible(false);
	        loader.openLoaderWindow();
	}
}
