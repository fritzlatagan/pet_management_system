import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

public class Login {
	private JPanel cPane;
	private JPanel panel;
	private JButton btnLogin;
	private JButton btnExit;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel jlabUsername;
	private JLabel jlabPassword;
	private JComboBox<String> jcb;
	private JFrame jfrmLogin = new JFrame("Login");
	String username = "";
	String password = "";
	
	public Login(){
		
		jfrmLogin.setSize(400, 250);
		jfrmLogin.setResizable(false);
		jfrmLogin.setLocationRelativeTo(null);
		jfrmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrmLogin.setVisible(true);
		
		cPane = new JPanel();
		cPane.setLayout(new BorderLayout(0,0));
		jfrmLogin.setContentPane(cPane);
		
		panel = new JPanel();
		panel.setLayout(null);
		cPane.add(panel,BorderLayout.CENTER);
		
		txtUsername = new JTextField(20);
		txtPassword = new JPasswordField(20);
		txtUsername.setBounds(150, 70, 180, 25);
		txtPassword.setBounds(150, 100, 180, 25);
		
		jlabUsername = new JLabel("USERNAME");
		jlabPassword = new JLabel("PASSWORD");
		jlabUsername.setBounds(50, 70, 80, 25);
		jlabPassword.setBounds(50, 100, 80, 25);
		
		btnLogin = new JButton("login");
		btnExit = new JButton("Exit");
		btnLogin.setBounds(180, 130, 70, 25);
		btnExit.setBounds(260, 130, 70, 25);
		
		String items[] = {"Administrator","Employee"};
		jcb = new JComboBox<String>(items);
		jcb.setBounds(150, 40, 180, 25);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainProgram mp=new MainProgram();
				mp.setUI();
				mp.setVisible(true);
				jfrmLogin.setVisible(false);
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
			
		panel.add(btnLogin);
		panel.add(txtUsername);
		panel.add(txtPassword);
		panel.add(jlabUsername);
		panel.add(jlabPassword);
		panel.add(btnExit);
		panel.add(jcb);
	}
	
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				
				public void run() {
					new Login();
				}
			});
		} catch (Exception e) {
		}
	}
}
