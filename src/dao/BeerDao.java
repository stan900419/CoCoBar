package dao;

import java.util.List;

import model.Beer;

public interface BeerDao 
{
	//create
	void insertBeer(Beer b);
	//read
	List<Beer> selectAllBeer();
	List<Beer> selectBeerById(int id);
	//update
	void updateBeer(Beer b);
	//delete
	void deleteBeer(int id);
}
