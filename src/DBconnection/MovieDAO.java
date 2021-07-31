package DBconnection;

import java.util.ArrayList;
import java.util.List;



public class MovieDAO extends DBCON {
	
	public MovieDAO() {
		
		
	}
	
	// ȸ�� ���̵� ã��
	public List<MovieVO> selectID() {
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			
			//1.db����
			dbConn();
			String sql = "select mem_no, username, tel, email, addr, "
					+ "to_char(write_date,'YYYY-MM-DD') write_date from member order by username asc";
			//2. preparestatement����
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO vo = new MovieVO();
//				vo.setMem_no(rs.getInt(1));
//				vo.setUsername(rs.getNString(2));
//				vo.setTel(rs.getString(3));
//				vo.setEmail(rs.getString(4));
//				vo.setAddr(rs.getString(5));
//				vo.setWrite_date(rs.getString(6));
				list.add(vo);
				
				
			}
		}catch(Exception e) {
			System.out.println("��üȸ������ ���� �߻�");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	
	//ȸ�� ���̵� �ߺ� �˻�
	public boolean idSelect(String id) {
		
		String rc = null;
		boolean idcheck = false;
		String id1 = null;
		try {
			
			dbConn();
			id1 = id;
			id = "select id from muser where id ="+"'"+id+"'";
			String sql = id;
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rc = rs.getString(1);
			}
			
			if(id1.equals(rc)) idcheck = true;
		
		}catch(Exception e) {
			System.out.println("ȸ�� �˻� ���� �߻�");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		

		return idcheck;
	}
	
	
	// ȸ���߰�
	public int insertRecord(MovieVO vo) {
		
		int cnt=0;
		
		try {
			
			dbConn();
			
			String sql = "INSERT INTO muser values(?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,0,0,'GOLD',0,TO_DATE('2021-07-03','YYYY-MM-DD'))";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getUser_id());
			pstmt.setString(2, vo.getUser_password());
			pstmt.setString(3, vo.getUser_name());
			pstmt.setString(4, vo.getUser_birth());
			pstmt.setString(5, vo.getUser_tel());
			
			cnt = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("ȸ���߰����� �߻�");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	// ȸ������               ��ȣ,����ó,�̸���,�ּ�
	public int updateRecord(MovieVO vo) {
		int cnt=0;
		try {
			dbConn();
			
			String sql = "update member set tel=?, email=?, addr=? where mem_no=?";
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getTel());
//			pstmt.setString(2, vo.getEmail());
//			pstmt.setString(3, vo.getAddr());
//			pstmt.setInt(4, vo.getMem_no());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("ȸ������ ���� �߻�");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	
	// �˻�
	public List<MovieVO> searchRecord(String search, String fieldName) {
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			dbConn();
			
			String sql = "select mem_no, username, tel, email, addr, to_char(write_date, 'YYYY-MM-DD') write_date"
					+ " from member where "+fieldName+" like ? order by username asc";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");	//%��%
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieVO vo = new MovieVO();
//				vo.setMem_no(rs.getInt(1));
//				vo.setUsername(rs.getString(2));
//				vo.setTel(rs.getString(3));
//				vo.setEmail(rs.getString(4));
//				vo.setAddr(rs.getString(5));
//				vo.setWrite_date(rs.getString(6));
				list.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println("ȸ���˻�����");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
}

