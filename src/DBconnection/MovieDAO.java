package DBconnection;

import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends DBCON {
	
	public MovieDAO() {

	}
	
	// ȸ����ü����
	public List<MovieVO> allRecord() {
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			//1.db����
			dbConn();
			String sql = "select movie_code, age_limit,mname,genre,to_char(release_date,'YYYY-MM-DD') release_date,"
					+ "to_char(end_date,'YYYY-MM-DD') end_date ,run_time,m_distributor, "
					+ "img_addr,summary, movie_round,grade,mvp from movie order by release_date asc";
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
	
	// ȸ���߰�
	public int insertRecord(MovieVO vo) {
		int cnt=0;
		try {
			dbConn();
			String sql = "insert into member(mem_no, email, addr, username, tel ) values(mem_sq.nextval, ?,?,?,?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getEmail());
//			pstmt.setString(2, vo.getAddr());
//			pstmt.setString(3, vo.getUsername());
//			pstmt.setString(4, vo.getTel());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("ȸ���߰����� �߻�");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	// ȸ������             ��ȣ,����ó,�̸���,�ּ�
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
	
	// ȸ������
	public int deleteRecord(int mem_no) {
		int cnt=0;
		try {
			dbConn();
			String sql = "delete from member where mem_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_no);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("������� ���� �߻�");
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

