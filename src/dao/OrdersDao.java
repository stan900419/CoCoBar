package dao;

import java.util.List;

import model.Orders;

public interface OrdersDao {
	
	public void insertOrders(Orders o);
	
	List<Orders> showOrders();
	List<Orders> selectName(String membername);
	List<Orders> selectAccount(String memberaccount);

}
