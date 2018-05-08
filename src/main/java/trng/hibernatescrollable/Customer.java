package trng.hibernatescrollable;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customerTable")
public class Customer extends EntiyBasic {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;
	private String fname;
	private String lname;
	private String email;
	private int phNo;
	private int empRepId;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "customer")
	private Set<Orders> orders;
	
	public Customer() {
		super();
	}
	
	public Customer(String recentUpdatedUser, Date lastUpdated, String fname, String lname, String email, int phNo, int empRepId) {
		super(recentUpdatedUser, lastUpdated);

		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phNo = phNo;
		this.empRepId = empRepId;
	}	
}
