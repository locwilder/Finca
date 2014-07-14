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

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import javax.tools.Tool;

import E_client.E_FincaClient;

import E_playing_field.E_GameBoard;


/**
 * This class includes information about the fruits in the pool,
 * about the donkey carts which are not assgined to a player, about
 * the bonus plates and the finca houses
 * 
 * @author thavo.mkuendig, michael_keller, malib, locwilder
 *
 */
public class E_SupplyPanel extends JPanel {


	private JLabel almondLab;	
	private JLabel figLab;
	private JLabel grapeLab;
	private JLabel lemonLab;
	private JLabel oliveLab;
	private JLabel orangeLab;
	private JLabel donkeyLab;
	private JLabel fincaLab;
	private JLabel fincat7;
	private JLabel fincat6;
	private JLabel fincat5;
	private JLabel fincat4;
	private JLabel finca_house;
	private Image image;
	private Image image7;
	private Image image6;
	private Image image5;
	private Image image4;
	private ImageIcon imageicon;
	private ImageIcon imageicon_used7;
	private ImageIcon imageicon_used6;
	private ImageIcon imageicon_used5;
	private ImageIcon imageicon_used4;
	
	private Icon icon;
	private E_FincaClient fclient;
	private URL path;
	private URL path_used;
	private Toolkit tk;
	private MediaTracker m;


	
	public E_SupplyPanel(E_FincaClient fc){
		
		fclient = fc;
		this.setLayout(null);
		init();
		this.setPreferredSize(new java.awt.Dimension(400, 150));
		this.setBackground(new Color(255,255,255,75));
		donkeyLab.setText("x " + String.valueOf(fclient.getGameBoard().getMap().get_donkycount()));

	}

	
	/**
	 * After every turn, this method updates the new amounts of the fruits, the donkey carts and the fincahouse in the GUI 
	 * @pre get_amount(string) != NULL
	 * @post ...
	 */
	public void refresh()
	{
		almondLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("almond")));
		figLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("fig")));
		grapeLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("grape")));
		lemonLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("lemon")));
		oliveLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("olive")));
		orangeLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("orange")));
		donkeyLab.setText("x " + String.valueOf(fclient.getGameBoard().getMap().get_donkycount()));
		finca_house.setText("x " + String.valueOf(fclient.getGameBoard().getNrOfFincas()));
		bonus_Plate_refresh();
	}
	
	
	/**
	 * After every turn, this method updates the new informations about
	 * the bonus plates
	 * @pre @pre size() != NULL
	 * @post ...
	 */
	
	private void bonus_Plate_refresh(){
		if(fclient.getGameBoard().getMap().get_all_bonustiles().size() ==3){
			fincat7.setIcon(imageicon_used7);
		}else if (fclient.getGameBoard().getMap().get_all_bonustiles().size() ==2){
			fincat7.setIcon(imageicon_used7);
			fincat6.setIcon(imageicon_used6);
		}else if (fclient.getGameBoard().getMap().get_all_bonustiles().size() ==1){
			fincat7.setIcon(imageicon_used7);
			fincat6.setIcon(imageicon_used6);
			fincat5.setIcon(imageicon_used5);
		}else if(fclient.getGameBoard().getMap().get_all_bonustiles().size() ==0){
			fincat7.setIcon(imageicon_used7);
			fincat6.setIcon(imageicon_used6);
			fincat5.setIcon(imageicon_used5);
			fincat4.setIcon(imageicon_used4);
		}
	}
	
	
	/**
	 * In this method the images of the fruits, the donkey cart, the finca house
	 * and the bonusplates are placed as icons 
	 * @pre...
	 * @post...
	 */
	
	private void init() {
		// TODO Auto-generated method stub
		
		almondLab = new JLabel();
		figLab = new JLabel();
		grapeLab = new JLabel();
		lemonLab = new JLabel();
		oliveLab = new JLabel();
		orangeLab = new JLabel();
		donkeyLab = new JLabel();
		fincat7 = new JLabel();
		fincat6 = new JLabel();
		fincat5 = new JLabel();
		fincat4 = new JLabel();
		finca_house = new JLabel();
		
		//load images and place the images with their corresponding numbers
		{	
			path = getClass().getResource("/media/finca pics/almond.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	      		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			almondLab.setIcon(imageicon);
			almondLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("almond")));
			almondLab.setVerticalTextPosition(JLabel.BOTTOM);
			almondLab.setHorizontalTextPosition(JLabel.CENTER);
			this.add(almondLab);
			almondLab.setBounds(5,15,60,70);
		}
		{
			path = getClass().getResource("/media/finca pics/fig.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	      		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			figLab.setIcon(imageicon);
			figLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("fig")));
			figLab.setVerticalTextPosition(JLabel.BOTTOM);
			figLab.setHorizontalTextPosition(JLabel.CENTER);
			this.add(figLab);
			figLab.setBounds(50,15,60,70);
		}
		{
			path = getClass().getResource("/media/finca pics/grape.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	      		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			grapeLab.setIcon(imageicon);
			grapeLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("grape")));
			grapeLab.setVerticalTextPosition(JLabel.BOTTOM);
			grapeLab.setHorizontalTextPosition(JLabel.CENTER);
			this.add(grapeLab);
			grapeLab.setBounds(95,15,60,70);
		}
		{
			path = getClass().getResource("/media/finca pics/lemon.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	      		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			lemonLab.setIcon(imageicon);
			lemonLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("lemon")));
			lemonLab.setVerticalTextPosition(JLabel.BOTTOM);
			lemonLab.setHorizontalTextPosition(JLabel.CENTER);
			this.add(lemonLab);
			lemonLab.setBounds(140,15,60,70);
		}
		{
			path = getClass().getResource("/media/finca pics/olive.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	      		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			oliveLab.setIcon(imageicon);
			oliveLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("olive")));
			oliveLab.setVerticalTextPosition(JLabel.BOTTOM);
			oliveLab.setHorizontalTextPosition(JLabel.CENTER);
			this.add(oliveLab);
			oliveLab.setBounds(185,15,60,70);
		}
		{
			path = getClass().getResource("/media/finca pics/orange.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	      		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			orangeLab.setIcon(imageicon);
			orangeLab.setText(String.valueOf(fclient.getGameBoard().getMap().get_amount("orange")));
			orangeLab.setVerticalTextPosition(JLabel.BOTTOM);
			orangeLab.setHorizontalTextPosition(JLabel.CENTER);
			this.add(orangeLab);
			orangeLab.setBounds(230,15,60,70);
		}
		{
			path = getClass().getResource("/media/finca pics/donkey.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	      		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			donkeyLab.setIcon(imageicon);
			donkeyLab.setText("x " + String.valueOf(fclient.getGameBoard().getMap().get_donkycount()));
			donkeyLab.setVerticalTextPosition(JLabel.CENTER );
			donkeyLab.setHorizontalTextPosition(JLabel.RIGHT);
			this.add(donkeyLab);
			donkeyLab.setBounds(290,15,90,70);
		}
		{
			int i = 1;
			path = getClass().getResource("/media/finca pics/bonusplate7.png");
			path_used = getClass().getResource("/media/finca pics/bonusplate7used.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    		image7 = tk.getImage(path_used).getScaledInstance(50, 50, Image.SCALE_SMOOTH);

	    		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			imageicon_used7 = new ImageIcon(image7);
			fincat7.setIcon(imageicon);
			this.add(fincat7);
			fincat7.setBounds(205,90,60,60);
			if(i != 0 ){
				fincat7.setVisible(true);
			}else{
				fincat7.setVisible(false);
			}
		}
		{
			int i = 1;
			path = getClass().getResource("/media/finca pics/bonusplate6.png");
			path_used = getClass().getResource("/media/finca pics/bonusplate6used.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    		image6 = tk.getImage(path_used).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			imageicon_used6 = new ImageIcon(image6);
			fincat6.setIcon(imageicon);
			this.add(fincat6);
			fincat6.setBounds(145,90,60,60);
			if(i != 0 ){
				fincat6.setVisible(true);
			}else{
				fincat6.setVisible(false);
			}
		}
		{
			int i = 1;
			path = getClass().getResource("/media/finca pics/bonusplate5.png");
			path_used = getClass().getResource("/media/finca pics/bonusplate5used.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    		image5 = tk.getImage(path_used).getScaledInstance(50, 50, Image.SCALE_SMOOTH);

	    		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			imageicon_used5 = new ImageIcon(image5);
			fincat5.setIcon(imageicon);
			this.add(fincat5);
			fincat5.setBounds(85,90,60,60);
			if(i != 0 ){
				fincat5.setVisible(true);
			}else{
				fincat5.setVisible(false);
			}
		}
		{
			int i = 1;
			path = getClass().getResource("/media/finca pics/bonusplate4.png");
			path_used = getClass().getResource("/media/finca pics/bonusplate4used.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    		image4 = tk.getImage(path_used).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	    		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			imageicon_used4 = new ImageIcon(image4);
			fincat4.setIcon(imageicon);
			this.add(fincat4);
			fincat4.setBounds(25,90,60,60);
			if(i != 0 ){
				fincat4.setVisible(true);
			}else{
				fincat4.setVisible(false);
			}
		}
		{
			int i = 1;
			path = getClass().getResource("/media/finca pics/fincahouse.png");
			tk = Toolkit.getDefaultToolkit();
	    	try{
	    		m = new MediaTracker(this);
	    		image = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	      		m.waitForAll();
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			imageicon = new ImageIcon(image);
			finca_house.setIcon(imageicon);
			finca_house.setText("x " + String.valueOf(fclient.getGameBoard().getNrOfFincas()));
			finca_house.setVerticalTextPosition(JLabel.CENTER);
			finca_house.setHorizontalTextPosition(JLabel.RIGHT);
			this.add(finca_house);
			finca_house.setBounds(290,90,90,60);
			if(i != 0 ){
				finca_house.setVisible(true);
			}else{
				finca_house.setVisible(false);
				
			}
		}
		
	}
	
}
