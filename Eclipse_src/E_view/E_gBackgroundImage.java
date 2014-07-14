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

import javax.swing.GrayFilter;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class loads the background image of the GUI. 
 * 
 * @author thavo, mkuendig, michael_keller, malib, locwilder
 *
 */
public class E_gBackgroundImage extends JPanel {
	private Image image;
		
	public E_gBackgroundImage(){
		URL path = getClass().getResource("/media/finca map/back5.png");
		Toolkit tk = Toolkit.getDefaultToolkit();
    	try{
    		MediaTracker m = new MediaTracker(this);
    		image = tk.getImage(path);
      		m.waitForAll();
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	@Override
    public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		if(image != null){
        g.drawImage(image,0,0,1100,690,this); // see javadoc for more info on the parameters
		}
    }
}
