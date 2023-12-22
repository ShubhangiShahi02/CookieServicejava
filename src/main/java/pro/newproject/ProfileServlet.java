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
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pt=response.getWriter();
		response.setContentType("text/html");
		Cookie ck[]=request.getCookies();
		if(ck!=null) {
			RequestDispatcher rd1=request.getRequestDispatcher("/index.html");
			rd1.include(request,response);
			pt.println("<h3 color: white, style=\"text-align:center\" >****Welcome to the Profile Servlet****</h3>"+ck[0].getValue());
		}
		else {
			pt.println("<script>window.alert(\"Login to open Profile Servlet\");</script>");
			RequestDispatcher rd2=request.getRequestDispatcher("/Login.html");
			rd2.include(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
