import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBCON {
	//����̺�ε�
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("jdbc ����̹� �ε� ����");
			e.printStackTrace();
		}
	}
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url = "jdbc:oracle:thin:@bitcamp4.iptime.org:1521:xe";
	String name = "c##Class02";
	String pwd = "Class02";
	
	public DBCON() {
	}
	
	public void dbconn() {
		try {
			conn = DriverManager.getConnection(url, name, pwd);
		}catch(Exception e) {
			System.out.println("�����ͺ��̼� ���� ����");
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� �ݱ� ����");
			e.printStackTrace();
		}
	}
	

}