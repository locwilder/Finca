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


package E_view.player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import E_client.E_FincaClient;

public abstract class E_PlayerInfos extends JPanel {

	protected E_FincaClient fincaClient;
	protected int playerNumber;
	protected Color defaultBackgroundColor;
	protected Color activeBackgroundColor;

	protected MediaTracker mediaTracker;
	protected Toolkit toolkit;
	protected Image tempImage;

	protected URL fruitpoolPath;
	protected JLabel fruitpoolLabel;

	protected JLabel almondAmount;
	protected JLabel grapesAmount;
	protected JLabel lemonAmount;
	protected JLabel olivesAmount;
	protected JLabel orangeAmount;
	protected JLabel pointsAmount;
	protected JLabel figAmount;
	protected JLabel almondAmountbought;
	protected JLabel grapesAmountbought;
	protected JLabel lemonAmountbought;
	protected JLabel olivesAmountbought;
	protected JLabel orangeAmountbought;
	protected JLabel riddleAmountbought;
	protected JLabel figAmountbought;

	protected JLabel donkeyCart;
	protected JLabel donkeyCartAmount;

	protected JLabel max10JokerLabel;
	protected JLabel moveTwiceJokerLabel;
	protected JLabel gustOfWindJokerLabel;
	protected JLabel oneFruitLessJokerLabel;

	protected JLabel playerAvatarLabel;
	protected JLabel playerNameLabel;

	protected JLabel pointsLabel;

	protected JLabel straight1JLabel;
	protected JLabel straight2JLabel;
	protected JLabel straight3JLabel;
	protected JLabel straight4JLabel;
	protected JLabel straight5JLabel;
	protected JLabel straight6JLabel;

	
	
	protected JLabel straight1OnJLabel;
	protected JLabel straight2OnJLabel;
	protected JLabel straight3OnJLabel;
	protected JLabel straight4OnJLabel;
	protected JLabel straight5OnJLabel;
	protected JLabel straight6OnJLabel;
	protected JLabel[] straightLabels;
		
	protected URL donkeyPath;
	protected URL joker1Path;
	protected URL joker2Path;
	protected URL joker3Path;
	protected URL joker4Path;
	protected URL figurePath;
	protected URL straight1Path;
	protected URL straight1PathOn;
	protected URL straight2Path;
	protected URL straight2PathOn;
	protected URL straight3Path;
	protected URL straight3PathOn;
	protected URL straight4Path;
	protected URL straight4PathOn;
	protected URL straight5Path;
	protected URL straight5PathOn;
	protected URL straight6Path;
	protected URL straight6PathOn;


	public E_PlayerInfos(E_FincaClient fincaClient) {
		this.fincaClient = fincaClient;
		activeBackgroundColor = new Color(200, 200, 200, 100);
		toolkit = Toolkit.getDefaultToolkit();
		mediaTracker = new MediaTracker(this);
		this.setSize(new Dimension(270,160));

		donkeyPath = getClass().getResource("/media/finca pics/donkey.png");
		fruitpoolPath = getClass().getResource("/media/finca pics/fruitpool.png");
		straight1Path = getClass().getResource("/media/finca pics/straight1.png");
		straight1PathOn = getClass().getResource("/media/finca pics/straight1on.png");
		straight2Path = getClass().getResource("/media/finca pics/straight2.png");
		straight2PathOn = getClass().getResource("/media/finca pics/straight2on.png");
		straight3Path = getClass().getResource("/media/finca pics/straight3.png");
		straight3PathOn = getClass().getResource("/media/finca pics/straight3on.png");
		straight4Path = getClass().getResource("/media/finca pics/straight4.png");
		straight4PathOn = getClass().getResource("/media/finca pics/straight4on.png");
		straight5Path = getClass().getResource("/media/finca pics/straight5.png");
		straight5PathOn = getClass().getResource("/media/finca pics/straight5on.png");
		straight6Path = getClass().getResource("/media/finca pics/straight6.png");
		straight6PathOn = getClass().getResource("/media/finca pics/straight6on.png");
	}

