package models;

import java.sql.SQLException;

public class UserDAO extends DAO {

	private final static String createQuery = "INSERT INTO `users` (`id`, `role_id`, `name`, `id_num`, `password`, `datetime_joined`) VALUES (NULL, 1, ?, ?, ?, NOW())";
	private final static String[] createParams = { "name", "id_num", "password" };

	private final static String getQuery = "SELECT `users`.`id`, `roles`.`role`, `name`, `id_num`, `datetime_joined` FROM `roles`, `users` WHERE `id_num` = ? and `role_id` = `roles`.`id`";
	private final static String[] getResult = { "id", "role", "name", "id_num", "datetime_joined" };
	
	private static final String getEnrolled = "select courses.id, courses.course_code, courses.units, enrollment.user_id "
			+ "from enrollment inner join courses on enrollment.course_id = courses.id "
			+ "where enrollment.user_id = ?";

	public boolean create(User user) {
		boolean result = false;
		try {
			con = getConnection();
			ps = con.prepareStatement(createQuery);
			for (int i = 0, j = 1, k = createParams.length; i < k; i++, j++)
				ps.setString(j, user.getInfo(createParams[i]));
			ps.executeUpdate();
			result = true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public User getInfo(String id_num) {
		User user = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(getQuery);
			ps.setString(1, id_num);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				for (int i = 0, j = 1, k = getResult.length; i < k; i++, j++)
					user.setInfo(getResult[i], rs.getObject(j).toString());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public User getEnrolled(User user) {
		try {
			con = getConnection();
			ps = con.prepareStatement(getEnrolled);
			ps.setInt(1, Integer.parseInt(user.getId()));
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course(rs.getInt(1), rs.getString(2),
						rs.getInt(3));
				user.addCourse(course);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
}
