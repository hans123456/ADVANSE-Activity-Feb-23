package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO extends DAO {
	private static final String getCourses = "select output.course_code, output.units, output.max_students, output.id, count(output.count) from ( "
			+ "select courses.course_code, courses.units, courses.max_students, courses.id, enrollment.course_id as count "
			+ "from courses left join enrollment on courses.id = enrollment.course_id) as output "
			+ "group by output.id;";

	private static final String getEnrolled = "select courses.id, courses.course_code, courses.units, enrollment.user_id "
			+ "from enrollment inner join courses on enrollment.course_id = courses.id "
			+ "where enrollment.user_id = ?";

	public List<Course> getCourses() {
		List<Course> courses = new ArrayList();
		try {
			con = getConnection();
			ps = con.prepareStatement(getCourses);
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course(rs.getInt(4), rs.getString(1),
						rs.getInt(2), rs.getInt(3), rs.getInt(5));
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

	public List<Course> getEnrolledofUser(int id) {
		List<Course> courses = new ArrayList();
		try {
			con = getConnection();
			ps = con.prepareStatement(getEnrolled);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course(rs.getInt(1), rs.getString(2),
						rs.getInt(3));
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
}
