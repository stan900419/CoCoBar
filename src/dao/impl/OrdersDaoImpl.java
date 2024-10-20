package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.OrdersDao;
import model.Orders;

public class OrdersDaoImpl implements OrdersDao{

	

	Connection conn=DbConnection.getDb();
	
	@Override
	public void insertOrders(Orders o) {
		String sql="insert into orders(membername, memberaccount, beeramount, cocktailamount, softdrinkamount, price)"
				+ "values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, o.getMembername());
			ps.setString(2, o.getMemberaccount());
			ps.setInt(3, o.getBeeramount());
			ps.setInt(4, o.getCocktailamount());
			ps.setInt(5, o.getSoftdrinkamount());
			ps.setInt(6, o.getPrice());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Orders> showOrders() {
		String sql="select * from orders";
		List<Orders> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Orders o=new Orders();
				o.setId(rs.getInt("id"));
				o.setMembername(rs.getString("membername"));
				o.setMemberaccount(rs.getString("memberaccount"));
				o.setBeeramount(rs.getInt("beeramount"));
				o.setCocktailamount(rs.getInt("cocktailamount"));
				o.setSoftdrinkamount(rs.getInt("softdrinkamount"));
				o.setPrice(rs.getInt("price"));
				
				l.add(o);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Orders> selectName(String membername) {
		String sql="select * from cocobar.orders where  membername=?";
		List<Orders> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, membername);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Orders o=new Orders();
				o.setId(rs.getInt("id"));
				o.setMembername(rs.getString("membername"));
				o.setMemberaccount(rs.getString("memberaccount"));
				o.setBeeramount(rs.getInt("beeramount"));
				o.setCocktailamount(rs.getInt("cocktailamount"));
				o.setSoftdrinkamount(rs.getInt("softdrinkamount"));
				o.setPrice(rs.getInt("price"));
				
				l.add(o);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Orders> selectAccount(String memberaccount) {
		String sql="select * from cocobar.orders where  memberaccount=?";
		List<Orders> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, memberaccount);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Orders o=new Orders();
				o.setId(rs.getInt("id"));
				o.setMembername(rs.getString("membername"));
				o.setMemberaccount(rs.getString("memberaccount"));
				o.setBeeramount(rs.getInt("beeramount"));
				o.setCocktailamount(rs.getInt("cocktailamount"));
				o.setSoftdrinkamount(rs.getInt("softdrinkamount"));
				o.setPrice(rs.getInt("price"));
				
				l.add(o);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

}
