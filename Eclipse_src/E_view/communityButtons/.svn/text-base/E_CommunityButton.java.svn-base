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


package E_view.communityButtons;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import E_client.E_FincaClient;

import E_view.E_gPanel;


/**
 * Creates a button for every community. These buttons assigns the images of the 
 * fruit tiles to their communities.
 *  
 * @author MALIB
 *
 */
public class E_CommunityButton extends JButton implements ActionListener {

	private E_FincaClient fincaClient;
	private int communityNumber;
	private ImageIcon fruitImage;
	private Image fImage;
	private Image rImage;
	private Graphics image_scaled;
	private ImageIcon randImage;
	private int counter;
	private String fstr;
	private JPanel jPanel;
	private String strfruit;
	private URL path;
	private Toolkit tk;
	private MediaTracker m;


	public E_CommunityButton(E_FincaClient fc,E_gPanel gp, int communityNr){



		this.communityNumber = communityNr;
		fincaClient = fc;
		jPanel = gp;

		if(fincaClient != null){
			counter = fincaClient.getGameBoard().getMap().get_communities().get(communityNumber).get_number_of_fruittiles();
			fstr = fincaClient.getGameBoard().getMap().get_communities().get(communityNumber).get_top_fruittile().get_tile_name();
		}

		/*
		 * checks the amount of the fruits which are assigned to the community
		 * @pre get_number_of_fruits() != NULL 
		 * @post get_number_of_fruits() < 5 && get_number_of_fruits() >= 0
		 */

		if(counter == 0){
			this.setVisible(false);
		}else{
			init();
			this.setVisible(true);
		}
		this.addActionListener(this);
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setRolloverEnabled(false);
		this.setPressedIcon(null);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setBackground(new Color(0,0,0,0));
	}


	/*
	 * The amount of the fruit tiles
	 * @pre counter@pre != NULL
	 * @post counter < 5 && counter >= 0
	 * @return a integer between 0 and 4
	 */
	public int getCtr(){
		return counter;
	}


	/*
	 * After every turn, this method updates the new number of the counter and the new images of the next fruit
	 * tile if the fruit tile on the top was removed
	 * @pre...
	 * @post...
	 */
	public void refresh()
	{
		counter = fincaClient.getGameBoard().getMap().get_communities().get(communityNumber).get_number_of_fruittiles();
		if(fincaClient.getGameBoard().getMap().get_communities().get(communityNumber).get_top_fruittile()==null){
			init_last();
		}else {
			fstr = fincaClient.getGameBoard().getMap().get_communities().get(communityNumber).get_top_fruittile().get_tile_name();
			setVisible(true);
			init();
		}
	}

	/*
	 * When there is no fruit tile anymore in the community it sets the image of the finca house to the community 
	 * @pre get_top_fruittile() == NULL
	 * @pre setVisible = false
	 */
	private void init_last(){
		setVisible(false);

		tk = Toolkit.getDefaultToolkit();
		path = getClass().getClassLoader().getResource("media/finca pics/fincahouse.png");
		try{
			m = new MediaTracker(this);
			fImage = tk.getImage(path);
			m.waitForAll();
		}catch (Exception e){
			e.printStackTrace();
		}
		fruitImage = new ImageIcon(fImage);

	}

	/*
	 * Sets the image of the top fruit tile and the image of the
	 * right edge  
	 * @pre...
	 * @post...
	 */

