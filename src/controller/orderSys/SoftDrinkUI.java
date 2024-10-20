package controller.orderSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.SoftDrink;
import util.Cal;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class SoftDrinkUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SoftDrinkUI frame = new SoftDrinkUI(new MainUI());
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
	public SoftDrinkUI(JFrame MainUI) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 120, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SpinnerNumberModel s1=new SpinnerNumberModel(0,0,100,1);
		JSpinner cola = new JSpinner(s1);
		cola.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		cola.setBounds(61, 216, 352, 37);
		contentPane.add(cola);
		
		SpinnerNumberModel s2=new SpinnerNumberModel(0,0,100,1);
		JSpinner soda = new JSpinner(s2);
		soda.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		soda.setBounds(61, 307, 352, 37);
		contentPane.add(soda);
		
		SpinnerNumberModel s3=new SpinnerNumberModel(0,0,100,1);
		JSpinner mountainDew = new JSpinner(s3);
		mountainDew.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		mountainDew.setBounds(61, 408, 352, 37);
		contentPane.add(mountainDew);
		
		SpinnerNumberModel s4=new SpinnerNumberModel(0,0,100,1);
		JSpinner blackTea = new JSpinner(s4);
		blackTea.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		blackTea.setBounds(61, 504, 352, 37);
		contentPane.add(blackTea);
		
		SpinnerNumberModel s5=new SpinnerNumberModel(0,0,100,1);
		JSpinner appleJuice = new JSpinner(s5);
		appleJuice.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		appleJuice.setBounds(61, 594, 352, 37);
		contentPane.add(appleJuice);
		
		JLabel lblNewLabel = new JLabel("Cola");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(61, 184, 132, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblSoda = new JLabel("Soda");
		lblSoda.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblSoda.setBounds(61, 275, 132, 31);
		contentPane.add(lblSoda);
		
		JLabel lblMountaindew = new JLabel("MountainDew");
		lblMountaindew.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblMountaindew.setBounds(61, 376, 132, 31);
		contentPane.add(lblMountaindew);
		
		JLabel lblBlacktea = new JLabel("BlackTea");
		lblBlacktea.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblBlacktea.setBounds(61, 472, 132, 31);
		contentPane.add(lblBlacktea);
		
		JLabel lblApplejuice = new JLabel("AppleJuice");
		lblApplejuice.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblApplejuice.setBounds(61, 562, 132, 31);
		contentPane.add(lblApplejuice);
		
		Button button = new Button("Submit");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SoftDrink s=new SoftDrink();
				s.setCola((Integer)cola.getValue());
				s.setSoda((Integer)soda.getValue());
				s.setMountainDew((Integer)mountainDew.getValue());
				s.setBlackTea((Integer)blackTea.getValue());
				s.setAppleJuice((Integer)appleJuice.getValue());
				
				Cal.SaveObject(s, "SoftDrinkOrder.txt");
				JOptionPane.showMessageDialog(null, "已加入點單~");								
				setVisible(false);
			}
		});
		button.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 18));
		button.setBounds(136, 674, 200, 61);
		contentPane.add(button);
		
		Button button_1 = new Button("Back");
		button_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainUI.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(10, 116, 120, 40);
		contentPane.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 499, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SOFT DRINK");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(175, 0, 274, 85);
		panel.add(lblNewLabel_1);
	}
}
