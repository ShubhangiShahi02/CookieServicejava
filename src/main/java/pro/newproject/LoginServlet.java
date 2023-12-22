package pro.newproject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("username");
		PrintWriter pt=response.getWriter();
		response.setContentType("text/html");
		if(uname.equals("Shubhangi02")) {
			pt.println("<script>window.alert(\"You Are Login Successfully\");</script>");
			pt.println("<h3 color: white, style=\"text-align:center\" >Welcome to the New Cookie Project</h3>");
			RequestDispatcher rd1=request.getRequestDispatcher("/index.html");
			rd1.include(request,response);
			Cookie ck=new Cookie("na", uname);
			response.addCookie(ck);
		}
		else {
			pt.println("<script>window.alert(\"Id or Password is wrong\");</script>");
			RequestDispatcher rd=request.getRequestDispatcher("/Login.html");
			rd.include(request, response);
			pt.println("<h3 color: white>*******Enter Username or password*******</h3>");
		}
		doGet(request, response);
	}

}
