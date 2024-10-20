package controller.logInSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;

public class SetPasswordUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;
	private JTextField setpassword;
	private JTextField comfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetPasswordUI frame = new SetPasswordUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	MemberServiceImpl msi = new MemberServiceImpl();
	JOptionPane jp;

	/**
	 * Create the frame.
	 */
	public SetPasswordUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(71, 164, 101, 50);
		contentPane.add(lblNewLabel);

		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewPassword.setBounds(41, 254, 131, 50);
		contentPane.add(lblNewPassword);

		JLabel lblComfirm = new JLabel("Comfirm");
		lblComfirm.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblComfirm.setBounds(71, 359, 101, 50);
		contentPane.add(lblComfirm);

		account = new JTextField();
		account.setBounds(171, 175, 241, 37);
		contentPane.add(account);
		account.setColumns(10);

		JLabel accountWarn = new JLabel("");
		accountWarn.setBounds(171, 140, 139, 37);
		contentPane.add(accountWarn);

		setpassword = new JTextField();
		setpassword.setColumns(10);
		setpassword.setBounds(171, 265, 241, 37);
		contentPane.add(setpassword);

		comfirm = new JTextField();
		comfirm.setColumns(10);
		comfirm.setBounds(171, 370, 241, 37);
		contentPane.add(comfirm);

		JLabel matchPw = new JLabel("");
		matchPw.setBounds(171, 335, 172, 37);
		contentPane.add(matchPw);

		Timer timer = new Timer(800, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (account.getText().isEmpty()) {
					accountWarn.setText("");
				} else if (msi.findAccount(account.getText())) {
					accountWarn.setText("OK");
					accountWarn.setForeground(new Color(0, 128, 64));
				} else {
					accountWarn.setText("Cannot find Acoount!");
					accountWarn.setForeground(new Color(255, 0, 0));
				}
				// ---------------------
				if (setpassword.getText().isEmpty() || comfirm.getText().isEmpty()) {
					matchPw.setText("");
				} else if (setpassword.getText().equals(comfirm.getText())) {
					matchPw.setText("Passwords match.");
					matchPw.setForeground(new Color(0, 128, 64));
				} else {
					matchPw.setText("Passwords not match.");
					matchPw.setForeground(new Color(255, 0, 0));
				}
			}
		});
		timer.start(); // 開始 Timer

		Button button = new Button("Submit");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 先檢查Account
				if (msi.findAccount(account.getText())) {

					if (setpassword.getText().equals(comfirm.getText())) {
						// update newPassword
						msi.setPassword(account.getText(), comfirm.getText());
						JOptionPane.showMessageDialog(null, "Set Password Success.");
						// switch UI
						new LoginUI().setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "password is not match!");
					}

				} else {
					JOptionPane.showMessageDialog(null, "cannot find account!");
				}

			}
		});
		button.setBounds(163, 456, 160, 50);
		contentPane.add(button);

		Button button_1 = new Button("Back");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginUI().setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(10, 103, 118, 37);
		contentPane.add(button_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 10, 501, 75);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("SET PASSWORD");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(152, 0, 282, 75);
		panel.add(lblNewLabel_1);

	}
}
