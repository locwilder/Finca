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

/*
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class E_PDFViewer {

	
}*/

import java.awt.Desktop;
import java.io.File;
import java.net.URL;


 
/**
 * This class opens the FincaRule.pdf  
 * @author mkuendig,locwilder,malib,thavo, michael_keller
 *
 */
public class E_FincaPDF {
 
	public E_FincaPDF(){
 
	  try {
		  //Gives the temp directory
		  String str =  System.getProperty("java.io.tmpdir");
		  //copys the pdf
		  E_PDFCopy.pdffile("FincaRules.pdf", System.getProperty("java.io.tmpdir") + "FincaRules.pdf");
		  //creates a new File (a copy) of the FincaRules.pdf
		  File pdfFile = new File(str + "FincaRules.pdf");
		  
		  if (pdfFile.exists()) {
 
			  if (Desktop.isDesktopSupported()) {
				  Desktop.getDesktop().open(pdfFile);
			  } else {
				  System.out.println("Awt Desktop is not supported!");
			  }
 
		  } else {
			  System.out.println("File does not exists!");
		  }
 
		  System.out.println("Done");
 
	  	} catch (Exception ex) {
	  		System.out.println(ex.toString());
	  	}
	 
		}
}
