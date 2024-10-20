package controller.orderSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cocktail;
import util.Cal;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class CocktailUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CocktailUI frame = new CocktailUI(new MainUI());
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
	public CocktailUI(JFrame MainUI) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 120, 500, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		SpinnerNumberModel s1=new SpinnerNumberModel(0,0,100,1);
		JSpinner martini = new JSpinner(s1);
		martini.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		martini.setBounds(56, 210, 352, 37);
		contentPane.add(martini);
		
		SpinnerNumberModel s2=new SpinnerNumberModel(0,0,100,1);
		JSpinner tequilaSunShine = new JSpinner(s2);
		tequilaSunShine.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		tequilaSunShine.setBounds(56, 311, 352, 37);
		contentPane.add(tequilaSunShine);
		
		SpinnerNumberModel s3=new SpinnerNumberModel(0,0,100,1);
		JSpinner whiteRussian = new JSpinner(s3);
		whiteRussian.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		whiteRussian.setBounds(56, 409, 352, 37);
		contentPane.add(whiteRussian);
		
		SpinnerNumberModel s4=new SpinnerNumberModel(0,0,100,1);
		JSpinner magarita = new JSpinner(s4);
		magarita.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		magarita.setBounds(56, 511, 352, 37);
		contentPane.add(magarita);
		
		SpinnerNumberModel s5=new SpinnerNumberModel(0,0,100,1);
		JSpinner mojito = new JSpinner(s5);
		mojito.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		mojito.setBounds(56, 617, 352, 37);
		contentPane.add(mojito);
		
		JLabel lblNewLabel = new JLabel("Martini");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(56, 170, 80, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblTequilasunshine = new JLabel("TequilaSunShine");
		lblTequilasunshine.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblTequilasunshine.setBounds(56, 272, 177, 37);
		contentPane.add(lblTequilasunshine);
		
		JLabel lblWhiterussian = new JLabel("WhiteRussian");
		lblWhiterussian.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblWhiterussian.setBounds(56, 373, 136, 37);
		contentPane.add(lblWhiterussian);
		
		JLabel lblMagarita = new JLabel("Magarita");
		lblMagarita.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblMagarita.setBounds(56, 474, 80, 37);
		contentPane.add(lblMagarita);
		
		JLabel lblMojito = new JLabel("Mojito");
		lblMojito.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblMojito.setBounds(56, 580, 80, 37);
		contentPane.add(lblMojito);
		
		Button button = new Button("Submit");
		button.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 18));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cocktail c=new Cocktail();
				c.setMartini((Integer)martini.getValue());
				c.setTequilaSunShine((Integer)tequilaSunShine.getValue());
				c.setWhiteRussian((Integer)whiteRussian.getValue());
				c.setMagarita((Integer)magarita.getValue());
				c.setMojito((Integer)mojito.getValue());
				
				Cal.SaveObject(c, "CocktailOrder.txt");				
				JOptionPane.showMessageDialog(null, "已加入點單~");
				setVisible(false);
			}
		});
		button.setBounds(141, 673, 200, 61);
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
		button_1.setBounds(10, 108, 120, 40);
		contentPane.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 507, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("COCKTAIL");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel_1.setBounds(183, 0, 269, 84);
		panel.add(lblNewLabel_1);
	}
}
