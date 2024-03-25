import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
public class MyTab extends JTabbedPane{
	JPanel panelAll, panelInfo;
	ImageIcon icon;
	public MyTab() {
		//icon=new ImageIcon("IMAGES/456.png");	
		//icon=new ImageIcon("IMAGES/1.png");
		//setIconAt(0, icon);
		
		/**panelAll=new JPanel(new BorderLayout());
		panelAll.add(new PanelInfo(),BorderLayout.WEST);
		panelAll.add(new PanelButtons(),BorderLayout.SOUTH);
		panelAll.add(new PanelTable(),BorderLayout.CENTER);
		*/
		
		panelAll=new JPanel();
		panelAll.setLayout(null);
		panelAll.add(new PanelInfo()).setBounds(10, 10, 350, 380);
		panelAll.add(new PanelTable()).setBounds(400, 10, 900, 380);
		panelAll.add(new PanelButtons()).setBounds(50, 450, 700, 60);
		
		add("Pet",panelAll);
		add("Utility",null);
		
	}
}
