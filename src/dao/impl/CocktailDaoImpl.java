package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.CocktailDao;
import dao.DbConnection;
import model.Cocktail;

public class CocktailDaoImpl implements CocktailDao
{

	public static void main(String[] args) {
		Cocktail c=new Cocktail(1,1,1,2,1);
		
		new CocktailDaoImpl().insertCocktail(c);
	}

	Connection conn=DbConnection.getDb();
	@Override
	public void insertCocktail(Cocktail c) {		
		String sql="insert into cocktail(martini,tequilaSunShine,whiteRussian,magarita,mojito)"
				+ "values(?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1, c.getMartini());
			ps.setInt(2, c.getTequilaSunShine());
			ps.setInt(3, c.getWhiteRussian());
			ps.setInt(4, c.getMagarita());
			ps.setInt(5, c.getMojito());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
