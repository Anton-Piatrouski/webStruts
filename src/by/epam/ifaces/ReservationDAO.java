package by.epam.ifaces;

import by.epam.exceptions.DaoException;
import by.epam.model.beans.Reservation;

public interface ReservationDAO {
	Reservation getReservation(String fileName) throws DaoException;
}
