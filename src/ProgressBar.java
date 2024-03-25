import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class ProgressBar extends MyFrame implements KeyListener{
	JProgressBar progressBar = new JProgressBar(0,100);
    JTextField txtNum;
    JButton btnPress;
    
	public ProgressBar() {
		btnPress=new JButton("Press");
		txtNum=new JTextField(20);
		progressBar.setValue(0);
	    progressBar.setStringPainted(true);
	   //progressBar.setBorder();
	    txtNum.addKeyListener(this);
	    btnPress.addKeyListener(this);
	    btnPress.setMnemonic('P');
	}
	public void setUI(){
		add(txtNum,BorderLayout.NORTH);
		add(btnPress,BorderLayout.SOUTH);
		add(progressBar, BorderLayout.CENTER);
		setMyFrame("Pet Management System", 200, 100, true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int val=0;
		 while (val <=100) {
	            progressBar.setValue(val);
	            try {
	                Thread.sleep(50);
	            } catch (InterruptedException e) { }
	            val += 2;
	       } 
		
	}
	public static void main(String[] args) {
		ProgressBar p=new ProgressBar();
		p.setUI();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource().equals(txtNum)){
			//If number only
			if((e.getKeyChar()>='a' && e.getKeyChar()<='z')){
				e.consume();
			}
			/**If character only -lowercase Characater.isAlpha()
			if(!(e.getKeyChar()>='a' && e.getKeyChar()<='z')){
				e.consume();
			}
			*/
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()==KeyEvent.VK_ENTER){
			JOptionPane.showMessageDialog(null, "BUTTON IS PRESSED");
			new PetRegistrationForm();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
