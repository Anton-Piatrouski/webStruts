package by.epam.model.factories;

import by.epam.ifaces.ReservationDAO;
import by.epam.model.impls.ReservationImplXml;

public class ReservationImplFactory {
	public static ReservationDAO getImplementation() {
		return new ReservationImplXml();
	}
}
