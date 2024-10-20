package service.impl;

import dao.impl.CocktailDaoImpl;
import model.Cocktail;
import service.CocktailService;

public class CocktailServiceImpl implements CocktailService
{
	CocktailDaoImpl cdi=new CocktailDaoImpl();

	@Override
	public void addCocktailOrder(Cocktail c) {
		cdi.insertCocktail(c);
		
	}

}
