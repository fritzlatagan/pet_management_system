import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelInfo extends JPanel implements ActionListener,MouseListener, KeyListener, ItemListener{
	JLabel lblID,lblName, lblAge, lblStatus,lblOwner,lblGender,lblColor,lblBreed,lblPrice;
	static JTextField txtID, txtName,txtColor,txtPrice,txtAge;
	static JComboBox cboGender, cboBreed, cboStatus, cboOwner;
	Font f=new Font("Arial", Font.BOLD, 16);

	public PanelInfo() {
		lblID=new JLabel("ID: ");
		lblName=new JLabel("Name: ");
		lblAge=new JLabel("Age: ");
		lblGender=new JLabel("Gender: ");
		lblPrice=new JLabel("Price: ");
		lblColor=new JLabel("Color: ");
		lblBreed=new JLabel("Breed: ");
		lblStatus=new JLabel("Status: ");
		lblOwner=new JLabel("Owner: ");
		
		txtID=new JTextField(20);
		txtID.setEditable(false);
		txtID.setText(PanelTable.getRowCount()+"");

		txtName=new JTextField(20);
		txtColor=new JTextField(20);
		txtPrice=new JTextField(20);
		txtAge=new JTextField(20);
	
		cboGender=new JComboBox();
		cboBreed=new JComboBox();
		cboStatus=new JComboBox();
		cboOwner=new JComboBox();
		
		setBorder(BorderFactory.createTitledBorder(null,"Pet Registration Form",0,0,f));
		setLayout(new GridLayout(9,2));
		
		setFont(f);
		
		add(lblID);add(txtID);
		add(lblName); add(txtName);
		add(lblAge); add(txtAge);
		add(lblGender); add(cboGender);
		add(lblColor); add(txtColor);
		add(lblBreed); add(cboBreed);
		add(lblPrice); add(txtPrice);
		add(lblStatus); add(cboStatus);
		add(lblOwner);add(cboOwner);
		
		txtColor.addActionListener(this);
		txtColor.addMouseListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Color color=JColorChooser.showDialog(null, "Choose",Color.black);
		txtColor.setForeground(color);	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Color color=JColorChooser.showDialog(null, "Choose",Color.black);
		txtColor.setBackground(color);
		txtColor.setText("");
		//setBackground(color);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		/**if(e.getSource().equals(cboType)){
			String chosen=cboType.getSelectedItem().toString();
			if(chosen.equals("Add-New")){
				PetType type=new PetType();
				type.setUI();
			}
			
		}
		*/
	}
	
}
