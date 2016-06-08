package by.epam.model.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.exceptions.ConnectionException;
import by.epam.exceptions.DaoException;
import by.epam.ifaces.UserDAO;
import by.epam.model.beans.Role;
import by.epam.model.beans.User;
import by.epam.model.data.DatabaseManager;

public class UserImplDB implements UserDAO {
	private static final String SQL_SELECT_USER = "SELECT users.id, roles.`role` FROM users JOIN roles ON users.roleId = roles.id WHERE users.`name` = ? AND users.`password` = ?";
	private static final int PS_NAME_IND = 1;
	private static final int PS_PSW_IND = 2;
	private static final int RS_ID_IND = 1;
	private static final int RS_ROLE_IND = 2;
	
	@Override
	public User getUser(String name, String password) throws DaoException {
		Connection cn = null;
		PreparedStatement psSelectUser = null;
		ResultSet rsUser = null;
		try {
			cn = DatabaseManager.getConnection();
			psSelectUser = cn.prepareStatement(SQL_SELECT_USER);
			psSelectUser.setString(PS_NAME_IND, name);
			psSelectUser.setString(PS_PSW_IND, password);
			rsUser = psSelectUser.executeQuery();
			
			User user = new User();
			if (rsUser.next()) {
				int id = rsUser.getInt(RS_ID_IND);
				String roleStr = rsUser.getString(RS_ROLE_IND);
				Role role = Role.valueOf(roleStr);
				
				user.setId(id);
				user.setName(name);
				user.setRole(role);
			}
			return user;
			
		} catch (ConnectionException | SQLException e) {
			throw new DaoException("Database access error.");
		} finally {
			DatabaseManager.closeResultSet(rsUser);
			DatabaseManager.closeStatements(psSelectUser);
			DatabaseManager.closeConnection(cn);
		}
	}
}
