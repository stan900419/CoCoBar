package controller.logInSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.manageSys.LoginBoss;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Cal;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Button;
import javax.swing.JCheckBox;
import java.awt.Checkbox;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;
	private JPasswordField password;
	private JLabel lblNewLabel;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	String text="Welcome to CoCoBar~   Welcome to CoCoBar~  Welcome to CoCoBar~";
	JLabel tital;
	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		account = new JTextField();
		account.setBounds(172, 123, 240, 42);
		contentPane.add(account);
		account.setColumns(10);

		password = new JPasswordField();
		password.setEchoChar('*');
		password.setBounds(172, 210, 240, 42);
		contentPane.add(password);

		lblNewLabel = new JLabel("Account：");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel.setBounds(70, 124, 100, 41);
		contentPane.add(lblNewLabel);

		lblPassword = new JLabel("Password：");
		lblPassword.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblPassword.setBounds(62, 210, 108, 41);
		contentPane.add(lblPassword);

		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255, 0, 0));
		topPanel.setBounds(0, 10, 586, 70);
		contentPane.add(topPanel);
		topPanel.setLayout(null);

		
		
		JLabel tital = new JLabel(text);
		tital.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginBoss().setVisible(true);
				dispose();
				
			}
			@Override
	        public void mouseEntered(MouseEvent e) {
	        // 游標變為手形
	        tital.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        }
	        @Override
	        public void mouseExited(MouseEvent e) {
	        // 游標恢復預設
	        tital.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	        }
		});
		tital.setBounds(0, 10, 586, 50);
		topPanel.add(tital);
		tital.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		tital.setForeground(new Color(255, 255, 255));
		tital.setHorizontalAlignment(SwingConstants.LEFT);
		
		Timer timer=new Timer(200, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
								
				 text = text.substring(1) + text.charAt(0);
	             tital.setText(text);
				
			}});
		timer.start();
		
		
		
		JLabel ErrorLab = new JLabel("");
		ErrorLab.setForeground(new Color(255, 0, 0));
		ErrorLab.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		ErrorLab.setBounds(424, 123, 152, 45);
		contentPane.add(ErrorLab);
		
		Button pwcheckbox = new Button("Show Password");
		pwcheckbox.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		pwcheckbox.addMouseListener(new MouseAdapter() {
			@Override
            public void mousePressed(MouseEvent e) {                
                password.setEchoChar('\0');  // 當滑鼠按下時顯示密碼
            }

            @Override
            public void mouseReleased(MouseEvent e) {                
                password.setEchoChar('*');  // 當滑鼠放開時隱藏密碼
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // 游標變為手形
                pwcheckbox.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // 游標恢復預設
            	pwcheckbox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
		
		pwcheckbox.setBounds(432, 220, 100, 23);
		contentPane.add(pwcheckbox);

		Button btnLogin2 = new Button("Log In");
		btnLogin2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Account = account.getText();
//				char[] charPassword=password.getPassword();
				String Password = password.getText();
//				char[] passchar=Password.toCharArray();
				Member m = new MemberServiceImpl().Login(Account, Password);
				if (m != null) {
					Cal.SaveObject(m, "Member.txt");
					LoginSuccess ls = new LoginSuccess();
					ls.setVisible(true);
					dispose();
				} else {
					ErrorLab.setText("帳號或密碼有誤!");
//					LoginError lr = new LoginError();
//					lr.setVisible(true);
//					dispose();
				}
			}
		});
		btnLogin2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		btnLogin2.setBounds(316, 332, 162, 54);
		contentPane.add(btnLogin2);

		Button btnRegister2 = new Button("Register");
		btnRegister2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterUI r = new RegisterUI();
				r.setVisible(true);
				dispose();
			}
		});
		btnRegister2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		btnRegister2.setBounds(97, 333, 162, 53);
		contentPane.add(btnRegister2);		
		
		JLabel forgotpw = new JLabel("Forgot Password?");		
		forgotpw.setForeground(new Color(255,0,0));
		forgotpw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SetPasswordUI().setVisible(true);
				dispose();
			}
			@Override
            public void mouseEntered(MouseEvent e) {
                // 游標變為手形
                forgotpw.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // 游標恢復預設
            	forgotpw.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
		});
		forgotpw.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 14));
		forgotpw.setBounds(236, 264, 128, 42);
		contentPane.add(forgotpw);
		
		
	}
}
