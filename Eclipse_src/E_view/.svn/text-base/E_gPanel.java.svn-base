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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

import java.net.URL;
import java.rmi.RemoteException;


import javax.swing.*;

import E_client.E_FincaClient;

import E_view.communityButtons.E_CommunityButton;



/**
 * This class is transparent and it contains different the 
 * community buttons with the fruit tiles, the bonus tile and 
 * the farmers whom you place on the windmill
 * 
 * @author thavo, mkuendig, michael_keller, malib, locwilder
 *
 */
public class E_gPanel extends JPanel {

	private JLabel wind_0;
	private JLabel wind_1;
	private JLabel wind_2;
	private JLabel wind_3;
	private JLabel wind_4;
	private JLabel wind_5;
	private JLabel wind_6;
	private JLabel wind_7;
	private JLabel wind_8;
	private JLabel wind_9;
	private JLabel wind_10;
	private JLabel wind_11;

	private JLabel[][] farmerSpots = new JLabel[12][];

	private boolean hasMovedYet;

	private E_CommunityButton alcudia;
	private E_CommunityButton andratix;
	private E_CommunityButton arta;
	private E_CommunityButton campos;
	private E_CommunityButton inca; 
	private E_CommunityButton llucmajor;
	private E_CommunityButton palma;
	private E_CommunityButton santanyi;
	private E_CommunityButton sonSevera;
	private E_CommunityButton villafranca;

	private JLabel alcuL;
	private JLabel andrL;
	private JLabel artaL;
	private JLabel campL;
	private JLabel incaL;
	private JLabel llucL;
	private JLabel palmL;
	private JLabel santL;
	private JLabel sonsL;
	private JLabel villL;
	private E_FincaClient fincaClient;
	private E_gMapImage mapImage;

	private Image alcuImage;
	private Image andrImage;
	private Image campImage;
	private Image incaImage;
	private Image llucImage;
	private Image palmImage;
	private Image santImage;
	private Image artaImage;
	private Image sonsImage;
	private Image villImage;	
	private Image fincahouseImage;
	protected Icon alcuIcon;
	protected Icon andrIcon;
	protected Icon campIcon;
	protected Icon incaIcon;
	protected Icon llucIcon;
	protected Icon palmIcon;
	protected Icon santIcon;
	protected Icon artaIcon;
	protected Icon sonsIcon;
	protected Icon villIcon;
	

	private Toolkit tk;
	private URL path;
	private MediaTracker m;
	Image image;
	Icon fincahouseIcon;


	public E_gPanel(E_gMapImage mapImage,E_FincaClient fc) throws RemoteException{
		super();
		hasMovedYet = false;
		fincaClient = fc;
		this.mapImage = mapImage;
		setPreferredSize(new java.awt.Dimension(800, 500));
		this.setLayout(null);
		path = getClass().getResource("/media/finca pics/fincahouse.png");
		tk = Toolkit.getDefaultToolkit();
		try{
			m = new MediaTracker(this);
			fincahouseImage = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			m.waitForAll();

		}catch(Exception e){
			e.printStackTrace();
		}
		fincahouseIcon = new ImageIcon(fincahouseImage);
		init();
		//set to transparency with to zero on the 4th row
		this.setBackground(new Color(0,0,0,0));
	}

	public void repaint() {
		if(mapImage != null){
			mapImage.repaint();
			super.repaint();
		}
	}

	/**
	 * called to update all spots on every windmill blade
	 * 
	 * @author Michael KŸndig
	 * @pre: JLabel[][] farmerSpots has to contain 12 JLabel arrays with 12 JLabels in each array
	 * @post: -
	 */

	public void updateAllFarmerSpots() throws RemoteException {
		for(int i = 0; i < 12; i++) {
			updateFarmerSpot(i);
		}
	}

	/**
	 * this method first sets all farmer spots on the windmill blade at the given position to invisible.
	 * the method has to check the number of players to determine how many spots a color has.
	 * --> with 2 players, every color has 6 spots in the array
	 * --> with 3 players, every color has 4 spots in the array
	 * --> with 4 players, every color has 3 spots in the array
	 * @author Michael KŸndig
	 * @pre: JLabel[][] farmerSpots has to contain 12 JLabel arrays with 12 JLabels in each array
	 * @post: visible farmerSpots have been updated
	 * @param: index of the windmill in the array that is updated
	 */

