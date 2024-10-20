package service.impl;

import dao.impl.SoftDrinkDaoImpl;
import model.SoftDrink;
import service.SoftDrinkService;

public class SoftDrinkServiceImpl implements SoftDrinkService
{

	SoftDrinkDaoImpl sdi=new SoftDrinkDaoImpl();
	@Override
	public void addSoftDrinkOrder(SoftDrink s) {
		sdi.insertSoftDrink(s);
		
	}

}
