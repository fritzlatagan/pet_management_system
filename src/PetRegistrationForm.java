import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
public class PetRegistrationForm extends MyFrame implements WindowListener{
	
	public PetRegistrationForm() {
		setLayout(null); 
		add(new PanelInfo()).setBounds(10,10,300,250);
		add(new PanelBirthdate()).setBounds(10,260,300,80);
		add(new PanelSearch()).setBounds(320,20,300,30);
		add(new JScrollPane(new PanelTable())).setBounds(340,50,450,290);
		add(new PanelButtons()).setBounds(40, 340, 600, 30);
	
		addWindowListener(this);
		
		setMyFrame("Pet Registration Form", 800, 600, true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	public void windowOpened(WindowEvent e) { }
	public void windowClosing(WindowEvent e) { 
		
	}
	public void windowClosed(WindowEvent e) { }
	public void windowIconified(WindowEvent e) { }
	public void windowDeiconified(WindowEvent e) { }
	public void windowActivated(WindowEvent e) { }
	public void windowDeactivated(WindowEvent e) { }
}