	public void updateFarmerSpot(int position) throws RemoteException{

		for(int i = 0; i < 12; i++) {
			farmerSpots[position][i].setVisible(false);
		}

		int numberOfPlayers = fincaClient.getServer().getNumberOfPlayers();		

		if (numberOfPlayers == 2) {
			int numberOfBlueFarmers = fincaClient.getGameBoard().getMap().get_windmill().get_blade_array()[position].num_of_farmers(0);
			int numberOfRedFarmers = fincaClient.getGameBoard().getMap().get_windmill().get_blade_array()[position].num_of_farmers(1);
			int counter = 0;

			while(numberOfBlueFarmers != 0) {
				farmerSpots[position][counter].setVisible(true);
				numberOfBlueFarmers -= 1;
				counter++;
			}

			counter = 6;

			while(numberOfRedFarmers != 0) {
				farmerSpots[position][counter].setVisible(true);
				numberOfRedFarmers -=1;
				counter++;
			}

		}

		if (numberOfPlayers == 3) {
			int numberOfBlueFarmers = fincaClient.getGameBoard().getMap().get_windmill().get_blade_array()[position].num_of_farmers(0);
			int numberOfRedFarmers = fincaClient.getGameBoard().getMap().get_windmill().get_blade_array()[position].num_of_farmers(1);
			int numberOfYellowFarmers = fincaClient.getGameBoard().getMap().get_windmill().get_blade_array()[position].num_of_farmers(2);
			int counter = 0;

			while(numberOfBlueFarmers != 0) {
				farmerSpots[position][counter].setVisible(true);
				numberOfBlueFarmers -= 1;
				counter++;
			}

			counter = 4;

			while(numberOfRedFarmers != 0) {
				farmerSpots[position][counter].setVisible(true);
				numberOfRedFarmers -=1;
				counter++;
			}

			counter = 8;

			while(numberOfYellowFarmers != 0) {
				farmerSpots[position][counter].setVisible(true);
				numberOfYellowFarmers -=1;
				counter++;
			}

		}

		if (numberOfPlayers == 4) {
			int numberOfBlueFarmers = fincaClient.getGameBoard().getMap().get_windmill().get_blade_array()[position].num_of_farmers(0);
			int numberOfRedFarmers = fincaClient.getGameBoard().getMap().get_windmill().get_blade_array()[position].num_of_farmers(1);
			int numberOfYellowFarmers = fincaClient.getGameBoard().getMap().get_windmill().get_blade_array()[position].num_of_farmers(2);
			int numberOfGreenFarmers = fincaClient.getGameBoard().getMap().get_windmill().get_blade_array()[position].num_of_farmers(3);

			int counter = 0;

			while(numberOfBlueFarmers != 0) {
				farmerSpots[position][counter].setVisible(true);
				numberOfBlueFarmers -= 1;
				counter++;
			}

			counter = 3;

			while(numberOfRedFarmers != 0) {
				farmerSpots[position][counter].setVisible(true);
				numberOfRedFarmers -=1;
				counter++;
			}

			counter = 6;

			while(numberOfYellowFarmers != 0) {
				farmerSpots[position][counter].setVisible(true);
				numberOfYellowFarmers -=1;
				counter++;
			}

			counter = 9;

			while(numberOfGreenFarmers != 0) {
				farmerSpots[position][counter].setVisible(true);
				numberOfGreenFarmers -=1;
				counter++;
			}

		}
	}

