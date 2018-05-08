package trng.hibernatescrollable;

public interface ICustomerDAO {
	public Customer addCustomer(Customer std) throws CustomerException;

	public Customer loadCustomer(int stdId) throws CustomerException;

	public void updateCustomer(Customer std) throws CustomerException;

	public void deleteCustomer(int stdId) throws CustomerException;
}
