package project;

public class Beans {
	private String account, passwd, mail, phone;
	public Beans() {
	}
	public Beans(String account, String passwd, String mail, String phone) {
		this.account= account;
		this.passwd= passwd;
		this.mail= mail;
		this.phone= phone;
	}
	public String getAccount() {
		return account;
	}
	public String getPasswd() {
		return passwd;
	}
	public String getMail() {
		return mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
