package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO extends DAO {
	private static final String getCourses = "select output.course_code, output.units, output.max_students, output.id, count(output.count) from ( "
			+ "select courses.course_code, courses.units, courses.max_students, courses.id, enrollment.course_id as count "
			+ "from courses left join enrollment on courses.id = enrollment.course_id) as output "
			+ "group by output.id;";

	private static final String getCourseQuery = "SELECT `course`.`id`, `course`.`course_code`, `course`.`units`, `course`.`max_students`, count(`enrollment`.`course_id`) as `number_of_enrolled_students` "
			+ "FROM (SELECT `courses`.`id`, `course_code`, `units`, `max_students` FROM `courses` WHERE `courses`.`course_code` = ?) as `course` "
			+ "LEFT JOIN `enrollment` ON `course`.`id` = `enrollment`.`course_id`";

	private static final String checkIfCourseExistQuery = "SELECT EXISTS(SELECT 1 FROM `courses` WHERE `courses`.`course_code` = ?) as `result`";

	private static final String enrollCourseQuery = "INSERT INTO `enrollment`(`course_id`, `user_id`) VALUES ("
			+ "(SELECT `id` FROM `courses` WHERE `courses`.`course_code` = ?), "
			+ "(SELECT `id` FROM `users` WHERE `users`.`id_num` = ?))";

	private static final String dropCourseQuery = "DELETE FROM `enrollment` WHERE "
			+ "`enrollment`.`course_id` = (SELECT `id` FROM `courses` WHERE `course_code` = ?) AND "
			+ "`enrollment`.`user_id` = (SELECT `id` FROM `users` WHERE `id_num` = ?)";

	private static final String checkIfEnrolledInCourseQuery = "SELECT EXISTS(SELECT 1 FROM `enrollment` WHERE "
			+ "`enrollment`.`course_id` = (SELECT `id` FROM `courses` WHERE `course_code` = ?) AND"
			+ "`enrollment`.`user_id` = (SELECT `id` FROM `users` WHERE `id_num` = ?)) as `result`";

	private static final String getEnrolled = "select courses.id, courses.course_code, courses.units "
			+ "from enrollment inner join courses on enrollment.course_id = courses.id "
			+ "inner join users on users.id = enrollment.user_id and users.id_num = ?";

	public List<Course> getCourses() {
		List<Course> courses = new ArrayList<Course>();
		try {
			con = getConnection();
			ps = con.prepareStatement(getCourses);
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course(rs.getInt(4), rs.getString(1), rs.getFloat(2), rs.getInt(3), rs.getInt(5));
				courses.add(course);
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
		return courses;
	}

	public List<Course> getEnrolledofUser(String id_num) {
		List<Course> courses = new ArrayList<Course>();
		try {
			con = getConnection();
			ps = con.prepareStatement(getEnrolled);
			ps.setString(1, id_num);
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course(rs.getInt(1), rs.getString(2), rs.getInt(3));
				courses.add(course);
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
		return courses;
	}

	public Course getCourseInfo(String courseCode) {
		Course course = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(getCourseQuery);
			ps.setString(1, courseCode);
			rs = ps.executeQuery();
			if (rs.next()) {
				course = new Course(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5));
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
		return course;
	}

	public boolean checkIfCourseExist(String courseCode) {
		boolean result = false;
		try {
			con = getConnection();
			ps = con.prepareStatement(checkIfCourseExistQuery);
			ps.setString(1, courseCode);
			rs = ps.executeQuery();
			if (rs.next())
				if (rs.getInt(1) == 1)
					result = true;
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
		return result;
	}

	public boolean enrollCourse(String courseCode, String id_num) {
		boolean result = true;
		try {
			con = getConnection();
			ps = con.prepareStatement(enrollCourseQuery);
			ps.setString(1, courseCode);
			ps.setString(2, id_num);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
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
		return result;
	}

	public boolean dropCourse(String courseCode, String id_num) {
		boolean result = true;
		try {
			con = getConnection();
			ps = con.prepareStatement(dropCourseQuery);
			ps.setString(1, courseCode);
			ps.setString(2, id_num);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
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
		return result;
	}

	public boolean checkIfEnrolledInCourseQuery(String courseCode, String id_num) {
		boolean result = false;
		try {
			con = getConnection();
			ps = con.prepareStatement(checkIfEnrolledInCourseQuery);
			ps.setString(1, courseCode);
			ps.setString(2, id_num);
			rs = ps.executeQuery();
			if (rs.next())
				if (rs.getInt(1) == 1)
					result = true;
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
		return result;
	}

}