package service.impl;

import dao.impl.BeerDaoImpl;
import model.Beer;
import service.BeerService;

public class BeerServiceImpl implements BeerService {
	
	BeerDaoImpl bdi=new BeerDaoImpl();
	@Override
	public void addBeerOrder(Beer b) {
		bdi.insertBeer(b);		
	}

	@Override
	public void loadBeerOrder() {		
		
	}

}
