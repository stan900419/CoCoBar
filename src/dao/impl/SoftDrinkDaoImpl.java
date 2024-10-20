package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DbConnection;
import dao.SoftDrinkDao;
import model.SoftDrink;

public class SoftDrinkDaoImpl implements SoftDrinkDao
{

	public static void main(String[] args) {
		SoftDrink s=new SoftDrink(1,1,1,1,1);
		new SoftDrinkDaoImpl().insertSoftDrink(s);

	}

	Connection conn=DbConnection.getDb();
	@Override
	public void insertSoftDrink(SoftDrink s) {
		String sql="insert into softDrink(cola,soda,mountainDew,blackTea,appleJuice)values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1, s.getCola());
			ps.setInt(2, s.getSoda());
			ps.setInt(3, s.getMountainDew());
			ps.setInt(4, s.getBlackTea());
			ps.setInt(5, s.getAppleJuice());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
