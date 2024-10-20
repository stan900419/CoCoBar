package controller.manageSys;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.impl.MemberServiceImpl;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class MemberManageUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	MemberServiceImpl msi = new MemberServiceImpl();
	private JTextField account;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManageUI frame = new MemberManageUI();
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
	public MemberManageUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 796, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MEMBER MANAGING SYSTEM");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(210, 0, 392, 75);
		panel.add(lblNewLabel);

		account = new JTextField();
		account.setBounds(181, 475, 161, 30);
		contentPane.add(account);
		account.setColumns(10);

		// 創建表頭（列名）
		String[] columnNames = { "ID", "Name", "Account", "Password", "Email" };

		// 創建可編輯的 DefaultTableModel
		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// 設置除 "ID" 外的所有欄位都可編輯
				return column != 0;
			}
		};

		// 創建 JTable 並設置模型
		JTable table = new JTable(model);
		// 欄位寬度設定
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);

		// 創建 JScrollPane 以便滾動表格
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 133, 750, 250);
		contentPane.add(scrollPane);

		// 查詢全部按鈕
		JButton btnFindAll = new JButton("Show All");
		btnFindAll.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnFindAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 清空現有的表格資料
				model.setRowCount(0);

				// 從資料庫抓取所有成員資料
				List<Member> l = msi.showAllMember();
				// 遍歷成員資料，將每個成員的資料添加到表格中
				for (Member m : l) {
					Object[] rowData = { m.getId(), m.getName(), m.getAccount(), m.getPassword(), m.getEmail() };
					model.addRow(rowData);
				}
			}
		});
		btnFindAll.setBounds(20, 409, 139, 47);
		contentPane.add(btnFindAll);

		// 返回按鈕
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new BossUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(20, 89, 117, 30);
		contentPane.add(btnNewButton_1);

		// 依帳號查詢按鈕
		JButton btnFindAccount = new JButton("Find Account");
		btnFindAccount.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnFindAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);

				List<Member> l = msi.showMemberUseAccount(account.getText());
				for (Member u : l) {
					Object[] row = { u.getId(), u.getName(), u.getAccount(), u.getPassword(), u.getEmail() };
					model.addRow(row);
				}
				account.setText("");
			}
		});
		btnFindAccount.setBounds(20, 466, 139, 47);
		contentPane.add(btnFindAccount);

		// 更新按鈕
		JButton btnUpdate = new JButton("Update Member");
		btnUpdate.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 遍歷 JTable 所有行，並讀取其中的資料
				for (int i = 0; i < model.getRowCount(); i++) {
					// 從 JTable 中獲取每一行的資料
					int id = (int) model.getValueAt(i, 0);
					String name = (String) model.getValueAt(i, 1);
					String account = (String) model.getValueAt(i, 2);
					String password = (String) model.getValueAt(i, 3);
					String email = (String) model.getValueAt(i, 4);

					// 根據資料創建新的 Member 物件
					Member member = new Member();
					member.setId(id);
					member.setName(name);
					member.setAccount(account);
					member.setPassword(password);
					member.setEmail(email);
                    
					// 調用 msi 的更新方法，將更改傳遞到資料庫
					msi.updateMember(member);

				}

				// 提示用戶更新完成
				JOptionPane.showMessageDialog(null, "資料更新完成！");
			}
		});
		btnUpdate.setBounds(600, 466, 170, 47);
		contentPane.add(btnUpdate);

		JButton btnNewButton = new JButton("Delete Member");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow(); // 取得被選中的行的索引

				if (selectedRow != -1) { // 檢查是否有選中行
					
					// 彈出一個確認對話框，顯示"確定要刪除會員?"
					int deleteresult = JOptionPane.showConfirmDialog(null, "確定要刪除會員?", "你忍心嗎?",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

					// 如果用戶選擇 "是" (YES_OPTION)，則刪除會員
					if (deleteresult == JOptionPane.YES_OPTION) {
						// 更新資料庫的邏輯，刪除會員
                        int memberId=(int) model.getValueAt(selectedRow, 0);
						msi.deleteMember(memberId);						
						
						// 刪除所選中的行
						model.removeRow(selectedRow);
						JOptionPane.showMessageDialog(null, "會員已刪除");
					} 
					
				} else {
					// 提示用戶未選擇任何行
					JOptionPane.showMessageDialog(null, "請選擇要刪除的會員");
				}

			}
		});
		btnNewButton.setBounds(600, 409, 170, 47);
		contentPane.add(btnNewButton);
		
	}
}
