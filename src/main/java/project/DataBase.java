package project;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * 
 * @projectName project_comment
 * @className DataBase
 * @author allen
 * @date 2022年8月27日 下午1:36:17
 */
public class DataBase {
	// Connect to MySQL
	public Statement getConnection() {
		try {
			var con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project_comment","root","allen7270");
			var st= con.createStatement();
			return st;
		} catch (SQLException e) {
			return null;
		}
	}
	// Register 
	public void register(Beans beans) {
		var st= getConnection();
		String sql=String.format("insert into member (account, password, mail, phone) values('%s','%s','%s','%s');", 
				beans.getAccount(), beans.getPasswd(), beans.getMail(), beans.getPhone());
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// login
	public String login(Beans beans) {
		var st= getConnection();
		String account="", passwd="", identity="nonMember";
		String sql= ("select account, password from member");
		try {
			var rs=st.executeQuery(sql);
			while(rs.next()) {
				account= rs.getString("account");
				passwd= rs.getString("password");
				if(account.equals(beans.getAccount())&&passwd.equals(beans.getPasswd())) {
					identity= "member";
					break;
				}
			}
			return identity;
		} catch (SQLException e) {
			return null;
		}
	}
	// show member data
	public ArrayList<String> showData(Beans beans){
		var st= getConnection();
		var data= new ArrayList<String>();
		String sql= String.format("select account, password, mail, phone from member where account='%s' and password='%s';",
				beans.getAccount(), beans.getPasswd());
		try {
			var rs= st.executeQuery(sql);
			while(rs.next()) {
				for(int i=1; i<5; i++) {
					data.add(rs.getString(i));	
				}
			}
			return data;
		} catch (SQLException e) {
			return null;
		}
	}
	// post
	public void post(Beans beans, CommentData commentData) {
		var st= getConnection();
		String sql=String.format("insert into comment (account, url, comment) values('%s', '%s', '%s')",
				beans.getAccount(), commentData.getUrl(), commentData.getComment());
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// home
	public ArrayList<String> home(){
		var st= getConnection();
		var data= new ArrayList<String>();
		String sql= ("SELECT * FROM project_comment.comment;");
		try {
			var rs= st.executeQuery(sql);
			while(rs.next()) {
				data.add(rs.getString("account"));
				data.add(rs.getString("url"));
				data.add(rs.getString("comment"));
			}
			return data;
		} catch (SQLException e) {
			return null;
		}
	}
}


