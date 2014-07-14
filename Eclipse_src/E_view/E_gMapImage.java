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

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;

import E_client.E_FincaClient;

import E_windmill_wings.E_Blade_Pool;


/**
 * 
 * This class contains the Map of the Finca game and the different 
 * windmill blades which are on the windmill
 * @author thavo, mkuendig, michael_keller, malib, locwilder
 *
 */

public class E_gMapImage extends JPanel{

	private E_Blade_Pool gpool;
	private Image imagemap;
	private E_FincaClient fclient;
	private BufferedImage image;
	private Image image0;
	private Image image1;
	private Image image2;
	private Image image3;
	private Image image4;
	private Image image5;
	private Image image6;
	private Image image7;
	private Image image8;
	private Image image9;
	private Image image10;
	private Image image11;
	private int xCord, yCord;
	private javax.swing.JLabel wm;
	
	private URL path;
	private Toolkit tk;
	private MediaTracker m;

	
	public E_gMapImage(E_FincaClient fc){
		
		fclient = fc;
		xCord = 0;
		yCord = 0;
		init();
		this.setPreferredSize(new Dimension(805,505));
		 
	}

	private void init() {
		// TODO Auto-generated method stub
		
		//loads the image of the map
		path = getClass().getResource("/media/finca map/FincaMap.png");
		tk = Toolkit.getDefaultToolkit();
    	try{
    		m = new MediaTracker(this);
    		imagemap = tk.getImage(path);
      		m.waitForAll();
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	} 
	       
	       BladeList();
	}
	
	
	/**
	 * Goes through the array in which the windmill blades are stored
	 * and reads the name of the blade typs and the position on the array
	 * 
	 * @pre get_blade_array() != null
	 * @post get_rescource_typ()-> getWindmillImage()
	 */
	private void BladeList() {
		
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 12 ; i++){
			getWindmillImage(i,fclient.getGameBoard().getMap().get_windmill().get_blade_array()[i].get_resource_typ());
		}
	}
	
	
	/**
	 * Method compares the names of the blades with the available fruits
	 * after that it loads the images of that fruit and pass the position of the
	 * blades to the next method
	 * 
	 * @pre (number < 12 && number >= 0) && str != null
	 * @post number
	 * @param the number of the array and the name of the blade
	 */
	private void getWindmillImage(int number, String str) {
		// TODO Auto-generated method stub

		
		if(str.equalsIgnoreCase("almond")){
			try{
				image = ImageIO.read(getClass().getResource("/media/finca pics/almondblade_2.png"));
				getWindmillOrder(number);
			}catch(Exception e){
				System.out.println("Error");
			}
		}else if(str.equalsIgnoreCase("fig")){
			try{
				image = ImageIO.read(getClass().getResource("/media/finca pics/figblade_2.png"));
				getWindmillOrder(number);
			}catch(Exception e){
				System.out.println("Error");
			}
		}else if(str.equalsIgnoreCase("grape")){
			try{
				image = ImageIO.read(getClass().getResource("/media/finca pics/grapeblade_2.png"));
				getWindmillOrder(number);
			}catch(Exception e){
				System.out.println("Error");
			}
		}else if(str.equalsIgnoreCase("lemon")){
			try{
				image = ImageIO.read(getClass().getResource("/media/finca pics/lemonblade_2.png"));
				getWindmillOrder(number);
			}catch(Exception e){
				System.out.println("Error");
			}
		}else if(str.equalsIgnoreCase("olive")){
			try{
				image = ImageIO.read(getClass().getResource("/media/finca pics/oliveblade_2.png"));
				getWindmillOrder(number);
			}catch(Exception e){
				System.out.println("Error");
			}
		}else if(str.equalsIgnoreCase("orange")){
			try{
				image = ImageIO.read(getClass().getResource("/media/finca pics/orangeblade_2.png"));
				getWindmillOrder(number);
			}catch(Exception e){
				System.out.println("Error");
			}
		}
	

	}



	/**
	 * This method rotates the image so that it matches to the position it
	 * should placed.
	 * 
	 * @pre number@pre != null
	 * @post
	 * @param number
	 */
	private void getWindmillOrder(int number) {
		// TODO Auto-generated method stub

		switch(number){
		case 0:
			try{
				BufferedImage rotatedImage = rotateImage(image, 280.0);
				image0 = rotatedImage;	
			}catch(Exception e){}
			
			break;
		case 1:
			try{
				BufferedImage rotatedImage = rotateImage(image, 312.0);
				image1 = rotatedImage;
			}catch(Exception e){}
			
			break;
		case 2:
			try{
				BufferedImage rotatedImage = rotateImage(image, 343.0);
				image2 = rotatedImage;
			}catch(Exception e){}
			
			break;
		case 3:
			try{
				BufferedImage rotatedImage = rotateImage(image, 10.0);
				image3 = rotatedImage;
			}catch(Exception e){}
			
			break;
		case 4:
			try{
				BufferedImage rotatedImage = rotateImage(image, 39.5);
				image4 = rotatedImage;
			}catch(Exception e){}

			break;
		case 5:
			try{
				BufferedImage rotatedImage = rotateImage(image, 69.0);
				image5 = rotatedImage;
			}catch(Exception e){}

			break;
		case 6:
			try{
				BufferedImage rotatedImage = rotateImage(image, 103.0);
				image6 = rotatedImage;
			}catch(Exception e){}
				
			break;
		case 7:
			try{
				BufferedImage rotatedImage = rotateImage(image, 133.0);
				image7 = rotatedImage;
			}catch(Exception e){}

			break;
		case 8:
			try{
				BufferedImage rotatedImage = rotateImage(image, 161.5);
				image8 = rotatedImage;
			}catch(Exception e){}

			break;
		case 9:
			try{
				BufferedImage rotatedImage = rotateImage(image, 191.5);
				image9 = rotatedImage;
			}catch(Exception e){}

			break;
		case 10:
			try{
				BufferedImage rotatedImage = rotateImage(image, 217.5);
				image10 = rotatedImage;
			}catch(Exception e){}

			break;
		case 11:
			try{
				BufferedImage rotatedImage = rotateImage(image, 254.5);
				image11 = rotatedImage;
			}catch(Exception e){}

			break;
		default:
			System.out.println("Error Windmill blade!");
			break;
		}
	}

	 private static BufferedImage rotateImage(BufferedImage src, double degrees) {
	        AffineTransform affineTransform = AffineTransform.getRotateInstance(
	                Math.toRadians(degrees),
	                src.getWidth() / 2,
	                src.getHeight() / 2);
	        	    BufferedImage rotatedImage = new BufferedImage(src.getWidth(), src
	                .getHeight(), src.getType());
	        Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
	        g.setTransform(affineTransform);
	        g.drawImage(src, 0, 0, null);
	        return rotatedImage;
	    }

	
	
	 
	/**
	 * Draws all images which are loaded
	 */
	@Override
    public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(imagemap != null){
        g2d.drawImage(imagemap,xCord,yCord,800,500,this); // see javadoc for more info on the parameters
		
		g2d.drawImage(image0,xCord +7,yCord +77,144,112, this);
		
		g2d.drawImage(image1,xCord + 40,yCord +32,144,112,this);

		g2d.drawImage(image2,96,7,144,112,this);
		
		g2d.drawImage(image3,157,8,144,114,this);
		
		g2d.drawImage(image4,206,40,144,114,this);

		g2d.drawImage(image5,237,87,144,114,this);
		
		g2d.drawImage(image6,229,139,144,114,this);
		
		g2d.drawImage(image7,193,185,144,114,this);
		
		g2d.drawImage(image8,142,212,144,114,this);
		
		g2d.drawImage(image9,79,209,144,114,this);
		
		g2d.drawImage(image10,25,178,144,114,this);
		
		g2d.drawImage(image11,6,130,144,114,this);


		}
    }

	
	
}
