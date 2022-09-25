package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcContext {
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
		try (Connection c = dataSource.getConnection();
			 PreparedStatement ps = stmt.makePreparedStatement(c);
		) {
			ps.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}

	public void executeSql(final String query) throws SQLException {
		workWithStatementStrategy(
				c -> c.prepareStatement(query)
		);
	}
}

