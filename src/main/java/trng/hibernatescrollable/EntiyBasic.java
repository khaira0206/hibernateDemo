package trng.hibernatescrollable;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class EntiyBasic {

	private String recentUpdatedUser;

	private Date lastUpdated;

	public EntiyBasic() {
		super();
	}

	public EntiyBasic(String recentUpdatedUser, Date lastUpdated) {
		super();
		this.recentUpdatedUser = recentUpdatedUser;
		this.lastUpdated = lastUpdated;
	}
}
