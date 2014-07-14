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
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import E_loader.E_Loader;

/**
 * this class contains the window that opens when you start the game
 * 
 * @author mkmacbook
 *
 */
public class EE_LoaderWindow extends JFrame {

	private E_Loader loader;
	private JTextField nameTextField;
	private JLabel nicknameLabel;
	private JLabel joinGameButton;
	private JLabel hostGameButton;
	private JLabel background;
	private URL path;
	private Toolkit tk;
	private MediaTracker m;
	private Image image;

	public EE_LoaderWindow(E_Loader loader) {
		this.loader = loader;
		init();
		
	}

	private void init() {

		nameTextField = new JTextField();
		nicknameLabel = new JLabel("Enter Your Nickname");
		joinGameButton = new JLabel("Join Game");
		hostGameButton = new JLabel("Host Game");
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

		background.add(nicknameLabel);
		background.add(nameTextField);
		background.add(hostGameButton);
		background.add(joinGameButton);

		nicknameLabel.setBounds(80, 80, 270, 40);
		nicknameLabel.setVerticalAlignment(SwingConstants.CENTER);
		nicknameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nicknameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 24));

		nameTextField.setBounds(80, 150, 270, 40);
		nameTextField.setFont(new Font("Lucida Grande", 0, 20));
		nameTextField.setHorizontalAlignment(SwingConstants.CENTER);

		joinGameButton.setBounds(250, 300, 100, 50);
		joinGameButton.setVerticalAlignment(SwingConstants.CENTER);
		joinGameButton.setHorizontalAlignment(SwingConstants.CENTER);
		joinGameButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		joinGameButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		joinGameButton.setBackground(new Color(242, 209, 148));
		joinGameButton.setOpaque(true);


		hostGameButton.setBounds(80, 300, 100, 50);
		hostGameButton.setVerticalAlignment(SwingConstants.CENTER);
		hostGameButton.setHorizontalAlignment(SwingConstants.CENTER);
		hostGameButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		hostGameButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		hostGameButton.setBackground(new Color(242, 209, 148));
		hostGameButton.setOpaque(true);

		joinGameButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				joinGameButtonMouseClicked(evt);
			}	
		});

		hostGameButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				hostGameButtonMouseClicked(evt);
			}
		});
	}	

	private void joinGameButtonMouseClicked(MouseEvent evt) {
		loader.setNickname(nameTextField.getText());
		this.setVisible(false);
		loader.openJoinGameWindow();				
	}

	private void hostGameButtonMouseClicked(MouseEvent evt) {
		loader.setNickname(nameTextField.getText());
		this.setVisible(false);
		loader.openHostGameWindow();		
	}	

}
