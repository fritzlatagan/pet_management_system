import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PetType extends MyFrame{
	JTextField txtType, txtSearch;
	JLabel lblType, lblSearch;
	JButton btnAddNew, btnClose, btnUpdate;	
	JTable tbl_Type;
	DefaultTableModel model_Type;
	JPanel panelLeft, panelRight;
	
	Database db=new Database();
	
	public PetType() { 
		lblType= new JLabel("Type");
		lblSearch= new JLabel("Search");
		
		txtType=new JTextField(20);
		txtSearch=new JTextField(10);
		
		btnAddNew=new JButton("Add New");
		btnClose=new JButton("Close");
		btnUpdate=new JButton("Update");
	
		model_Type=new DefaultTableModel();
		tbl_Type=new JTable(model_Type);
	
	}	
	public void setUI(){
		Font f=new Font("Arial", Font.BOLD, 14);
		panelLeft=new JPanel();
		panelLeft.setBorder(BorderFactory.createTitledBorder(null,"Type Adding Form",0,0,f));
		panelLeft.setLayout(null);
		panelLeft.add(lblType).setBounds(10, 30, 100, 20); 
		panelLeft.add(txtType).setBounds(60, 30, 160, 20);
		panelLeft.add(btnAddNew).setBounds(120, 60, 100, 30);
		
		panelRight=new JPanel();
		panelRight.setBorder(BorderFactory.createTitledBorder(null,"Type Information",0,0,f));
	
		panelRight.setLayout(null);
		
		add(lblSearch).setBounds(10, 120, 100, 20);
		add(txtSearch).setBounds(60, 120, 160, 20);
		
		panelRight.add(new JScrollPane(tbl_Type)).setBounds(10, 20, 280, 260);
		panelRight.add(btnUpdate).setBounds(5, 280, 100, 30);
		panelRight.add(btnClose).setBounds(170, 285, 100, 30);
		
		setLayout(null);
		add(panelLeft).setBounds(0, 5, 300, 100);
		add(panelRight).setBounds(0, 150, 300, 320);
		
		setMyFrame("Type", 300, 500, true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		PetType t=new PetType();
		t.setUI();
	}
}
