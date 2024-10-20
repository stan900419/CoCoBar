package controller.logInSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.MemberServiceImpl;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Member;
import java.awt.Color;
import java.awt.Button;

public class RegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField account;
	private JTextField password;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUI frame = new RegisterUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	MemberServiceImpl msi=new MemberServiceImpl();
	private JLabel lblNewLabel;
	private JLabel lblAccount;
	private JLabel lblPassword;
	private JLabel lblEmail;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private Button button;

	/**
	 * Create the frame.
	 */
	public RegisterUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(180, 152, 237, 30);
		contentPane.add(name);
		name.setColumns(10);
		
		account = new JTextField();
		account.setColumns(10);
		account.setBounds(180, 238, 237, 30);
		contentPane.add(account);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(180, 323, 237, 30);
		contentPane.add(password);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(180, 408, 237, 30);
		contentPane.add(email);
		
		lblNewLabel = new JLabel("Name：");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel.setBounds(91, 152, 78, 30);
		contentPane.add(lblNewLabel);
		
		lblAccount = new JLabel("Account：");
		lblAccount.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblAccount.setBounds(91, 238, 78, 30);
		contentPane.add(lblAccount);
		
		lblPassword = new JLabel("Password：");
		lblPassword.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblPassword.setBounds(91, 323, 97, 30);
		contentPane.add(lblPassword);
		
		lblEmail = new JLabel("Email：");
		lblEmail.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblEmail.setBounds(91, 408, 78, 30);
		contentPane.add(lblEmail);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 523, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("CREATE ACCOUNT");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(153, 10, 265, 50);
		panel.add(lblNewLabel_1);
		
		button = new Button("Register");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(account.getText().isEmpty())	{
					 JOptionPane.showMessageDialog(null, "Please fill in the information.");
					
				} else {
					String Account=account.getText();
					if(msi.findAccount(Account))
					{
						//帳號已註冊
						 JOptionPane.showMessageDialog(null, "The account has been used！");
					}
					else
					{
						String Email=email.getText();
						if(msi.findEmail(Email))
						{
							//Email已使用過
							 JOptionPane.showMessageDialog(null, "The email has been used！");
						}
						else 
						{
							String Name=name.getText();
							String Password=password.getText();
							
							Member m=new Member(Name,Account,Password,Email);
							msi.addMember(m);
							
							JOptionPane.showMessageDialog(null, "Register Success~");
							dispose();
						}					
					}
				}
			}
		});
		button.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 18));
		button.setBounds(156, 479, 193, 52);
		contentPane.add(button);
		
		Button button_1 = new Button("Back");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginUI().setVisible(true);
				dispose();
			}
		});
		button_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		button_1.setBounds(10, 76, 118, 38);
		contentPane.add(button_1);
	}
}
