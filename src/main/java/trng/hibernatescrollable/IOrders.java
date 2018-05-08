package trng.hibernatescrollable;

import java.util.Date;
import java.util.List;

public interface IOrders {
	public Orders addOrder(Orders order) ;
	public Orders loadOrder(int orderId) ;
	public void updateOrders(Orders order);
	public void deleteOrders(int orderId);
	public List<Orders> loadRecords(Date startDate, Date endDate);
}
