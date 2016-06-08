package by.epam.model.factories;

import by.epam.ifaces.UserDAO;
import by.epam.model.impls.UserImplDB;

public class UserImplFactory {
	public static UserDAO getImplementation() {
		return new UserImplDB();
	}
}
