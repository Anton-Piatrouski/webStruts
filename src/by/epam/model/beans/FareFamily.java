package by.epam.model.beans;

import java.util.List;

public class FareFamily {
	private String fareFamilyCode;
	private List<AncillaryAirComponent> ancillaryAirComponents;
	
	public FareFamily() {
		
	}

	public String getFareFamilyCode() {
		return fareFamilyCode;
	}

	public List<AncillaryAirComponent> getAncillaryAirComponents() {
		return ancillaryAirComponents;
	}

	public void setFareFamilyCode(String fareFamilyCode) {
		this.fareFamilyCode = fareFamilyCode;
	}

	public void setAncillaryAirComponents(List<AncillaryAirComponent> ancillaryAirComponents) {
		this.ancillaryAirComponents = ancillaryAirComponents;
	}
}
