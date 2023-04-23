package springbook.user.sandbox;

import java.sql.SQLException;
import springbook.user.dao.NUserDAO;
import springbook.user.dao.UserDAO;
import springbook.user.domain.User;

public class UserDAOTest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		UserDAO dao = new NUserDAO();
		User user = new User("lee", "bongho", "1234");
		dao.add(user);

		System.out.println(user.getId() + " 등록 성공");

		User lee = dao.get("lee");

		System.out.println(lee.getId() + " 조회 성공");
	}
}
