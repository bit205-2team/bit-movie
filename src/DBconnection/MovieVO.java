package DBconnection;

public class MovieVO {
	
	private String user_id;
	private String user_password;
	private String user_name;
	private String user_birth;
	private String user_email;
	private String user_tel;
	

// 회원가입 셋
	public void setUser_Member(String User_id, String User_password, String User_name, String User_birth, String User_tel, String User_email ) {
		this.user_id = User_id;
		this.user_password = User_password;
		this.user_name = User_name;
		this.user_birth = User_birth;
		this.user_email = User_email;
		this.user_tel = User_tel;
		
	}
	
	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	
	public MovieVO() {
		
	}

}
