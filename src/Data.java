import java.util.Vector;

import javax.swing.JComboBox;

public class Data {
	public static Vector Gender, Month, Day, Year;
	
	public Data() {
		Gender=new Vector();
		Gender.add("Male");
		Gender.add("Female");
			
		Month=new Vector();
		Month.add("January"); 
		Month.add("March"); Month.add("April");
		Month.add("May"); Month.add("June");
		Month.add("July"); Month.add("August");
		Month.add("September"); Month.add("October");
		Month.add("November"); Month.add("December");
			
		Day=new Vector();
		Year=new Vector();
		for (int i = 1; i <=31; i++) {
			Day.add(i);
			Year.add(i+1970);	
		}
	}
}
