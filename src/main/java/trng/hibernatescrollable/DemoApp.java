package trng.hibernatescrollable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DemoApp {

	public static void main(String[] args) throws ParseException {
	     
        Address baliAddress = new Address("vill", "thapa", "main rd", "banglore", "india", 456000); 
        Address soniAddress = new Address("1232", "rajsthan", "rajsthan", "rajsthan", "india", 985365); 
        Customer bali = new Customer("bali",new Date(), "hey", "koun", "balli@gmail.com", 123456, 999); 
        Customer soni = new Customer("soni",new Date(), "rani", "neha", "soni@gmail.com", 55555, 564);
        Orders o1 = new Orders(new Date(), new Date(), "shipped");
        Orders o2 = new Orders(new Date(), new Date(), "received");
     
  
        bali.setAddress(baliAddress);  
        soni.setAddress(soniAddress);
        
        
        CustomerDAOimpl  dao = new CustomerDAOimpl();
        OrderDAO orderDao = new OrderDAO();
        
        Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2015-01-21 00:00:00");
	    Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2015-01-14 00:00:00");
        try {
			bali = dao.addCustomer(bali);
			soni = dao.addCustomer(soni);
			
			o1.setCustomer(bali);
			o2.setCustomer(soni);
			
			orderDao.addOrder(o1);
			orderDao.addOrder(o2);
			
			
			
			System.out.println(dao.loadCustomer(bali.getId()));
			System.out.println(dao.loadCustomer(soni.getId()));
			
			//dao.deleteCustomer(sid.getId());
			
			bali.setFname("rohit");
			dao.updateCustomer(bali);
			System.out.println(dao.loadCustomer(bali.getId()));
			
			System.out.println(orderDao.monthlyCount(5));
			
		} catch (CustomerException e) {
			
			e.printStackTrace();
		} 

	}

}
