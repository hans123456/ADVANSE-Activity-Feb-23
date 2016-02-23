package models;

import java.sql.SQLException;

public class UserDAO extends DAO {

	private final static String createQuery = "INSERT INTO `users` (`id`, `role_id`, `name`, `id_num`, `password`, `datetime_joined`) VALUES (NULL, 1, ?, ?, ?, NOW())";
	private final static String[] createParams = { "name", "id_num", "password" };

	private final static String getQuery = "SELECT `users`.`id`, `roles`.`role`, `name`, `id_num`, `datetime_joined` FROM `roles`, `users` WHERE `id_num` = ? and `role_id` = `roles`.`id`";
	private final static String[] getResult = { "id", "role", "name", "id_num", "datetime_joined" };

	private final static String getCurrentNumberOfUnitsQuery = "SELECT SUM(units) FROM `users`, `courses`, `enrollment` WHERE `users`.`id_num` = ? AND `courses`.`id` = `enrollment`.`course_id` AND `users`.`id` = `enrollment`.`user_id`";
	
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

	public float getCurrentNumberOfUnits(String id_num) {
		float units = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(getCurrentNumberOfUnitsQuery);
			ps.setString(1, id_num);
			rs = ps.executeQuery();
			if (rs.next()) {
				units = rs.getFloat(1);
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
		return units;
	}

}
