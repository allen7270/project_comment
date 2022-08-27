

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Beans;
import project.CommentData;
import project.DataBase;

/**
 * Servlet implementation class Comment
 */
@WebServlet("/Comment")
public class Comment extends HttpServlet {
	
	ServletConfig scf;
	public void init(ServletConfig scf) throws ServletException {
		super.init(scf);
		this.scf=scf;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		var context= scf.getServletContext();
		// get data from ServletConfig
		String account= (String)context.getAttribute("account");
		// get data from front
		String url= request.getParameter("url");
		String comment= request.getParameter("comment");
		var dataBase= new DataBase();
		var beans= new Beans();
		// set url, comment by constructor
		var commentData= new CommentData(url, comment);
		// set account
		beans.setAccount(account);
		// post
		dataBase.post(beans, commentData);
		response.sendRedirect("Home.jsp");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
