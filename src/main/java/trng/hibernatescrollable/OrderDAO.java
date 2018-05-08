package trng.hibernatescrollable;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class OrderDAO implements IOrders{
	
	SessionFactory sf;
	//final static Logger logger = Logger.getLogger(Customer.class);

	@Override
	public Orders addOrder(Orders order){
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        try {
			Serializable id = session.save(order);
			order.setOrderNumber((int) id);
			transaction.commit();
		} catch (Exception e) {
			//logger.error("failed to execute addStudent method", e);
			transaction.rollback();
		}
        session.close();
        //logger.debug("Completed executing StudentDao::addStudent API");
        return order;
	}

	@Override
	public Orders loadOrder(int orderId) {
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        Orders order = (Orders) session.get(Orders.class, orderId);
        
        session.getTransaction().commit();
        session.close();
        
        return order;
	}

	@Override
	public void updateOrders(Orders order) {
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        session.update(order);
        
        session.getTransaction().commit();
        session.close();
	}

	@Override
	public void deleteOrders(int orderId) {
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        Orders order = (Orders) session.load(Orders.class, orderId);
        session.delete(order);
        
        session.getTransaction().commit();
        session.close();	
		
	}
	
	@Override
	public List<Orders> loadRecords(Date startDate, Date endDate){
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Orders.class);
        criteria.add(Restrictions.gt("orderDate", startDate));
        criteria.add(Restrictions.le("orderDate", endDate));
        
        @SuppressWarnings("unchecked")
        List<Orders> orderList = criteria.list();
        session.close();
        
		return orderList;
		
	}
	
	

	public Long monthlyCount(int number) throws ParseException{
		
		
		
		 Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-"+number+"-01 00:00:00");
	     Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-"+number+"-31 00:00:00");
		
	     
	    sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Orders.class);
        criteria.add(Restrictions.gt("orderDate", startDate));
        criteria.add(Restrictions.le("orderDate", endDate));
        criteria.setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
     
        session.close();
        
		return count;
		
	}

}
