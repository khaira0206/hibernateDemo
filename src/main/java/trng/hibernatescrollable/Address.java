package trng.hibernatescrollable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
	@Column
	private String addressLine1;

	private String addressLine2;

	private String city;

	private String state;

	private String country;

	private int zipcode;
	
	public Address() {
		super();
	}

	
	public Address(String addressLine1, String addressLine2, String city, String state, String country, int zipcode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}

	
	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipcode=" + zipcode + "]";
	}
}
