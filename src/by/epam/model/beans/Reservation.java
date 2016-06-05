package by.epam.model.beans;

public class Reservation {
	private String code;
	private String description;
	private ResComponent resComponent;
	private Customer customer;
	private FareFamily fareFamily;
	
	public Reservation() {
		
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public ResComponent getResComponent() {
		return resComponent;
	}

	public Customer getCustomer() {
		return customer;
	}

	public FareFamily getFareFamily() {
		return fareFamily;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setResComponent(ResComponent resComponent) {
		this.resComponent = resComponent;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setFareFamily(FareFamily fareFamily) {
		this.fareFamily = fareFamily;
	}
}
