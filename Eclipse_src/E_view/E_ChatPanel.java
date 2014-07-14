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
import java.rmi.RemoteException;

import javax.swing.*;
import E_client.E_IChatClient;

/**
 * 
 * 
 * @author thavo, mkuendig, michael_keller, malib, locwilder
 *
 */


public class E_ChatPanel extends JPanel {

	private E_IChatClient chatClient;
	private JTextArea chatText;
	private JTextField inputField;
	private JScrollPane jScrollPane1;
	//private javax.swing.JButton sendButton;

	public E_ChatPanel() throws RemoteException{
		this.setLayout(null);
		init();
		this.setPreferredSize(new Dimension(280,150));
		this.setBackground(new Color(255,255,255,75));
	}

	private void init() {
		jScrollPane1 = new javax.swing.JScrollPane();
		chatText = new javax.swing.JTextArea();
		inputField = new javax.swing.JTextField();

		chatText.setColumns(20);
		chatText.setEditable(false);
		chatText.setRows(5);
		chatText.setFont(new java.awt.Font("Lucida Grande", 0, 10));


		inputField.setBounds(15, 115, 250, 25);
		inputField.setFont(new java.awt.Font("Lucida Grande", 0, 10));
		jScrollPane1.setBounds(15, 15, 250, 90);
		jScrollPane1.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));

		this.add(inputField);
		this.add(jScrollPane1);
		this.add(chatText);

		jScrollPane1.setViewportView(chatText);
		jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		inputField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				inputFieldKeyPressed(evt);
			}
		});
	}

	private void inputFieldKeyPressed(java.awt.event.KeyEvent evt) {
		try{
			if (evt.getKeyCode() == 10){
				String message = inputField.getText();
				inputField.setText("");
				chatClient.sendMessage(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printMessage(String msg){
		chatText.append(msg + "\n");
		jScrollPane1.getVerticalScrollBar().setValue(jScrollPane1.getVerticalScrollBar().getMaximum());

	}

	public void setChatClient(E_IChatClient client){
		this.chatClient = client;
	}

	public E_IChatClient getChatClient() {
		return this.chatClient;
	}
}
