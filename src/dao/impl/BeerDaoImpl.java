package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.BeerDao;
import dao.DbConnection;
import model.Beer;

public class BeerDaoImpl implements BeerDao
{

	public static void main(String[] args) {
		

	}

	Connection conn=DbConnection.getDb();
	@Override
	public void insertBeer(Beer b) {
		String sql="insert into beer(corona,budweiser,heineken,skol,asahi)"
				+ "values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1, b.getCorona());
			ps.setInt(2, b.getBudweiser());
			ps.setInt(3, b.getHeineken());
			ps.setInt(4, b.getSkol());
			ps.setInt(5, b.getAsahi());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Beer> selectAllBeer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beer> selectBeerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBeer(Beer b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBeer(int id) {
		// TODO Auto-generated method stub
		
	}

	
	

}
