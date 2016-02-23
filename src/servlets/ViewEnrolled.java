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
@WebServlet("/student/view_enrolled")
public class ViewEnrolled extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEnrolled() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		
		User user = userDAO.getInfo(SecurityUtils.getSubject().getPrincipal().toString());
		
		CourseDAO courseDAO = new CourseDAO();

		List<Course> courses = courseDAO.getEnrolledofUser(Integer.parseInt(user.getId()));

		request.setAttribute("courses", courses);
		
		System.out.println("a");

		request.getRequestDispatcher("/WEB-INF/student/view_enrolled.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
