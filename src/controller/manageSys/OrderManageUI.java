package controller.manageSys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.impl.OrdersDaoImpl;
import model.Orders;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTextField;

public class OrderManageUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderManageUI frame = new OrderManageUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	DefaultTableModel model;
	OrdersDaoImpl odi = new OrdersDaoImpl();
	private JTextField findname;
	private JTextField findaccount;

	/**
	 * Create the frame.
	 */
	public OrderManageUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		findname = new JTextField();
		findname.setBounds(360, 452, 154, 29);
		contentPane.add(findname);
		findname.setColumns(10);
		
		findaccount = new JTextField();
		findaccount.setColumns(10);
		findaccount.setBounds(705, 452, 154, 29);
		contentPane.add(findaccount);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 881, 88);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ORDER MANAGING SYSTEM");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(264, 0, 364, 88);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new BossUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(22, 98, 115, 32);
		contentPane.add(btnNewButton);

		// 創建表頭（列名）
		String[] columnNames = { "ID", "Name", "Account", "Beer", "Cocktail", "Soft Drink", "Revenue" };

		// 創建可編輯的 DefaultTableModel
		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// 設置除 "ID" 外的所有欄位都可編輯
				return column != 0;
			}
		};

		JTable table = new JTable(model);
		// 欄位寬度設定
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 140, 839, 284);
		contentPane.add(scrollPane);

		JButton btnNewButton_1 = new JButton("Show Revenue");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				
				List<Orders> l=odi.showOrders();
				for(Orders u:l) {
					Object[] rowData = {u.getId(), u.getMembername(), 
							u.getMemberaccount(), u.getBeeramount(), u.getCocktailamount(),
							u.getSoftdrinkamount(), u.getPrice() };
					model.addRow(rowData);
				}
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1.setBounds(22, 444, 154, 45);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Find Name");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				
				String Name = findname.getText();
				List<Orders> l=odi.selectName(Name);
				for(Orders u:l) {
					Object[] rowData = {u.getId(), u.getMembername(), 
							u.getMemberaccount(), u.getBeeramount(), u.getCocktailamount(),
							u.getSoftdrinkamount(), u.getPrice() };
					model.addRow(rowData);
				}
				
				findname.setText("");				
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(199, 444, 154, 45);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("Find Account");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				
				String Account = findaccount.getText();
				List<Orders> l=odi.selectAccount(Account);
				for(Orders u:l) {
					Object[] rowData = {u.getId(), u.getMembername(), 
							u.getMemberaccount(), u.getBeeramount(), u.getCocktailamount(),
							u.getSoftdrinkamount(), u.getPrice() };
					model.addRow(rowData);
				}
				
				findaccount.setText("");
			}
		});
		btnNewButton_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1_2.setBounds(542, 444, 154, 45);
		contentPane.add(btnNewButton_1_2);
		
		
	}
}