	protected void init() {
		try {
			this.setLayout(null);
			this.setBackground(defaultBackgroundColor);

			tempImage = toolkit.getImage(figurePath).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
			mediaTracker.waitForAll();
			ImageIcon avatarImageIcon = new ImageIcon(tempImage);
			playerAvatarLabel = new JLabel(avatarImageIcon);
			playerAvatarLabel.setBounds(5, 0, 45, 45);
			this.add(playerAvatarLabel);

			playerNameLabel = new JLabel();
			playerNameLabel.setBounds(55, 5, 130, 35);
			playerNameLabel.setFont(new Font("Tahoma", 0, 20));
			playerNameLabel.setText(fincaClient.getGameBoard().getPlayer(playerNumber).get_username());
			this.add(playerNameLabel);

			pointsLabel = new JLabel();
			pointsLabel.setBounds(185, 10, 55, 25);
			pointsLabel.setFont(new Font("Tahoma", 0, 14));
			pointsLabel.setText("Points: ");
			this.add(pointsLabel);

			pointsAmount = new JLabel();
			pointsAmount.setBounds(240, 10, 25, 25);
			pointsAmount.setFont(new Font("Tahoma", 0, 14));
			pointsAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_points()));
			this.add(pointsAmount);

			donkeyCartAmount = new JLabel();
			donkeyCartAmount.setBounds(10, 50, 35, 20);
			donkeyCartAmount.setFont(new Font("Tahoma", 0, 14));
			donkeyCartAmount.setText(fincaClient.getGameBoard().getPlayer(playerNumber).get_donkeys() + " x");
			this.add(donkeyCartAmount);

			tempImage = toolkit.getImage(donkeyPath).getScaledInstance(35, 35, Image.SCALE_SMOOTH);
			mediaTracker.waitForAll();
			ImageIcon donkeyImageIcon = new ImageIcon(tempImage);
			donkeyCart = new JLabel(donkeyImageIcon);
			donkeyCart.setBounds(35, 40, 40, 40);
			donkeyCart.setOpaque(false);
			this.add(donkeyCart);

