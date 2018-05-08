package trng.hibernatescrollable;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "orderTable")
public class Orders {

	@Id
	@GeneratedValue
	@Column(name = "orderNumber")
	private int orderNumber;
	private Date orderDate;
	private Date shippedDate;
	private String status;

	@ManyToOne
	@JoinColumn(name = "Id")
	private Customer customer;
	
	public Orders() {
		super();
	}
	
	public Orders(Date orderDate, Date shippedDate, String status) {
		super();
		//this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.shippedDate = shippedDate;
		this.status = status;
	}
}
