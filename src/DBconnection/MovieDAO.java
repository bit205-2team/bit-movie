package DBconnection;

import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends DBCON {
	
	public MovieDAO() {

	}
	
	// 영화 전체 선택
	public List<MovieVO> allMovieRecord() {
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			//1.db연결
			dbConn();
			String sql = "select movie_code, age_limit,mname,genre,to_char(release_date,'YYYY-MM-DD') release_date,"
					+ "to_char(end_date,'YYYY-MM-DD') end_date ,run_time,m_distributor, "
					+ "img_addr,summary, movie_round,grade,mvp from movie order by release_date asc";
			//2. preparestatement생성
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				list.add(vo);
				
			}
		}catch(Exception e) {
			System.out.println("전체회워선택 에러 발생");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	
	// 영화포스터정보 가져오기
	public List<MovieVO> moviePoster(int selectNum) {
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		
		try {
			dbConn();
			String sql = "select img_addr, status, mvp, summary, round(grade,2) from movie where status='"+selectNum+"' order by mvp asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setImg_addr(rs.getString(1));
				vo.setStatus(rs.getString(2));
				vo.setMvp(rs.getInt(3));
				vo.setSummary(rs.getString(4));
				vo.setGrade(rs.getDouble(5));
				
				list.add(vo);
				
			}
		}catch(Exception e) {
			System.out.println("영화포스터 정보 가져오기 에러 발생");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	
	

	public boolean login(String id, String pwd) {
	      String idrc = null;
	      String pwdrc = null;
	      boolean logincheck = false;
	      try {
	         dbConn();
	         
	         String idcheck = "select id, pwd from MUSER where id ="+"'"+id+"'";
	         String sql = idcheck;
	         
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            idrc = rs.getString(1);
	            pwdrc = rs.getString(2);
	            
	         }
	         
	         if(idrc.equals(id)&&pwdrc.equals(pwd)) { logincheck = true;};
	         
	      }catch(Exception e) {
	         
	      }finally{
	         dbClose();
	      }
	      
	      return logincheck;
	      
	   }
}

