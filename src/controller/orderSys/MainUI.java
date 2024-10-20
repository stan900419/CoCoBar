package controller.orderSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logInSys.LoginUI;
import model.Beer;
import model.Cocktail;
import model.SoftDrink;
import service.impl.BeerServiceImpl;
import util.Cal;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.Cursor;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Color;

public class MainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JLabel marqueeLabel;
	private String text = " What happen in CoCoBar. Stay in CoCoBar!!    What happen in CoCoBar. Stay in CoCoBar!!   ";

	/**
	 * Create the frame.
	 */
	
	BeerUI b=new BeerUI(this);
	CocktailUI c=new CocktailUI(this);
	SoftDrinkUI s=new SoftDrinkUI(this);
	
	public MainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 設置 JLabel
        marqueeLabel = new JLabel(text);
        marqueeLabel.setForeground(new Color(255, 255, 255));
        marqueeLabel.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 18));
        marqueeLabel.setBounds(0, 10, 827, 58);
        marqueeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        getContentPane().add(marqueeLabel);
        
        // 使用 Timer 來模擬跑馬燈效果
        Timer timer1 = new Timer(80, new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                // 將字串的第一個字母移到最後
                text = text.substring(1) + text.charAt(0);
                marqueeLabel.setText(text);
            }
        });        
        timer1.start(); // 啟動 Timer
		
		JLabel BeerLab = new JLabel("New label");
		ImageIcon origianl=new ImageIcon(MainUI.class.getResource("/image/Beer.jpg"));
		Image image=origianl.getImage();
		Image scale=image.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
		ImageIcon scaleIcon=new ImageIcon(scale);
		BeerLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				b.setVisible(true);				
			}
			@Override
            public void mouseEntered(MouseEvent e) {
                // 游標變為手形
                BeerLab.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // 游標恢復預設
            	BeerLab.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
		});
		BeerLab.setIcon(scaleIcon);
		BeerLab.setBounds(29, 195, 250, 200);
		contentPane.add(BeerLab);
		
		JLabel SpiritsLab = new JLabel("New label");
		ImageIcon origianl_1=new ImageIcon(MainUI.class.getResource("/image/Spirits.jpg"));
		Image image_1=origianl_1.getImage();
		Image scale_1=image_1.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
		ImageIcon scaleIcon_1=new ImageIcon(scale_1);
		
		SpiritsLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				c.setVisible(true);
			}
			@Override
            public void mouseEntered(MouseEvent e) {
                // 游標變為手形
				SpiritsLab.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // 游標恢復預設
            	SpiritsLab.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
		});
		SpiritsLab.setIcon(scaleIcon_1);
		SpiritsLab.setBounds(289, 195, 250, 200);
		contentPane.add(SpiritsLab);
		
		JLabel SoftDrinkLab = new JLabel("New label");
		ImageIcon original_2=new ImageIcon(MainUI.class.getResource("/image/SoftDrink.jpg"));
		Image image_2=original_2.getImage();
		Image scale_2=image_2.getScaledInstance(250, 200, Image.SCALE_SMOOTH);
		ImageIcon scaleIcon_2=new ImageIcon(scale_2);
		SoftDrinkLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s.setVisible(true);				
			}
			@Override
            public void mouseEntered(MouseEvent e) {
                // 游標變為手形
				SoftDrinkLab.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // 游標恢復預設
            	SoftDrinkLab.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
		});
		SoftDrinkLab.setIcon(scaleIcon_2);
		SoftDrinkLab.setBounds(549, 195, 250, 200);
		contentPane.add(SoftDrinkLab);
		
		Button button = new Button("Submit");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Beer b=(Beer)Cal.ReadObject("BeerOrder.txt");
				Cocktail c=(Cocktail)Cal.ReadObject("CocktailOrder.txt");
				SoftDrink s=(SoftDrink)Cal.ReadObject("SoftDrinkOrder.txt");
				
				Cal.SaveObject(b, "BeerOrder.txt");
				Cal.SaveObject(c, "CocktailOrder.txt");
				Cal.SaveObject(s, "SoftDrinkOrder.txt");
				
				new OrderList(MainUI.this).setVisible(true);
				setVisible(false);
			}
		});
		button.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 18));
		button.setBounds(309, 431, 200, 50);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("BEERS");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(107, 144, 103, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblCocktail = new JLabel("COCKTAIL");
		lblCocktail.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblCocktail.setBounds(354, 144, 145, 41);
		contentPane.add(lblCocktail);
		
		JLabel lblSoftDrink = new JLabel("SOFT DRINK");
		lblSoftDrink.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblSoftDrink.setBounds(612, 144, 162, 41);
		contentPane.add(lblSoftDrink);
		
		Button button_1 = new Button("Log Out");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginUI().setVisible(true);
				setVisible(false);				
			}
		});
		button_1.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 16));
		button_1.setBounds(10, 88, 120, 37);
		contentPane.add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 10, 865, 58);
		contentPane.add(panel);
		
		
	}
}
