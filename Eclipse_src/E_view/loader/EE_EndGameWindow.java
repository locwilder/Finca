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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * this class holds the GUI of the Window that pops up as soon as the game is finished
 * it shows the score and the highscore of the players
 * @author Michael KŸndig
 */
public class EE_EndGameWindow extends JFrame{

	ArrayList<javax.swing.JLabel> labels;
	int index = 0;
	private JLabel background;
    private JLabel endButton;
    private JLabel firstPlaceLabel;
    private JLabel firstPlaceName;
    private JLabel firstPlaceScore;
    private JLabel secondPlaceLabel;
    private JLabel secondPlaceName;
    private JLabel secondPlaceScore;
    private JLabel thirdPlaceLabel;
    private JLabel thirdPlaceName;
    private JLabel thirdPlaceScore;
    private JLabel fourthPlaceLabel;
    private JLabel fourthPlaceName;
    private JLabel fourthPlaceScore;
    private JLabel gameEndedLabel;
    private URL path;
    private Toolkit tk;
    private MediaTracker m;
    private Image image;
   
   
	
    public EE_EndGameWindow() {
    	labels = new ArrayList<JLabel>();
    	init();    	
    }
    
    private void init() {
    	
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
    	
		
		
        gameEndedLabel = new JLabel();
        firstPlaceLabel = new JLabel();
        firstPlaceName = new JLabel();
        firstPlaceScore = new JLabel();
        secondPlaceLabel = new JLabel();
        secondPlaceName = new JLabel();
        secondPlaceScore = new JLabel();
        thirdPlaceLabel = new JLabel();
        thirdPlaceName = new JLabel();
        thirdPlaceScore = new JLabel();
        fourthPlaceLabel = new JLabel();
        fourthPlaceName = new JLabel();
        fourthPlaceScore = new JLabel();
        endButton = new JLabel();
        
        
        gameEndedLabel.setBounds(100, 70, 230, 60);
        gameEndedLabel.setVerticalAlignment(SwingConstants.CENTER);
        gameEndedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameEndedLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
        gameEndedLabel.setOpaque(false);
        gameEndedLabel.setText("The Game has ended!");
        background.add(gameEndedLabel);
        
        firstPlaceLabel.setBounds(30, 120, 90, 30);
        firstPlaceLabel.setVerticalAlignment(SwingConstants.CENTER);
        firstPlaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstPlaceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        firstPlaceLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        firstPlaceLabel.setBackground(new Color(242, 209, 148));
        firstPlaceLabel.setOpaque(true);
        firstPlaceLabel.setText("1st Place");
        background.add(firstPlaceLabel);
        
        firstPlaceName.setBounds(145, 120, 140, 30);
        firstPlaceName.setVerticalAlignment(SwingConstants.CENTER);
        firstPlaceName.setHorizontalAlignment(SwingConstants.CENTER);
        firstPlaceName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        firstPlaceName.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        firstPlaceName.setBackground(new Color(242, 209, 148));
        firstPlaceName.setOpaque(true);
        
        firstPlaceScore.setBounds(330, 120, 50, 30);
        firstPlaceScore.setVerticalAlignment(SwingConstants.CENTER);
        firstPlaceScore.setHorizontalAlignment(SwingConstants.CENTER);
        firstPlaceScore.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        firstPlaceScore.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        firstPlaceScore.setBackground(new Color(242, 209, 148));
        firstPlaceScore.setOpaque(true);
        
        secondPlaceLabel.setBounds(30, 180, 90, 30);
        secondPlaceLabel.setVerticalAlignment(SwingConstants.CENTER);
        secondPlaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        secondPlaceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        secondPlaceLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        secondPlaceLabel.setBackground(new Color(242, 209, 148));
        secondPlaceLabel.setOpaque(true);
        secondPlaceLabel.setText("2nd Place");
        background.add(secondPlaceLabel);
        
        secondPlaceName.setBounds(145, 180, 140, 30);
        secondPlaceName.setVerticalAlignment(SwingConstants.CENTER);
        secondPlaceName.setHorizontalAlignment(SwingConstants.CENTER);
        secondPlaceName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        secondPlaceName.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        secondPlaceName.setBackground(new Color(242, 209, 148));
        secondPlaceName.setOpaque(true);
        
        
        secondPlaceScore.setBounds(330, 180, 50, 30);
        secondPlaceScore.setVerticalAlignment(SwingConstants.CENTER);
        secondPlaceScore.setHorizontalAlignment(SwingConstants.CENTER);
        secondPlaceScore.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        secondPlaceScore.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        secondPlaceScore.setBackground(new Color(242, 209, 148));
        secondPlaceScore.setOpaque(true);
        
        thirdPlaceLabel.setBounds(30, 240, 90, 30);
        thirdPlaceLabel.setVerticalAlignment(SwingConstants.CENTER);
        thirdPlaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        thirdPlaceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        thirdPlaceLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        thirdPlaceLabel.setBackground(new Color(242, 209, 148));
        thirdPlaceLabel.setOpaque(true);
        thirdPlaceLabel.setText("3rd Place");
        thirdPlaceLabel.setVisible(false);
        background.add(thirdPlaceLabel);
        
        thirdPlaceName.setBounds(145, 240, 140, 30);
        thirdPlaceName.setVerticalAlignment(SwingConstants.CENTER);
        thirdPlaceName.setHorizontalAlignment(SwingConstants.CENTER);
        thirdPlaceName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        thirdPlaceName.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        thirdPlaceName.setBackground(new Color(242, 209, 148));
        thirdPlaceName.setVisible(false);
        thirdPlaceName.setOpaque(true);
        
        thirdPlaceScore.setBounds(330, 240, 50, 30);
        thirdPlaceScore.setVerticalAlignment(SwingConstants.CENTER);
        thirdPlaceScore.setHorizontalAlignment(SwingConstants.CENTER);
        thirdPlaceScore.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        thirdPlaceScore.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        thirdPlaceScore.setBackground(new Color(242, 209, 148));
        thirdPlaceScore.setVisible(false);
        thirdPlaceScore.setOpaque(true);
        
        fourthPlaceLabel.setBounds(30, 300, 90, 30);
        fourthPlaceLabel.setVerticalAlignment(SwingConstants.CENTER);
        fourthPlaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fourthPlaceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fourthPlaceLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        fourthPlaceLabel.setBackground(new Color(242, 209, 148));
        fourthPlaceLabel.setOpaque(true);
        fourthPlaceLabel.setText("4th Place");
        fourthPlaceLabel.setVisible(false);
        background.add(fourthPlaceLabel);
        
        fourthPlaceName.setBounds(145, 300, 140, 30);
        fourthPlaceName.setVerticalAlignment(SwingConstants.CENTER);
        fourthPlaceName.setHorizontalAlignment(SwingConstants.CENTER);
        fourthPlaceName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fourthPlaceName.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        fourthPlaceName.setBackground(new Color(242, 209, 148));
        fourthPlaceName.setVisible(false);
        fourthPlaceName.setOpaque(true);
        
        fourthPlaceScore.setBounds(330, 300, 50, 30);
        fourthPlaceScore.setVerticalAlignment(SwingConstants.CENTER);
        fourthPlaceScore.setHorizontalAlignment(SwingConstants.CENTER);
        fourthPlaceScore.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fourthPlaceScore.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        fourthPlaceScore.setBackground(new Color(242, 209, 148));
        fourthPlaceScore.setVisible(false);
        fourthPlaceScore.setOpaque(true);
        
        endButton.setBounds(330, 350, 70, 40);
        endButton.setVerticalAlignment(SwingConstants.CENTER);
        endButton.setHorizontalAlignment(SwingConstants.CENTER);
        endButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        endButton.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        endButton.setBackground(new Color(242, 209, 148));
        endButton.setOpaque(true);
        endButton.setText("Quit");
        background.add(endButton);
        
        labels.add(firstPlaceName);
    	labels.add(firstPlaceScore);
    	labels.add(secondPlaceName);
    	labels.add(secondPlaceScore);
    	labels.add(thirdPlaceName);
    	labels.add(thirdPlaceScore);
    	labels.add(fourthPlaceName);
    	labels.add(fourthPlaceScore);
        
        
       for (int i = 0; i < labels.size(); i++) {
        	background.add(labels.get(i));
        }
        
        endButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				endButtonMouseClicked(evt);
			}
		});
    } 
    
    public void addScore(String score) {
    	labels.get(index).setText(score);
    	index ++;
    }
    
    private void endButtonMouseClicked(MouseEvent evt) {
		System.exit(0);
	}
    
    public void openEndGameWindow() {
    	this.setVisible(true);
    	if(index == 5 || index == 6) {
    		thirdPlaceLabel.setVisible(true);
    		thirdPlaceName.setVisible(true);
    		thirdPlaceScore.setVisible(true);
    	}
    	if(index > 6) {
    		thirdPlaceLabel.setVisible(true);
    		thirdPlaceName.setVisible(true);
    		thirdPlaceScore.setVisible(true);
    		
    		fourthPlaceLabel.setVisible(true);
    		fourthPlaceName.setVisible(true);
    		fourthPlaceScore.setVisible(true);
    	}
    }
	
}
