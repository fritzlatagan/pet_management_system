import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PanelTable extends JPanel{
	static JTable tbl_Pet;
	static DefaultTableModel model_pet =new DefaultTableModel();
	static TableRowSorter tbl_Sort=new TableRowSorter();
	
	Database db = new Database();

	public PanelTable() {
		db.DB_Connection("dbms_pet");
		
		//data=new Database("PetColumn.txt");//Column
		model_pet=new DefaultTableModel();
		//data.setColumn(model_pet);
		
		//data=new Database("Pet.txt"); //Row-records
		//data.displayRecords(model_pet);
		tbl_Pet=new JTable(model_pet);
		db.displayRecords("Select *from tbl_pet", tbl_Pet);
		//data.setRow(model_pet);
		
		//PanelInfo.txtID.setText(getRowCount()+"");
		setLayout(new BorderLayout());
		add(new JScrollPane(tbl_Pet), BorderLayout.CENTER);
	}
	public static int getRowCount(){
		return model_pet.getRowCount()+1;
	}
}