	public void refresh_community(String community_name)
	{
		if (community_name=="alcudia"){
			if(fincaClient.getGameBoard().getMap().get_communities().get(0).get_number_of_fruittiles()==0){
				alcuL.setIcon(fincahouseIcon);
				alcudia.refresh();
			}else{
				alcudia.refresh();
				alcuL.setIcon(alcuIcon);
			}
		}
		else if (community_name=="andratix"){
			if(fincaClient.getGameBoard().getMap().get_communities().get(5).get_number_of_fruittiles()==0){
				andrL.setIcon(fincahouseIcon);
				andratix.refresh();
			}else{
				andratix.refresh();
				andrL.setIcon(andrIcon);
			}
		}
		else if (community_name=="arta"){
			if(fincaClient.getGameBoard().getMap().get_communities().get(1).get_number_of_fruittiles()==0){
				artaL.setIcon(fincahouseIcon);
				arta.refresh();
			}else{
				arta.refresh();
				artaL.setIcon(artaIcon);
			}
		}
		else if (community_name=="campos"){
			if(fincaClient.getGameBoard().getMap().get_communities().get(8).get_number_of_fruittiles()==0){
				campL.setIcon(fincahouseIcon);
				campos.refresh();
			}else{
				campos.refresh();
				campL.setIcon(campIcon);
			}
		}
		else if (community_name=="inca"){
			if(fincaClient.getGameBoard().getMap().get_communities().get(2).get_number_of_fruittiles()==0){
				incaL.setIcon(fincahouseIcon);
				inca.refresh();
			}else{
				inca.refresh();
				incaL.setIcon(incaIcon);
			}
		}
		else if (community_name=="llucmajor"){
			if(fincaClient.getGameBoard().getMap().get_communities().get(7).get_number_of_fruittiles()==0){
				llucL.setIcon(fincahouseIcon);
				llucmajor.refresh();
			}else{
				llucmajor.refresh();
				llucL.setIcon(llucIcon);
			}
		}
		else if (community_name=="palma"){
			if(fincaClient.getGameBoard().getMap().get_communities().get(6).get_number_of_fruittiles()==0){
				palmL.setIcon(fincahouseIcon);
				palma.refresh();
			}else{
				palma.refresh();
				palmL.setIcon(palmIcon);
			}
		}
		else if (community_name=="santanyi"){
			if(fincaClient.getGameBoard().getMap().get_communities().get(9).get_number_of_fruittiles()==0){
				santL.setIcon(fincahouseIcon);
				santanyi.refresh();
			}else{
				santanyi.refresh();
				santL.setIcon(santIcon);
			}
		}
		else if (community_name=="sonsevera"){
			if(fincaClient.getGameBoard().getMap().get_communities().get(4).get_number_of_fruittiles()==0){
				sonsL.setIcon(fincahouseIcon);
				sonSevera.refresh();
			}else{
				sonSevera.refresh();
				sonsL.setIcon(sonsIcon);
			}
		}
		else if (community_name=="villafranca"){
			if(fincaClient.getGameBoard().getMap().get_communities().get(3).get_number_of_fruittiles()==0){
				villL.setIcon(fincahouseIcon);
				villafranca.refresh();
			}else{
				villafranca.refresh();
				villL.setIcon(villIcon);
			}
		}
	}

