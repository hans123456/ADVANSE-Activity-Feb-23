package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

import models.Course;
import models.CourseDAO;
import models.User;
import models.UserDAO;

/**
 * Servlet implementation class ViewEnrolled
 */
@WebServlet("/student/view_enrolled_courses")
public class ViewEnrolledCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewEnrolledCourses() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CourseDAO courseDAO = new CourseDAO();
		List<Course> courses = courseDAO.getEnrolledofUser(SecurityUtils.getSubject().getPrincipal().toString());
		request.setAttribute("courses", courses);
		request.getRequestDispatcher("/WEB-INF/student/view_enrolled_courses.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