			{

				tempImage = toolkit.getImage(joker1Path).getScaledInstance(35, 35, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon joker1ImageIcon = new ImageIcon(tempImage);
				oneFruitLessJokerLabel = new JLabel(joker1ImageIcon);
				oneFruitLessJokerLabel.setBounds(80, 40, 40, 40);
				oneFruitLessJokerLabel.setOpaque(false);
				this.add(oneFruitLessJokerLabel);

				tempImage = toolkit.getImage(joker2Path).getScaledInstance(35, 35, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon joker2ImageIcon = new ImageIcon(tempImage);
				moveTwiceJokerLabel = new JLabel(joker2ImageIcon);
				moveTwiceJokerLabel.setBounds(125, 40, 40, 40);
				moveTwiceJokerLabel.setOpaque(false);
				this.add(moveTwiceJokerLabel);

				tempImage = toolkit.getImage(joker3Path).getScaledInstance(35, 35, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon joker3ImageIcon = new ImageIcon(tempImage);
				max10JokerLabel = new JLabel(joker3ImageIcon);
				max10JokerLabel.setBounds(170, 40, 40, 40);
				max10JokerLabel.setOpaque(false);
				this.add(max10JokerLabel);

				tempImage = toolkit.getImage(joker4Path).getScaledInstance(35, 35, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon joker4ImageIcon = new ImageIcon(tempImage);
				gustOfWindJokerLabel = new JLabel(joker4ImageIcon);
				gustOfWindJokerLabel.setBounds(215, 40, 40, 40);
				gustOfWindJokerLabel.setOpaque(false);
				this.add(gustOfWindJokerLabel);
			}

			{

				tempImage = toolkit.getImage(straight1Path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight1ImageIcon = new ImageIcon(tempImage);
				straight1JLabel = new JLabel(straight1ImageIcon);
				straight1JLabel.setBounds(205, 90, 25, 25);
				straight1JLabel.setVisible(true);
				this.add(straight1JLabel);

				tempImage = toolkit.getImage(straight1PathOn).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight1OnImageIcon = new ImageIcon(tempImage);
				straight1OnJLabel = new JLabel(straight1OnImageIcon);
				straight1OnJLabel.setBounds(205, 90, 25, 25);
				straight1OnJLabel.setVisible(false);
				this.add(straight1OnJLabel);

				tempImage = toolkit.getImage(straight2Path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight2ImageIcon = new ImageIcon(tempImage);
				straight2JLabel = new JLabel(straight2ImageIcon);
				straight2JLabel.setBounds(230, 90, 25, 25);
				straight2JLabel.setVisible(true);
				this.add(straight2JLabel);

				tempImage = toolkit.getImage(straight2PathOn).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight2OnImageIcon = new ImageIcon(tempImage);
				straight2OnJLabel = new JLabel(straight2OnImageIcon);
				straight2OnJLabel.setBounds(230, 90, 25, 25);
				straight2OnJLabel.setVisible(false);
				this.add(straight2OnJLabel);

				tempImage = toolkit.getImage(straight3Path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight3ImageIcon = new ImageIcon(tempImage);
				straight3JLabel = new JLabel(straight3ImageIcon);
				straight3JLabel.setBounds(205, 110, 25, 25);
				straight3JLabel.setVisible(true);
				this.add(straight3JLabel);

				tempImage = toolkit.getImage(straight3PathOn).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight3OnImageIcon = new ImageIcon(tempImage);
				straight3OnJLabel = new JLabel(straight3OnImageIcon);
				straight3OnJLabel.setBounds(205, 110, 25, 25);
				straight3OnJLabel.setVisible(false);
				this.add(straight3OnJLabel);

				tempImage = toolkit.getImage(straight4Path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight4ImageIcon = new ImageIcon(tempImage);
				straight4JLabel = new JLabel(straight4ImageIcon);
				straight4JLabel.setBounds(230, 110, 25, 25);
				straight4JLabel.setVisible(true);
				this.add(straight4JLabel);

				tempImage = toolkit.getImage(straight4PathOn).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight4OnImageIcon = new ImageIcon(tempImage);
				straight4OnJLabel = new JLabel(straight4OnImageIcon);
				straight4OnJLabel.setBounds(230, 110, 25, 25);
				straight4OnJLabel.setVisible(false);
				this.add(straight4OnJLabel);

				tempImage = toolkit.getImage(straight5Path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight5ImageIcon = new ImageIcon(tempImage);
				straight5JLabel = new JLabel(straight5ImageIcon);
				straight5JLabel.setBounds(205, 130, 25, 25);
				straight5JLabel.setVisible(true);
				this.add(straight5JLabel);

				tempImage = toolkit.getImage(straight5PathOn).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight5OnImageIcon = new ImageIcon(tempImage);
				straight5OnJLabel = new JLabel(straight5OnImageIcon);
				straight5OnJLabel.setBounds(205, 130, 25, 25);
				straight5OnJLabel.setVisible(false);
				this.add(straight5OnJLabel);

				tempImage = toolkit.getImage(straight6Path).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight6ImageIcon = new ImageIcon(tempImage);
				straight6JLabel = new JLabel(straight6ImageIcon);
				straight6JLabel.setBounds(230, 130, 25, 25);
				straight6JLabel.setVisible(true);
				this.add(straight6JLabel);

				tempImage = toolkit.getImage(straight6PathOn).getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon straight6OnImageIcon = new ImageIcon(tempImage);
				straight6OnJLabel = new JLabel(straight6OnImageIcon);
				straight6OnJLabel.setBounds(230, 130, 25, 25);
				straight6OnJLabel.setVisible(false);
				this.add(straight6OnJLabel);

			}
			{
				tempImage = toolkit.getImage(fruitpoolPath).getScaledInstance(200, 35, Image.SCALE_SMOOTH);
				mediaTracker.waitForAll();
				ImageIcon fruitpoolImageIcon = new ImageIcon(tempImage);
				fruitpoolLabel = new JLabel(fruitpoolImageIcon);
				fruitpoolLabel.setBounds(0, 105, 200, 35);
				fruitpoolLabel.setOpaque(false);
				this.add(fruitpoolLabel);

				almondAmount = new JLabel();
				almondAmount.setFont(new Font("Tahoma", 0, 14));
				almondAmount.setText(("" + fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("almond")));
				almondAmount.setBounds(5, 140, 30, 20);
				this.add(almondAmount);

				figAmount = new JLabel();
				figAmount.setFont(new Font("Tahoma", 0, 14));
				figAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("fig")));
				figAmount.setBounds(35, 140, 30, 20);
				this.add(figAmount); 

				grapesAmount = new JLabel();
				grapesAmount.setFont(new Font("Tahoma", 0, 14));
				grapesAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("grape")));
				grapesAmount.setBounds(65, 140, 30, 20);
				this.add(grapesAmount);

				lemonAmount = new JLabel();
				lemonAmount.setFont(new Font("Tahoma", 0, 14));
				lemonAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("lemon")));
				lemonAmount.setBounds(93, 140, 30, 20);
				this.add(lemonAmount);

				olivesAmount = new JLabel();
				olivesAmount.setFont(new Font("Tahoma", 0, 14));
				olivesAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("olive")));
				olivesAmount.setBounds(120, 140, 30, 20);
				this.add(olivesAmount);

				orangeAmount = new JLabel();
				orangeAmount.setFont(new Font("Tahoma", 0, 14));
				orangeAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("orange")));
				orangeAmount.setBounds(150, 140, 30, 20);
				this.add(orangeAmount);
				
