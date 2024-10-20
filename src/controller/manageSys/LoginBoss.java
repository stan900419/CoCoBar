package controller.manageSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logInSys.LoginUI;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;

public class LoginBoss extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bossAccount;
	private JPasswordField bossPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginBoss frame = new LoginBoss();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginBoss() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bossAccount = new JTextField();
		bossAccount.setBounds(164, 129, 277, 34);
		contentPane.add(bossAccount);
		bossAccount.setColumns(10);
		
		bossPassword = new JPasswordField();
		bossPassword.setBounds(164, 198, 277, 34);
		contentPane.add(bossPassword);
		
		JLabel lblNewLabel = new JLabel("JUST FOR BOSS");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bossAccount.setText("who's your BOSS!!");
				bossPassword.setText("iam");
//				new LoginUI().setVisible(true);
//				dispose();
				
			}
			@Override
	        public void mouseEntered(MouseEvent e) {
	        // 游標變為手形
			lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        }
	        @Override
	        public void mouseExited(MouseEvent e) {
	        // 游標恢復預設
	        lblNewLabel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	        }
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel.setBounds(165, 21, 245, 53);
		contentPane.add(lblNewLabel);		
		
		JLabel bossAc = new JLabel("Account：");
		bossAc.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		bossAc.setBounds(73, 129, 92, 34);
		contentPane.add(bossAc);
		
		JLabel bossPw = new JLabel("Password：");
		bossPw.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		bossPw.setBounds(65, 194, 89, 34);
		contentPane.add(bossPw);
		
		Button button = new Button("ENTER");
		button.setForeground(new Color(77, 77, 77));
		button.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 16));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bossAccount.getText().equals("who's your BOSS!!") && bossPassword.getText().equals("iam")) {
					new BossUI().setVisible(true);
					dispose();
				}
				else {
					System.out.println("error");
				}
			}
		});
		button.setBounds(188, 273, 159, 40);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 10, 548, 76);
		contentPane.add(panel);
		
		
	}
}
