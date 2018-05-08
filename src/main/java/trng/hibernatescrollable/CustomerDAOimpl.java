package trng.hibernatescrollable;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import trng.hibernatescrollable.*;

public class CustomerDAOimpl implements ICustomerDAO{
	
	SessionFactory sf;
	final static Logger logger = Logger.getLogger(Customer.class);

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        try {
			Serializable id = session.save(customer);
			customer.setId((int) id);
			transaction.commit();
		} catch (Exception e) {
			logger.error("failed to execute addStudent method", e);
			transaction.rollback();
		}
        session.close();
        logger.debug("Completed executing StudentDao::addStudent API");
        return customer;
	}

	@Override
	public Customer loadCustomer(int Id) throws CustomerException {
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        Customer customer = (Customer) session.get(Customer.class, Id);
        
        session.getTransaction().commit();
        session.close();
        
        return customer;
	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerException {
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        session.update(customer);
        
        
        session.getTransaction().commit();
        session.close();
		
	}

	@Override
	public void deleteCustomer(int Id) throws CustomerException {
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        Customer customer = (Customer) session.load(Customer.class, Id);
        session.delete(customer);
        
        session.getTransaction().commit();
        session.close();	
	}

}