				almondAmountbought = new JLabel();
				almondAmountbought.setFont(new Font("Tahoma", 0, 14));
				almondAmountbought.setText(("" + fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("almond")));
				almondAmountbought.setBounds(5, 85, 30, 20);
				this.add(almondAmountbought);

				figAmountbought = new JLabel();
				figAmountbought.setFont(new Font("Tahoma", 0, 14));
				figAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("fig")));
				figAmountbought.setBounds(35, 85, 30, 20);
				this.add(figAmountbought); 

				grapesAmountbought = new JLabel();
				grapesAmountbought.setFont(new Font("Tahoma", 0, 14));
				grapesAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("grape")));
				grapesAmountbought.setBounds(65, 85, 30, 20);
				this.add(grapesAmountbought);

				lemonAmountbought = new JLabel();
				lemonAmountbought.setFont(new Font("Tahoma", 0, 14));
				lemonAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("lemon")));
				lemonAmountbought.setBounds(93, 85, 30, 20);
				this.add(lemonAmountbought);

				olivesAmountbought = new JLabel();
				olivesAmountbought.setFont(new Font("Tahoma", 0, 14));
				olivesAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("olive")));
				olivesAmountbought.setBounds(120, 85, 30, 20);
				this.add(olivesAmountbought);

				orangeAmountbought = new JLabel();
				orangeAmountbought.setFont(new Font("Tahoma", 0, 14));
				orangeAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("orange")));
				orangeAmountbought.setBounds(150, 85, 30, 20);
				this.add(orangeAmountbought);

				riddleAmountbought = new JLabel();
				riddleAmountbought.setFont(new Font("Tahoma", 0, 14));
				riddleAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("riddle")));
				riddleAmountbought.setBounds(183, 85, 30, 20);
				this.add(riddleAmountbought);
				
				almondAmount.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of almonds in supply");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				almondAmountbought.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of almonds delivered");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				figAmount.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of figs in supply");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				figAmountbought.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of figs delivered");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				grapesAmount.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of grapes in supply");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				grapesAmountbought.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of grapes delivered");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				lemonAmount.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of lemons in supply");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				lemonAmountbought.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of lemons delivered");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				
				olivesAmount.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of olives in supply");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				olivesAmountbought.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of olives delivered");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				orangeAmount.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of oranges in supply");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				orangeAmountbought.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of oranges delivered");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				riddleAmountbought.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Amount of ?-tiles delivered");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				donkeyCart.addMouseListener(new MouseAdapter() {
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Donkey Cart - Necessary to deliver fruits to a community");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});
				
				
				straightLabels = new JLabel[12];
				straightLabels[0] = straight1JLabel;
				straightLabels[1] = straight1OnJLabel;
				straightLabels[2] = straight2JLabel;
				straightLabels[3] = straight2OnJLabel;
				straightLabels[4] = straight3JLabel;
				straightLabels[5] = straight3OnJLabel;
				straightLabels[6] = straight4JLabel;
				straightLabels[7] = straight4OnJLabel;
				straightLabels[8] = straight5JLabel;
				straightLabels[9] = straight5OnJLabel;
				straightLabels[10] = straight6JLabel;
				straightLabels[11] = straight6OnJLabel;
				
				for (int i = 0; i < straightLabels.length; i++) {
					straightLabels[i].addMouseListener(new MouseAdapter() {
						public void mouseEntered(MouseEvent evt) {
							try {
								fincaClient.getgFrame().setGameInfoLabelText("Lights up if you have made a delivery with the shown amount");
							} catch (RemoteException e) {
								e.printStackTrace();
							}
						}
						
						public void mouseExited(MouseEvent evt) {
							try {
								fincaClient.getgFrame().setGameInfoLabelText("");
							} catch (RemoteException e) {
								e.printStackTrace();
							}
						}
					});
				}
				
				oneFruitLessJokerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
					private String fruitToPayLess;

					public void mouseClicked(java.awt.event.MouseEvent evt) {
						Object[] possibilities = {"Almond", "Fig", "Orange", "Lemon", "Grape", "Olive"};
						fruitToPayLess = (String)JOptionPane.showInputDialog(
						                    null,
						                    "Which fruit would you like to use?\n",
						                    "Choose",
						                    JOptionPane.PLAIN_MESSAGE,
						                    null,
						                    possibilities,
						                    "almond");
						fincaClient.getTurn().useJoker("one fruit less", fincaClient.getGameBoard(), fruitToPayLess);
						if(!fincaClient.getGameBoard().getPlayers().get(playerNumber).has_one_fruit_less())
							oneFruitLessJokerLabel.setVisible(false);
					}
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("One Fruit Less - You can deliver fruits to a community whithout delivering one fruit of your choice. You can deliver 7 fruits in total by using this joker");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});

				moveTwiceJokerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						try {
							fincaClient.getTurn().useJoker("move twice", fincaClient.getGameBoard(), "");
							fincaClient.getgFrame().getgPanel().setHasMovedYet(false);
							if(!fincaClient.getGameBoard().getPlayers().get(playerNumber).has_double_move())
								moveTwiceJokerLabel.setVisible(false);
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Double Move On The Windmill - After moving with a farmer, you can move again (with the same farmer or another)");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});

				max10JokerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						fincaClient.getTurn().useJoker("large donkey cart", fincaClient.getGameBoard(), "");
						if(!fincaClient.getGameBoard().getPlayers().get(playerNumber).has_large_donkey_cart())
							max10JokerLabel.setVisible(false);
					}
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Large Donkey Cart - You can make a delivery of up to 10 fruits");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});

				gustOfWindJokerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						try {
							fincaClient.getTurn().useJoker("gust of wind", fincaClient.getGameBoard(), "");
							fincaClient.getgFrame().getgPanel().setHasMovedYet(false);
							if(!fincaClient.getGameBoard().getPlayers().get(playerNumber).has_gust_of_wind())
								gustOfWindJokerLabel.setVisible(false);
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					public void mouseEntered(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("Gust Of Wind - You can place your farmer on any blade of the windmill. You can't receive a donkey cart by using this joker");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
					
					public void mouseExited(MouseEvent evt) {
						try {
							fincaClient.getgFrame().setGameInfoLabelText("");
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				});

			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void refresh() throws RemoteException{
		donkeyCartAmount.setText(fincaClient.getGameBoard().getPlayer(playerNumber).get_donkeys()+" x");
		almondAmount.setText(("" + fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("almond")));
		figAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("fig")));
		grapesAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("grape")));
		lemonAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("lemon")));
		olivesAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("olive")));
		orangeAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_fruitcount("orange")));
		pointsAmount.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).get_points()));
		almondAmountbought.setText(("" + fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("almond")));
		figAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("fig")));
		grapesAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("grape")));
		lemonAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("lemon")));
		olivesAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("olive")));
		orangeAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("orange")));
		riddleAmountbought.setText(String.valueOf(fincaClient.getGameBoard().getPlayer(playerNumber).getAmountOfFruitOnTiles("riddle")));
		jokerRefresh();
		straightLabelsRefresh();
		this.updateBackground();
	}

	protected void jokerRefresh(){
		if(!fincaClient.getGameBoard().getPlayer(playerNumber).has_double_move())
			moveTwiceJokerLabel.setVisible(false);
		else
			moveTwiceJokerLabel.setVisible(true);

		if(!fincaClient.getGameBoard().getPlayer(playerNumber).has_gust_of_wind())
			gustOfWindJokerLabel.setVisible(false);
		else
			gustOfWindJokerLabel.setVisible(true);

		if(!fincaClient.getGameBoard().getPlayer(playerNumber).has_large_donkey_cart())
			max10JokerLabel.setVisible(false);
		else
			max10JokerLabel.setVisible(true);

		if(!fincaClient.getGameBoard().getPlayer(playerNumber).has_one_fruit_less())
			oneFruitLessJokerLabel.setVisible(false);
		else
			oneFruitLessJokerLabel.setVisible(true);
	}
	
	protected void straightLabelsRefresh(){
			if(fincaClient.getGameBoard().getPlayer(playerNumber).get_bonusCounter1()>0) {
				straight1OnJLabel.setVisible(true);
				straight1JLabel.setVisible(false);
			}
			else {
				straight1JLabel.setVisible(true);
				straight1OnJLabel.setVisible(false);
			}
			
			if(fincaClient.getGameBoard().getPlayer(playerNumber).get_bonusCounter2()>0) {
				straight2OnJLabel.setVisible(true);
				straight2JLabel.setVisible(false);
			}
			else {
				straight2JLabel.setVisible(true);
				straight2OnJLabel.setVisible(false);
			}
			
			if(fincaClient.getGameBoard().getPlayer(playerNumber).get_bonusCounter3()>0) {
				straight3OnJLabel.setVisible(true);
				straight3JLabel.setVisible(false);
			}
			else {
				straight3JLabel.setVisible(true);
				straight3OnJLabel.setVisible(false);
			}
			
			if(fincaClient.getGameBoard().getPlayer(playerNumber).get_bonusCounter4()>0) {
				straight4OnJLabel.setVisible(true);
				straight4JLabel.setVisible(false);
			}
			else {
				straight4JLabel.setVisible(true);
				straight4OnJLabel.setVisible(false);
			}
			
			if(fincaClient.getGameBoard().getPlayer(playerNumber).get_bonusCounter5()>0) {
				straight5OnJLabel.setVisible(true);
				straight5JLabel.setVisible(false);
			}
			else {
				straight5JLabel.setVisible(true);
				straight5OnJLabel.setVisible(false);
			}
			
			if(fincaClient.getGameBoard().getPlayer(playerNumber).get_bonusCounter6()>0) {
				straight6OnJLabel.setVisible(true);
				straight6JLabel.setVisible(false);
			}
			else {
				straight6JLabel.setVisible(true);
				straight6OnJLabel.setVisible(false);
			}
		}
	
	public void setActiveBackground() {
		this.setBackground(activeBackgroundColor);
	}
	
	public void setDefaultBackground() {
		this.setBackground(defaultBackgroundColor);
	}
	

	public void updateBackground() throws RemoteException {
		if(fincaClient.getServer().isMyTurn(playerNumber))
			this.setBackground(activeBackgroundColor);
		else
			this.setBackground(defaultBackgroundColor);
	}
}
