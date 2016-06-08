package by.epam.ifaces;

import by.epam.exceptions.DaoException;
import by.epam.model.beans.User;

public interface UserDAO {
	User getUser(String name, String password) throws DaoException;
}
