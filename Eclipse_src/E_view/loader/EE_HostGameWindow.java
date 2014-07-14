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
import java.awt.event.KeyEvent;
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
 * this class contains the window that opens if you host a game
 * 
 * @author Michael KŸndig
 *
 */
public class EE_HostGameWindow extends JFrame {

	private E_Loader loader;
	private JLabel background;
	JTextField gameNameTextField;
	JLabel enterGameNameLabel;
	JLabel okButton;
	JLabel backButton;
	private URL path;
	private Toolkit tk;
	private MediaTracker m;
	private Image image;


	public EE_HostGameWindow(E_Loader loader) {
		this.loader = loader;
		init();
	}

	private void init() {

		gameNameTextField =  new JTextField();
		enterGameNameLabel = new JLabel("Enter The Name Of The Game");
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
		background.add(enterGameNameLabel);
		background.add(okButton);
		background.add(backButton);

		enterGameNameLabel.setBounds(40, 80, 350, 40);
		enterGameNameLabel.setVerticalAlignment(SwingConstants.CENTER);
		enterGameNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enterGameNameLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));

		gameNameTextField.setBounds(80, 150, 270, 40);
		gameNameTextField.setFont(new Font("Lucida Grande", 0, 20));
		gameNameTextField.setHorizontalAlignment(SwingConstants.CENTER);

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

		gameNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				gameNameTextFieldKeyPressed(evt);
			}
		});


	}

	private void okButtonMouseClicked(MouseEvent evt) {
		loader.setNameOfGame(gameNameTextField.getText());
		loader.hostGame();
		this.setVisible(false);
	}	

	private void backButtonMouseClicked(MouseEvent evt) {
		this.setVisible(false);
		loader.openLoaderWindow();
	}

	private void gameNameTextFieldKeyPressed(KeyEvent evt) {
		if(evt.getKeyCode() == 10) {
			loader.setNameOfGame(gameNameTextField.getText());
			loader.hostGame();
			this.setVisible(false);	
		}
	}
}
