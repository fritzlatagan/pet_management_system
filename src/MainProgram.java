import java.awt.*;
import javax.swing.*;
public class MainProgram extends MyFrame{
	ImageIcon icon;
	JLabel back;
	
	Database db=new Database();
	
	public MainProgram() { 	
		db.DB_Connection("dbms_pet");
		icon=new ImageIcon("IMAGES/123.jpg");
		back=new JLabel("",icon,0);
	}
	
	public void setUI(){
		setJMenuBar(new MyMenu());
		add(new MyToolbar(),BorderLayout.NORTH);
		//add(new PanelChange(), BorderLayout.CENTER);
		
		add(new MyTab(), BorderLayout.CENTER);
		//add(new PanelInfo(),BorderLayout.WEST);
		//add(new PanelButtons(),BorderLayout.SOUTH);
		setTitle("Main Program");
		setExtendedState(MAXIMIZED_BOTH);
		//setUndecorated(true);
		getContentPane().setBackground(new Color(0, 90, 250, 90));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
    public static void main(String[] args) {
        // Create an instance of MainProgram
        MainProgram mainProgram = new MainProgram();
        // Call setUI method to set up the user interface
        mainProgram.setUI();
        // Make the frame visible
        mainProgram.setVisible(true);
    }
}