	public void useWindmill(int bladeNr){
		try {	
			if(fincaClient.isMyTurn() && !hasMovedYet){
				if (fincaClient.getTurn().get_setupCounter()>0){
					fincaClient.getTurn().useWindmillBlade(bladeNr, fincaClient.getGameBoard());
					fincaClient.getTurn().endTurn();
					fincaClient.sendGameBoard();	
					this.updateAllFarmerSpots();
					fincaClient.getgFrame().refreshAll();
				}else{
					if(fincaClient.getTurn().useWindmillBlade(bladeNr, fincaClient.getGameBoard())){
						this.updateAllFarmerSpots();
						fincaClient.getgFrame().refreshAll();
						hasMovedYet = true;
						}else{
							this.updateAllFarmerSpots();
							fincaClient.getgFrame().refreshAll();
							
						}		
				}

			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * this method adds JLabels for farmers in an array and returns it. depending on the number of players, the first indexes of
	 * the array are reserved for the red farmers, the later indexes for the blue farmers and so on...
	 * @author:	Michael KŸndig
	 * @pre:	JLabel[][] farmerSpots has to contain 12 JLabel arrays with 12 JLabels in each array
	 * @post:	the returning JLabel array contains 12 JLabes which are positioned on a windmill blade
	 * 			and the correct colors of the farmers.
	 * @param:	int array 24 integers. integers on a even index are x-coordinates, integers on a odd index are y-coordinates.
	 * @return:	JLabel array with 12 JLabels containing 12 farmers with the right color depending on the number of players.
	 */

	private JLabel[] addSpots(int[] coordinates) throws RemoteException {
		int numberOfPlayers = fincaClient.getServer().getNumberOfPlayers();
		JLabel[] spots = new JLabel[12];

		try {
				tk = Toolkit.getDefaultToolkit();
				m = new MediaTracker(this);

			if (numberOfPlayers == 2) {
				for (int i = 0; i < 6; i++) {
					path = getClass().getResource("/media/finca pics/figure-blue.png");
					try{
						image = tk.getImage(path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
						m.waitForAll();
					}catch(Exception e){
						e.printStackTrace();
					}
					spots[i] = new JLabel(new ImageIcon(image));
					spots[i].setBackground(new Color(0,0,0));
					spots[i].setOpaque(false);
					spots[i].setVisible(false);
					this.add(spots[i]);
				}


				for (int i = 6; i < 12; i++) {
					path = getClass().getResource("/media/finca pics/figure-red.png");
					try{
						image = tk.getImage(path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
						m.waitForAll();
					}catch(Exception e){
						e.printStackTrace();
					}
					spots[i] = new JLabel(new ImageIcon(image));
					spots[i].setBackground(new Color(0,0,0));
					spots[i].setOpaque(false);
					spots[i].setVisible(false);
					this.add(spots[i]);
				}

			}


			if (numberOfPlayers == 3) {
				for (int i = 0; i < 4; i++) {
					path = getClass().getResource("/media/finca pics/figure-blue.png");
					try{
						image = tk.getImage(path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
						m.waitForAll();
					}catch(Exception e){
						e.printStackTrace();
					}
					spots[i] = new JLabel(new ImageIcon(image));
					spots[i].setBackground(new Color(0,0,0));
					spots[i].setOpaque(false);
					spots[i].setVisible(false);
					this.add(spots[i]);
				}


				for (int i = 4; i < 8; i++) {
					path = getClass().getResource("/media/finca pics/figure-red.png");
					try{
						image = tk.getImage(path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
						m.waitForAll();
					}catch(Exception e){
						e.printStackTrace();
					}
					spots[i] = new JLabel(new ImageIcon(image));
					spots[i].setBackground(new Color(0,0,0));
					spots[i].setOpaque(false);
					spots[i].setVisible(false);
					this.add(spots[i]);
				}


				for (int i = 8; i < 12; i++) {
					path = getClass().getResource("/media/finca pics/figure-yellow.png");
					try{
						image = tk.getImage(path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
						m.waitForAll();
					}catch(Exception e){
						e.printStackTrace();
					}
					spots[i] = new JLabel(new ImageIcon(image));
					spots[i].setBackground(new Color(0,0,0));
					spots[i].setOpaque(false);
					spots[i].setVisible(false);
					this.add(spots[i]);
				}

			}


			if (numberOfPlayers == 4) {
				for (int i = 0; i < 3; i++) {
					path = getClass().getResource("/media/finca pics/figure-blue.png");
					try{
						image = tk.getImage(path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
						m.waitForAll();
					}catch(Exception e){
						e.printStackTrace();
					}
					spots[i] = new JLabel(new ImageIcon(image));
					spots[i].setBackground(new Color(0,0,0));
					spots[i].setOpaque(false);
					spots[i].setVisible(false);
					this.add(spots[i]);
				}


				for (int i = 3; i < 6; i++) {
					path = getClass().getResource("/media/finca pics/figure-red.png");
					try{
						image = tk.getImage(path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
						m.waitForAll();
					}catch(Exception e){
						e.printStackTrace();
					}
					spots[i] = new JLabel(new ImageIcon(image));
					spots[i].setBackground(new Color(0,0,0));
					spots[i].setOpaque(false);
					spots[i].setVisible(false);
					this.add(spots[i]);
				}
				for (int i = 6; i < 9; i++) {
					path = getClass().getResource("/media/finca pics/figure-yellow.png");
					try{
						image = tk.getImage(path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
						m.waitForAll();
					}catch(Exception e){
						e.printStackTrace();
					}
					spots[i] = new JLabel(new ImageIcon(image));
					spots[i].setBackground(new Color(0,0,0));
					spots[i].setOpaque(false);
					spots[i].setVisible(false);
					this.add(spots[i]);
				}


				for (int i = 9; i < 12; i++) {
					path = getClass().getResource("/media/finca pics/figure-green.png");
					try{
						image = tk.getImage(path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
						m.waitForAll();
					}catch(Exception e){
						e.printStackTrace();
					}
					spots[i] = new JLabel(new ImageIcon(image));
					spots[i].setBackground(new Color(0,0,0));
					spots[i].setOpaque(false);
					spots[i].setVisible(false);
					this.add(spots[i]);
				}
			}


			int index1 = 0;
			int index2 = 1;

			for (int index0 = 0; index0 < spots.length; index0 ++) {
				spots[index0].setBounds(coordinates[index1], coordinates[index2], 20, 20);
				index1 += 2;
				index2 += 2;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return spots;
	}
	
	

	private void init() throws RemoteException {

		
		 // This are the coordinates for each spots where 
		 //you place a farmer
		 
		int[] spots0 = {
				17, 98, 43, 103,
				17, 118, 35, 120, 55, 114, 75, 112, 95, 110,
				15, 138, 35, 136, 55, 134, 75, 132, 95, 130};

		int[] spots1 = {
				65, 40, 85, 40,
				45, 60, 65, 60, 85, 60, 105, 60,
				60, 80, 80, 80, 100, 80, 120, 80,
				110, 100, 130, 100};

		int[] spots2 = {
				120, 20, 140, 20, 160, 20,
				115, 40, 132, 40, 149, 40, 166, 40,
				130, 60, 150, 60, 170, 60,
				140, 80, 160, 80};

		int [] spots3 = {
				185, 20, 210, 20, 230, 20, 250, 20,
				190, 40, 207, 40, 224, 40, 241, 40,
				190, 60, 210, 60,
				190, 80, 210, 80};

		int [] spots4 = {
				275, 40,
				255, 57, 275, 57, 295, 57, 315, 64,
				242, 74, 258, 74, 275, 74, 295, 74,
				235, 94, 255, 94, 275, 94};

		int[] spots5 = {
				325, 100,
				273, 120, 290, 122, 310, 122, 330, 122, 350, 122,
				250, 140, 270, 140, 290, 142, 310, 142, 330, 142, 350, 142};


		int[] spots6 = {
				245, 163, 260, 167, 280, 167, 300, 167, 320, 167, 340, 167,
				280, 185, 300, 185, 320, 185, 340, 185,
				310, 205, 330, 205};


		int[] spots7 = {
				230, 205, 250, 205,
				240, 225, 260, 225, 280, 225, 300, 225,
				250, 245, 267, 245, 284, 245, 301, 245,
				260, 265, 280, 265};

		int[] spots8 = {
				190, 225, 210, 225,
				190, 245, 210, 245,
				190, 265, 210, 265, 230, 265,
				190, 285, 210, 285, 230, 285,
				190, 305, 210, 305};

		int[] spots9 = {
				150, 225, 170, 225,
				140, 245, 160, 245,
				125, 265, 145, 265, 165, 265,
				140, 280, 160, 280,
				120, 280, 140, 295, 160, 295};

		int[] spots10 = {
				110, 205, 130, 205,
				60, 225, 80, 225, 100, 225, 120, 225,
				50, 245, 70, 245, 90, 245, 110, 245,
				60, 265, 80, 265};

		int[] spots11 = {
				20, 165, 40, 165, 60, 165, 80, 165, 100, 165,
				20, 185, 40, 185, 60, 185, 80, 185, 100, 185,
				30, 205, 50, 200};

		farmerSpots[0] = addSpots(spots0);
		farmerSpots[1] = addSpots(spots1);
		farmerSpots[2] = addSpots(spots2);
		farmerSpots[3] = addSpots(spots3);
		farmerSpots[4] = addSpots(spots4);
		farmerSpots[5] = addSpots(spots5);
		farmerSpots[6] = addSpots(spots6);
		farmerSpots[7] = addSpots(spots7);
		farmerSpots[8] = addSpots(spots8);
		farmerSpots[9] = addSpots(spots9);
		farmerSpots[10] = addSpots(spots10);
		farmerSpots[11] = addSpots(spots11);

		wind_0 = new JLabel();
		wind_0.setBounds(45, 110, 45, 45);
		wind_0.setBackground(new Color(0,0,0));
		this.add(wind_0);
		wind_0.setOpaque(false);
		wind_0.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				useWindmill(0);
			}

		});

		wind_1 = new JLabel();
		wind_1.setBounds(75, 60, 44, 42);
		wind_1.setBackground(new Color(0,0,0));
		this.add(wind_1);
		wind_1.setOpaque(false);
		wind_1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				useWindmill(1);
			}
		});

		wind_2 = new JLabel();
		wind_2.setBounds(131, 30, 43, 45);
		wind_2.setBackground(new Color(0,0,0));
		this.add(wind_2);
		wind_2.setOpaque(false);
		wind_2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				useWindmill(2);
			}
		});

		wind_3 = new JLabel();
		wind_3.setBounds(193, 27, 45, 48);
		wind_3.setBackground(new Color(0,0,0));
		this.add(wind_3);
		wind_3.setOpaque(false);
		wind_3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				useWindmill(3);
			}
		});


		wind_4 = new JLabel();
		wind_4.setBounds(250, 60, 45, 45);
		wind_4.setBackground(new Color(0,0,0));
		this.add(wind_4);
		wind_4.setOpaque(false);
		wind_4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				useWindmill(4);
			}
		});

