package controller.logInSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.orderSys.MainUI;
import model.Member;
import util.Cal;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Button;

public class LoginSuccess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccess frame = new LoginSuccess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Cal cal=new Cal();

	/**
	 * Create the frame.
	 */
	public LoginSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel WelcomeLab = new JLabel("Welcom Back!");
		WelcomeLab.setForeground(new Color(255, 255, 255));
		WelcomeLab.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		WelcomeLab.setBounds(186, 43, 173, 123);
		contentPane.add(WelcomeLab);
		
		JLabel getnameLab = new JLabel("");
		getnameLab.setForeground(new Color(255, 255, 255));
		getnameLab.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		getnameLab.setBounds(91, 70, 111, 68);
		contentPane.add(getnameLab);
		
		Member m=(Member)Cal.ReadObject("Member.txt");
		getnameLab.setText(m.getName());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 70, 436, 68);
		contentPane.add(panel);
		
		Button button = new Button("OK");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MainUI().setVisible(true);
				dispose();
				
			}
		});
		button.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		button.setBounds(140, 192, 150, 40);
		contentPane.add(button);
		
		
	}
}
