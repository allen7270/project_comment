

import java.io.IOException;
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
 * @className Register
 * @author allen
 * @date 2022年8月27日 下午1:36:27
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// get data from front
		String account= request.getParameter("account");
		String passwd= request.getParameter("passwd");
		String mail= request.getParameter("mail");
		String phone= request.getParameter("phone");
		// set data
		var beans= new Beans(account, passwd, mail, phone);
		var dataBase= new DataBase();
		// register
		dataBase.register(beans);
		response.sendRedirect("Login.html");
	}

}
