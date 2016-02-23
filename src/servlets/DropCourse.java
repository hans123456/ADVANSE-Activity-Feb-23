package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;

import models.CourseDAO;

/**
 * Servlet implementation class EnrollCourse
 */
@WebServlet("/student/drop_course")
public class DropCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DropCourse() {
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

			String id_num = SecurityUtils.getSubject().getPrincipal().toString();

			boolean result = courseDAO.checkIfEnrolledInCourseQuery(courseCode, id_num);

			if (!result) {
				response.getWriter().println("Error, Not Enrolled in " + courseCode + ".");
				break outer;
			}

			courseDAO.dropCourse(courseCode, id_num);
			response.getWriter().println("Hooray, Dropped " + courseCode + "!");

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
