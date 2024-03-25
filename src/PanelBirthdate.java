import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelBirthdate extends JPanel implements ActionListener{
	JLabel lblAge;
	static JTextField txtAge;	
	static JComboBox cboMonth, cboDay, cboYear;
	Data d=new Data();
	int age, current_year=2018;
	public PanelBirthdate() {
		lblAge=new JLabel("Age");
		txtAge=new JTextField("0",5);	
		txtAge.setEditable(false);
		txtAge.setToolTipText("Age");
		cboMonth=new JComboBox(d.Month);
		cboDay=new JComboBox(d.Day);
		cboYear=new JComboBox(d.Year);	
		cboYear.addActionListener(this); //register to action listener
		setLayout(new FlowLayout(FlowLayout.LEFT,1,1));
		setBorder(BorderFactory.createTitledBorder("Birthdate"));
		add(cboMonth); add(cboDay); add(cboYear); add(lblAge);add(txtAge);
	}

	public void actionPerformed(ActionEvent e) {
		age=2018-Integer.parseInt(cboYear.getSelectedItem().toString());
		txtAge.setText(age+"");
	}

}
