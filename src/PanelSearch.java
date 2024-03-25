import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class PanelSearch extends JPanel implements KeyListener{
	JLabel lblSearch;
	JTextField txtSearch;
	
	public PanelSearch() {
		lblSearch=new JLabel("Search");
		txtSearch=new JTextField(10);
		setLayout(new FlowLayout(FlowLayout.LEFT,2,1));
		add(lblSearch);
		add(txtSearch);
		txtSearch.addKeyListener(this);
	}

	public void keyTyped(KeyEvent e) { }
	public void keyPressed(KeyEvent e) { }

	public void keyReleased(KeyEvent e) {
		if(e.getSource().equals(txtSearch)){
			String search=txtSearch.getText();
			PanelTable.tbl_Sort=new TableRowSorter(PanelTable.model_pet);
			PanelTable.tbl_Pet.setRowSorter(PanelTable.tbl_Sort);
			PanelTable.tbl_Sort.setRowFilter(RowFilter.regexFilter(search, 0,1));
		}
	}
}
