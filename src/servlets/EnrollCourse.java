package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

import models.Course;
import models.CourseDAO;
import models.UserDAO;

/**
 * Servlet implementation class EnrollCourse
 */
@WebServlet("/student/enroll_course")
public class EnrollCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnrollCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		outer: try {

			CourseDAO courseDAO = new CourseDAO();

			String courseCode = request.getParameter("course_code");

			if (!courseDAO.checkIfCourseExist(courseCode)) {
				response.getWriter().println("Course Code Invalid.");
				break outer;
			}

			Course course = courseDAO.getCourseInfo(courseCode);

			UserDAO userDAO = new UserDAO();

			String id_num = SecurityUtils.getSubject().getPrincipal().toString();
			float currentNumberOfUnits = userDAO.getCurrentNumberOfUnits(id_num);

			if (course.getEnrolledStudents() == course.getMaxStudents()) {
				response.getWriter().println("Error, Course is Full.");
				break outer;
			}

			if (course.getUnits() + currentNumberOfUnits > 9) {
				response.getWriter().println("Error, Max Number of Possible Units Will Be Exceeded.");
				break outer;
			}

			boolean result = courseDAO.enrollCourse(courseCode, id_num);

			if (!result) {
				response.getWriter().println("Error, Already Enrolled In The Course.");
				break outer;
			} else {
				response.getWriter().println("Hooray, Enrolled in " + courseCode + "!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
