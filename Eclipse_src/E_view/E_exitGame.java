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
import javax.swing.*;

import javax.swing.JFrame;


/**
 * Its a exit frame with a yes and no button. 
 * 
 * @author thavo, mkuendig, michael_keller, malib, locwilder
 */
public class E_exitGame {

	private JFrame parent;
	private JDialog dialog;
	private JLabel lab;
	private JButton byes;
	private JButton jButton1;
	private JButton bno;
	
	public E_exitGame(){

		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub

		parent = new JFrame();
		lab= new JLabel();
		byes = new JButton();
		bno = new JButton();		
		
			
		JOptionPane optionpane = new JOptionPane("Do you want to quit the Game?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
		dialog = optionpane.createDialog(parent, "Confirm");
		dialog.setVisible(true);
		
		int value = ((Integer)optionpane.getValue()).intValue();
		if(value == JOptionPane.YES_OPTION){
			System.exit(0);
		}
		
		dialog.getContentPane().setLayout(null);
		
		
		
	}
	
}
