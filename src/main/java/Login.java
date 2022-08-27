

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Beans;
import project.DataBase;

/**
 * 
 * @projectName project_comment
 * @className Login
 * @author allen
 * @date 2022年8月27日 下午1:55:37
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	ServletConfig scf;
	public void init(ServletConfig scf) throws ServletException {
		super.init(scf);
		this.scf= scf;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account= request.getParameter("account");
		String passwd= request.getParameter("passwd");
		var beans= new Beans();
		beans.setAccount(account);
		beans.setPasswd(passwd);
		var dataBase= new DataBase();
		String id=dataBase.login(beans);
		var session= request.getSession();
		var context= scf.getServletContext();
		if(id.equals("member")) {
			session.setAttribute("account", account);
			session.setAttribute("passwd", passwd);
			context.setAttribute("account", account);
			context.setAttribute("passwd", passwd);
			response.sendRedirect("Member.jsp");
		} else {
			response.sendRedirect("Login.html");
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
