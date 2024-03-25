import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class PanelChange extends JPanel{
	static JPanel panel1, panel2, panel3,panel4, panelMain;
	static CardLayout card;
	public PanelChange() {
		panel1=new JPanel();
		panel1.setBackground(new Color(255, 0, 50,0));//RGB
		panel1.add(new PanelInfo());
		
		panel2=new JPanel();
		panel2.setBackground(new Color(0, 255, 0));	
		panel2.add(new PanelTable());	
		
		panel3=new JPanel();
		panel3.setBackground(new Color(0, 0, 255));
		
		panel4=new JPanel();
		panel4.setBackground(Color.black);
		
		card=new CardLayout();
		panelMain=new JPanel(card);
		
		panelMain.add(panel1,"Panel 1");
		panelMain.add(panel2,"Panel 2");
		panelMain.add(panel3,"Panel 3");	
		panelMain.add(panel4,"Panel 4");	
		
		add(panelMain);
	}
}
