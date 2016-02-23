package models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO extends DAO{
	private static final String query = "SELECT * FROM advanse.courses";
	
	public List<Course> getCourses() {
		List<Course> courses = new ArrayList();
		try {
			con = getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				Course course= new Course(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				courses.add(course);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (rs != null) rs.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return courses;
	}
}
