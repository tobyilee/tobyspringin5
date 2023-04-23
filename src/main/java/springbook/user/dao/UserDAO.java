package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import springbook.user.domain.User;

public class UserDAO {
	private final SimpleConnectionMaker connectionMaker;

	public UserDAO() {
		this.connectionMaker = new SimpleConnectionMaker();
	}


	public void add(User user) throws SQLException {
		Connection connection = connectionMaker.openConnection();
		PreparedStatement ps = connection.prepareStatement("INSERT INTO USERS(id, name, password) VALUES(?, ?, ?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();

		ps.close();
		connection.close();
	}


	public User get(String id) throws SQLException {
		Connection connection = connectionMaker.openConnection();

		PreparedStatement ps = connection.prepareStatement("SELECT * FROM USERS WHERE ID = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();

		User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));

		rs.close();
		ps.close();
		connection.close();

		return user;
	}
}
