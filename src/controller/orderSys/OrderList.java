package controller.orderSys;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.OrdersDaoImpl;
import model.Beer;
import model.Cocktail;
import model.Member;
import model.Orders;
import model.SoftDrink;
import service.impl.BeerServiceImpl;
import service.impl.CocktailServiceImpl;
import service.impl.SoftDrinkServiceImpl;
import util.Cal;

import javax.swing.JTextArea;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.Font;

public class OrderList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderList frame = new OrderList(new MainUI());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	BeerServiceImpl bsi=new BeerServiceImpl();
	CocktailServiceImpl csi=new CocktailServiceImpl();
	SoftDrinkServiceImpl ssi=new SoftDrinkServiceImpl();
	
	OrdersDaoImpl odi=new OrdersDaoImpl();

	/**
	 * Create the frame.
	 */
	public OrderList(JFrame MainUI) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 120, 500, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		output.setBounds(10, 77, 466, 597);
		contentPane.add(output);
		
		Button button = new Button("Back");
		button.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainUI.setVisible(true);
				dispose();
			}
		});
		button.setBounds(10, 20, 120, 40);
		contentPane.add(button);
		
		Beer b=(Beer)Cal.ReadObject("BeerOrder.txt");
		Cocktail c=(Cocktail)Cal.ReadObject("CocktailOrder.txt");
		SoftDrink s=(SoftDrink)Cal.ReadObject("SoftDrinkOrder.txt");
		Member m=(Member)Cal.ReadObject("Member.txt");
		
		//調出資料
		int beeramount = b.getCorona()+b.getBudweiser()+b.getHeineken()+b.getSkol()+b.getAsahi();
		int cocktailamount = c.getMartini()+c.getTequilaSunShine()+c.getWhiteRussian()+c.getMagarita()+c.getMojito();
		int softdrinkamount = s.getCola()+s.getSoda()+s.getMountainDew()+s.getBlackTea()+s.getAppleJuice();
		
		int beerprice = b.getSum();
		int cocktailprice = c.getSum();
		int softdrinkprice = s.getSum();
		
		Button button_1 = new Button("Show List");
		button_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer total=b.getSum()+c.getSum()+s.getSum();
				
				output.setText("  BEER\n-Corona $120："+b.getCorona()+"\n-百威 $120："+b.getBudweiser()+
	            		"\n-海尼根 $110："+b.getHeineken()+"\n-SKOL $130："+b.getSkol()+"\n-Asahi $150："+b.getAsahi()+"\t\t 小記："+b.getSum()+
	            		"\n----------------------------------------------------------------------"+
	            		"\n  COCKTAIL\n-Martini $280："+c.getMartini()+"\n-Tequila Sun Shine $300："+c.getTequilaSunShine()+"\n-White Russian $350："+c.getWhiteRussian()+
	            		"\n-Magarita $280："+c.getMagarita()+"\n-Mojito $250："+c.getMojito()+"\t 小記："+c.getSum()+
	            		"\n----------------------------------------------------------------------"+
	            		"\n  SOFT DRINK\n-Cola $120："+s.getCola()+"\n-Soda $120："+s.getSoda()+"\n-MountainDew $120："+s.getMountainDew()+
	            		"\n-Black Tea $80："+s.getBlackTea()+"\n-Apple Juice $80："+s.getAppleJuice()+"\t 小記："+s.getSum()+
	            		"\n----------------------------------------------------------------------"+
	            		"\n\t\t10%服務費："+total*0.1+
	            		"\n\t\t總價格："+(total+total*0.1));
			}
		});
		button_1.setBounds(356, 20, 120, 40);
		contentPane.add(button_1);
		
		Button button_2 = new Button("GET ORDER");
		button_2.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 16));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(b.getSum()+c.getSum()+s.getSum()!=0) 
				{
					//insert beer cocktail softdrink into database
					bsi.addBeerOrder(b);
					csi.addCocktailOrder(c);
					ssi.addSoftDrinkOrder(s);
					
					//insert orders into database
					Orders o=new Orders();
					o.setMembername(m.getName());
					o.setMemberaccount(m.getAccount());
					o.setBeeramount(beeramount);
					o.setCocktailamount(cocktailamount);
					o.setSoftdrinkamount(softdrinkamount);
					o.setPrice(beerprice, cocktailprice, softdrinkprice);					
					
					odi.insertOrders(o);
					
					//Save as PDF					
					try {
						PrinterJob job=PrinterJob.getPrinterJob();
						job.setPrintable(output.getPrintable(null, null));
						if(job.printDialog()) {
							job.print();
						}
					}catch(PrinterException e1) {
						e1.printStackTrace();
					}					
					
					JOptionPane.showMessageDialog(null, "The order has been submitted.");
					System.exit(0);
					
				} else {
					JOptionPane.showMessageDialog(null, "Please get order~");
				}
								
				
								
			}
		});
		button_2.setBounds(173, 714, 140, 51);
		contentPane.add(button_2);
		
		
	}

}