	private void init() {
		m = new MediaTracker(this);
		tk = tk.getDefaultToolkit();

		strfruit = "media/finca pics/Fruittiles/" + fstr;
		path = getClass().getClassLoader().getResource(strfruit);
		try{
			fImage = tk.getImage(path);
			m.waitForAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		fruitImage = new ImageIcon(fImage);


		switch(counter){
		case 0: 
			setVisible(false);
		case 1:
			path = getClass().getClassLoader().getResource("media/finca pics/rand1.png");
			try{
				rImage = tk.getImage(path);
				m.waitForAll();
			}catch(Exception e){
				e.printStackTrace();
			}
			randImage = new ImageIcon(rImage);
			break;
		case 2: 
			path = getClass().getClassLoader().getResource("media/finca pics/rand2.png");
			try{
				rImage = tk.getImage(path);
				m.waitForAll();
			}catch(Exception e){
				e.printStackTrace();
			}
			randImage = new ImageIcon(rImage);
			break;
		case 3: 
			path = getClass().getClassLoader().getResource("media/finca pics/rand3.png");
			try{
				rImage = tk.getImage(path);
				m.waitForAll();
			}catch(Exception e){
				e.printStackTrace();
			}
			randImage = new ImageIcon(rImage);
			break;
		case 4: 
			path = getClass().getClassLoader().getResource("media/finca pics/rand4.png");
			try{
				rImage = tk.getImage(path);
				m.waitForAll();
			}catch(Exception e){
				e.printStackTrace();
			}
			randImage = new ImageIcon(rImage);
			break;
		default:
			break;
		}
	}



	/*
	 * When you click on a button, this method performs a action.
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent evt){
		try{
			//checks the turn of the player, when its true it continues perform a action
			if(fincaClient.isMyTurn()){
				//checks if the fruittile has a riddle to replace with a fruit
				if(fincaClient.getGameBoard().getMap().get_communities().get(communityNumber).get_top_fruittile().get_riddle_cost() == 0)
				{
					//checks if the fruittile can be bought or not.
					if(fincaClient.getTurn().useCommunity(communityNumber, fincaClient.getGameBoard(), ""))
					{
						if(fincaClient.getGameBoard().getMap().get_communities().get(communityNumber).get_top_fruittile()==null){
							fincaClient.getgFrame().refreshAll();
						}
						else {
							jPanel.repaint();
							strfruit = "media/finca pics/Fruittiles/blank.png";
							path = getClass().getClassLoader().getResource(strfruit);
							try{
								fImage = tk.getImage(path);
								m.waitForAll();
							}catch(Exception e){
								e.printStackTrace();
							}
							fruitImage = new ImageIcon(fImage);
						}
					}
					else {
						fincaClient.getIChatClient().receiveMessage("You can't deliver these fruits");
					}
				}
				else
				{
					Object[] possibilities = {"Almond", "Fig", "Orange", "Lemon", "Grape", "Olive"};
					String whatFruit = (String)JOptionPane.showInputDialog(
							null,
							"Which fruit would you like to use?\n",
							"Choose",
							JOptionPane.PLAIN_MESSAGE,
							null,
							possibilities,
					"Almond");

					if(fincaClient.getTurn().useCommunity(communityNumber, fincaClient.getGameBoard(), whatFruit))
					{
						if(fincaClient.getGameBoard().getMap().get_communities().get(communityNumber).get_top_fruittile()==null){
							fincaClient.getgFrame().refreshAll();
						}
						else {
							jPanel.repaint();
							strfruit = "media/finca pics/Fruittiles/blank.png";
							path = getClass().getClassLoader().getResource(strfruit);
							try{
								fImage = tk.getImage(path);
								m.waitForAll();
							}catch(Exception e){
								e.printStackTrace();
							}
							fruitImage = new ImageIcon(fImage);
						}
					}
					else {						
						fincaClient.getIChatClient().receiveMessage("You can't deliver these fruits");
					}
				}
			}else{
				fincaClient.getgFrame().getChatPanel().printMessage("It's not your Turn!");
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}	
	/*
	 * this method belongs to the JComponent 
	 * it paints the border of the fruit tile and over that the fruit tile
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */

	protected void paintComponent(Graphics g){
		super.paintComponent(g);


		if(counter == 4){
			Graphics2D grand = (Graphics2D) g;
			grand.drawImage(rImage,0,0,60,60,this);
			Graphics2D gfruit = (Graphics2D)g;
			gfruit.drawImage(fImage,7,0,50,50, this);
		}else if(counter == 3){
			Graphics2D grand = (Graphics2D) g;
			grand.drawImage(rImage,0,0,62,62,this);
			Graphics2D gfruit = (Graphics2D)g;
			gfruit.drawImage(fImage,7,3,50,50, this);
		}else if(counter == 2){
			Graphics2D grand = (Graphics2D) g;
			grand.drawImage(rImage,0,0,61,61,this);
			Graphics2D gfruit = (Graphics2D)g;
			gfruit.drawImage(fImage,7,6,49,49, this);
		}else if(counter == 1){
			Graphics2D grand = (Graphics2D) g;
			grand.drawImage(rImage,0,0,60,60,this);
			Graphics2D gfruit = (Graphics2D)g;
			gfruit.drawImage(fImage,6,8,49,49, this);
		}else if(counter == 0){
			Graphics2D gfruit = (Graphics2D)g;
			gfruit.drawImage(fImage,7,7,49,49, this);
		}
	}
}