		wind_5 = new JLabel();
		wind_5.setBounds(290, 113, 45, 43);
		wind_5.setBackground(new Color(0,0,0));
		this.add(wind_5);
		wind_5.setOpaque(false);
		wind_5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				useWindmill(5);
			}
		});

		wind_6 = new JLabel();
		wind_6.setBounds(285, 165, 45, 45);
		wind_6.setBackground(new Color(0,0,0));
		this.add(wind_6);
		wind_6.setOpaque(false);
		wind_6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				useWindmill(6);
			}
		});

		wind_7 = new JLabel();
		wind_7.setBounds(250, 213, 45, 45);
		wind_7.setBackground(new Color(0,0,0));
		this.add(wind_7);
		wind_7.setOpaque(false);
		wind_7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				useWindmill(7);
			}
		});

		wind_8 = new JLabel();
		wind_8.setBounds(187, 250, 49, 45);
		wind_8.setBackground(new Color(0,0,0));
		this.add(wind_8);
		wind_8.setOpaque(false);
		wind_8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				useWindmill(8);
			}
		});

		wind_9 = new JLabel();
		wind_9.setBounds(128, 247, 45, 45);
		wind_9.setBackground(new Color(0,0,0));
		this.add(wind_9);
		wind_9.setOpaque(false);
		wind_9.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				useWindmill(9);
			}
		});

		wind_10 = new JLabel();
		wind_10.setBounds(75, 220, 45, 45);
		wind_10.setBackground(new Color(0,0,0));
		this.add(wind_10);
		wind_10.setOpaque(false);
		wind_10.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				useWindmill(10);
			}
		});

		wind_11 = new JLabel();
		wind_11.setBounds(45, 165, 45, 45);
		wind_11.setBackground(new Color(0,0,0));
		this.add(wind_11);
		wind_11.setOpaque(false);
		wind_11.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {

				useWindmill(11);
			}
		});

		{	
			// creates a new CommunityButton and sets it positions
			// alcudia has communnityNumber = 0
			alcudia = new E_CommunityButton(fincaClient, this, 0);
			this.add(alcudia);
			alcudia.setBounds(427, 113, 59, 59);

			/*loads a finca tile for a certain community.
			 * it checks if the community has fruit tiles 
			 */
			
			if(alcudia.getCtr() == 0){
				alcuIcon = new ImageIcon();
				alcuL = new JLabel(alcuIcon);
			}else{
				String picname = fincaClient.getGameBoard().getMap().get_communities().get(0).get_fincatile().get_name();
				String sourcename = "/media/finca pics/"+picname;
				path = getClass().getResource(sourcename);
				tk = Toolkit.getDefaultToolkit();
				try{
					m = new MediaTracker(this);
					alcuImage = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					m.waitForAll();

				}catch(Exception e){
					e.printStackTrace();
				}
				alcuIcon = new ImageIcon(alcuImage);
				alcuL = new JLabel(alcuIcon);
			}

			alcuL.setBackground(new Color(0,0,0,0));
			this.add(alcuL);
			alcuL.setBounds(412, 61, 50, 50);

		}


		{
			// arta has communityNr = 1		
			arta = new E_CommunityButton(fincaClient, this, 1);
			this.add(arta);
			arta.setBounds(695, 94, 59, 59);

			//Image artaImage;
			if(arta.getCtr() == 0){
				artaIcon = new ImageIcon();
				artaL = new JLabel(artaIcon);
			}else{
				String picname = fincaClient.getGameBoard().getMap().get_communities().get(1).get_fincatile().get_name();
				String sourcename = "/media/finca pics/"+picname;
				path = getClass().getResource(sourcename);				
				tk = Toolkit.getDefaultToolkit();
				try{
					m = new MediaTracker(this);
					artaImage = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					m.waitForAll();

				} catch(Exception e){
					e.printStackTrace();
				}
				artaIcon = new ImageIcon(artaImage);
				artaL = new JLabel(artaIcon);
			}
			artaL.setBackground(new Color(0,0,0,0));
			this.add(artaL);
			artaL.setBounds(600, 135, 50, 50);
		}

		{
			// andratix has communityNr = 5
			andratix = new E_CommunityButton(fincaClient, this, 5);
			this.add(andratix);
			andratix.setBounds(105, 397, 59, 59);

			String picname = fincaClient.getGameBoard().getMap().get_communities().get(5).get_fincatile().get_name();
			String sourcename = "/media/finca pics/"+picname;
			path = getClass().getResource(sourcename);
			tk = Toolkit.getDefaultToolkit();
			try{
				m = new MediaTracker(this);
				andrImage = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
				m.waitForAll();

			}catch(Exception e){
				e.printStackTrace();
			}	
			andrIcon = new ImageIcon(andrImage);
			andrL = new JLabel(andrIcon);

			if(andratix.getCtr() == 0){
				andrL.setOpaque(false);
				andrL.setVisible(false);

			}else{
				andrL.setOpaque(true);
				andrL.setVisible(true);
			}

			andrL.setBackground(new Color(0,0,0,0));
			this.add(andrL);
			andrL.setBounds(112, 331, 50, 50);
		}

		{
			// campos has communityNr = 8
			campos = new E_CommunityButton(fincaClient, this, 8);
			this.add(campos);
			campos.setBounds(450, 342, 59, 59);

			if(campos.getCtr() == 0){
				campIcon = new ImageIcon();
				campL = new JLabel(campIcon);
			}else{
				String picname = fincaClient.getGameBoard().getMap().get_communities().get(8).get_fincatile().get_name();
				String sourcename = "/media/finca pics/"+picname;
				path = getClass().getResource(sourcename);
				tk = Toolkit.getDefaultToolkit();
				try{
					m = new MediaTracker(this);
					campImage = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					m.waitForAll();

				}catch(Exception e){
					e.printStackTrace();
				}
				campIcon = new ImageIcon(campImage);
				campL = new JLabel(campIcon);
			}
			campL.setBackground(new Color(0,0,0,0));
			this.add(campL);
			campL.setBounds(517, 350, 50, 50);
		}

		{
			// inca has communityNr = 2
			inca = new E_CommunityButton(fincaClient, this, 2);
			this.add(inca);
			inca.setBounds(409, 268, 59, 59);

			if(inca.getCtr() == 0){
				incaIcon = new ImageIcon();
				incaL = new JLabel(incaIcon);
			}else{
				String picname = fincaClient.getGameBoard().getMap().get_communities().get(2).get_fincatile().get_name();
				String sourcename = "/media/finca pics/"+picname;
				path = getClass().getResource(sourcename);
				tk = Toolkit.getDefaultToolkit();
				try{
					m = new MediaTracker(this);
					incaImage = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					m.waitForAll();

				}catch(Exception e){
					e.printStackTrace();
				}
				incaIcon = new ImageIcon(incaImage);
				incaL = new JLabel(incaIcon);
			}
			incaL.setBackground(new Color(0,0,0,0));
			this.add(incaL);
			incaL.setBounds(356, 230, 50, 50);
		}

		{
			// llucmajor has communityNr = 7
			llucmajor = new E_CommunityButton(fincaClient, this, 7);
			this.add(llucmajor);
			llucmajor.setBounds(386, 400, 59, 59);

			if(llucmajor.getCtr() == 0){
				llucIcon = new ImageIcon();
				llucL = new JLabel(llucIcon);
			}else{
				String picname = fincaClient.getGameBoard().getMap().get_communities().get(7).get_fincatile().get_name();
				String sourcename = "/media/finca pics/"+picname;
				path = getClass().getResource(sourcename);
				tk = Toolkit.getDefaultToolkit();
				try{
					m = new MediaTracker(this);
					llucImage = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					m.waitForAll();

				}catch(Exception e){
					e.printStackTrace();
				}
				llucIcon = new ImageIcon(llucImage);
				llucL = new JLabel(llucIcon);
			}
			llucL.setBackground(new Color(0,0,0,0));
			this.add(llucL);
			llucL.setBounds(330, 389, 50, 50);
		}

		{
			// palma has communityNr = 6
			palma = new E_CommunityButton(fincaClient, this, 6);
			this.add(palma);
			palma.setBounds(180, 330, 59, 59);

			if(palma.getCtr() == 0){
				palmIcon = new ImageIcon();
				palmL = new JLabel(palmIcon);
			}else{
				String picname = fincaClient.getGameBoard().getMap().get_communities().get(6).get_fincatile().get_name();
				String sourcename = "/media/finca pics/"+picname;
				path = getClass().getResource(sourcename);
				tk = Toolkit.getDefaultToolkit();
				try{
					m = new MediaTracker(this);
					palmImage = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					m.waitForAll();

				}catch(Exception e){
					e.printStackTrace();
				}
				palmIcon = new ImageIcon(palmImage);
				palmL = new JLabel(palmIcon);
			}
			palmL.setBackground(new Color(0,0,0,0));
			this.add(palmL);
			palmL.setBounds(270, 300, 50, 50);
		}

		{
			// santanyi has communityNr = 9
			santanyi = new E_CommunityButton(fincaClient, this, 9);
			this.add(santanyi);
			santanyi.setBounds(643, 340, 59, 59);

			if(santanyi.getCtr() == 0){
				santIcon = new ImageIcon();
				santL = new JLabel(santIcon);
			}else{
				String picname = fincaClient.getGameBoard().getMap().get_communities().get(9).get_fincatile().get_name();
				String sourcename = "/media/finca pics/"+picname;
				path = getClass().getResource(sourcename);
				tk = Toolkit.getDefaultToolkit();
				try{
					m = new MediaTracker(this);
					santImage = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					m.waitForAll();

				}catch(Exception e){
					e.printStackTrace();
				}
				santIcon = new ImageIcon(santImage);
				santL = new JLabel(santIcon);
			}
			santL.setBackground(new Color(0,0,0,0));
			this.add(santL);
			santL.setBounds(585, 350, 50, 50);
		}

		{
			// son severa has communityNr = 4
			sonSevera = new E_CommunityButton(fincaClient, this, 4);
			this.add(sonSevera);
			sonSevera.setBounds(669, 267, 59, 59);

			if(sonSevera.getCtr() == 0){
				sonsIcon = new ImageIcon();
				sonsL = new JLabel(sonsIcon);
			}else{
				String picname = fincaClient.getGameBoard().getMap().get_communities().get(4).get_fincatile().get_name();
				String sourcename = "/media/finca pics/"+picname;
				path = getClass().getResource(sourcename);
				tk = Toolkit.getDefaultToolkit();
				try{
					m = new MediaTracker(this);
					sonsImage = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					m.waitForAll();

				}catch(Exception e){
					e.printStackTrace();
				}
				sonsIcon = new ImageIcon(sonsImage);
				sonsL = new JLabel(sonsIcon);
			}
			sonsL.setBackground(new Color(0,0,0,0));
			this.add(sonsL);
			sonsL.setBounds(617, 238, 50, 50);
		}

		{
			// villafranca has communityNr = 3
			villafranca = new E_CommunityButton(fincaClient, this, 3);
			this.add(villafranca);
			villafranca.setBounds(522, 193, 59, 59);

			if(villafranca.getCtr() == 0){
				villIcon = new ImageIcon();
				villL = new JLabel(villIcon);
			}else{
				String picname = fincaClient.getGameBoard().getMap().get_communities().get(3).get_fincatile().get_name();
				String sourcename = "/media/finca pics/"+picname;
				path = getClass().getResource(sourcename);
				tk = Toolkit.getDefaultToolkit();
				try{
					m = new MediaTracker(this);
					villImage = tk.getImage(path).getScaledInstance(50, 50, Image.SCALE_SMOOTH);
					m.waitForAll();

				}catch(Exception e){
					e.printStackTrace();
				}
				villIcon = new ImageIcon(villImage);
				villL = new JLabel(villIcon);
			}
			villL.setBackground(new Color(0,0,0,0));
			this.add(villL);
			villL.setBounds(487, 260, 50, 50);
		}
	}

	public void setHasMovedYet(boolean hasMoved) {
		this.hasMovedYet = hasMoved;
	}
}