package controller.orderSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Beer;
import service.impl.BeerServiceImpl;
import util.Cal;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;

public class BeerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeerUI frame = new BeerUI(new MainUI());
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
	public BeerUI(JFrame MainUI) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 120, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		SpinnerNumberModel s1=new SpinnerNumberModel(0,0,100,1);
		JSpinner corona = new JSpinner(s1);
		corona.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		corona.setBounds(65, 205, 352, 36);
		contentPane.add(corona);
		
		SpinnerNumberModel s2=new SpinnerNumberModel(0,0,100,1);
		JSpinner budweiser = new JSpinner(s2);
		budweiser.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		budweiser.setBounds(65, 297, 352, 36);
		contentPane.add(budweiser);
		
		SpinnerNumberModel s3=new SpinnerNumberModel(0,0,100,1);
		JSpinner heineken = new JSpinner(s3);
		heineken.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		heineken.setBounds(65, 389, 352, 36);
		contentPane.add(heineken);
		
		SpinnerNumberModel s4=new SpinnerNumberModel(0,0,100,1);
		JSpinner skol = new JSpinner(s4);
		skol.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		skol.setBounds(66, 479, 352, 36);
		contentPane.add(skol);
		
		SpinnerNumberModel s5=new SpinnerNumberModel(0,0,100,1);
		JSpinner asahi = new JSpinner(s5);
		asahi.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		asahi.setBounds(66, 571, 352, 36);
		contentPane.add(asahi);
		
		JLabel lblNewLabel = new JLabel("Corona");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(65, 159, 89, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblBudweiser = new JLabel("Budweiser");
		lblBudweiser.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblBudweiser.setBounds(65, 251, 106, 42);
		contentPane.add(lblBudweiser);
		
		JLabel lblHeineken = new JLabel("Heineken");
		lblHeineken.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblHeineken.setBounds(65, 343, 89, 42);
		contentPane.add(lblHeineken);
		
		JLabel lblSkol = new JLabel("Skol");
		lblSkol.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblSkol.setBounds(65, 435, 89, 42);
		contentPane.add(lblSkol);
		
		JLabel lblAsahi = new JLabel("Asahi");
		lblAsahi.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblAsahi.setBounds(65, 525, 89, 42);
		contentPane.add(lblAsahi);
		
		Button button_1 = new Button("Back");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainUI.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 16));
		button_1.setBounds(10, 113, 120, 40);
		contentPane.add(button_1);
		
		Button button = new Button("Submit");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Beer b=new Beer();
				b.setCorona((Integer)corona.getValue());
				b.setBudweiser((Integer)budweiser.getValue());
				b.setHeineken((Integer)heineken.getValue());
				b.setSkol((Integer)skol.getValue());
				b.setAsahi((Integer)asahi.getValue());
				
				Cal.SaveObject(b, "BeerOrder.txt");
				JOptionPane.showMessageDialog(null, "已加入點單~");			
				setVisible(false);
			}
		});
		button.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 18));
		button.setBounds(142, 653, 200, 60);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 503, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("BEER");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_1.setBounds(203, 0, 161, 85);
		panel.add(lblNewLabel_1);
	}
}
