package demo.webservice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class SessionTestServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        this.doPost(req, resp);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    if("admin".equals(username) && "pass".equals(password)){
	        session.setAttribute("login", true);
	        response.sendRedirect("hello.jsp");
	    }else{
	        response.sendRedirect("index.jsp");
	    }
	}

}
