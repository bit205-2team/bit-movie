package DBconnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReservationDAO extends DBCON{

	public List<MovieVO> selectMovie(){
	
		List<MovieVO> movieList  = new ArrayList<MovieVO>();
		
		try {
			dbConn();
			
			String sql = "select mname from movie";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setMname(rs.getString(1));
				movieList.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println("��ȭ ��� ��ȸ ����");
			e.printStackTrace();
		}finally {
			dbClose();
		}
	
		return movieList;
	}
	//���õ� ��ȭ�� ��¥�� �󿵰�������
	public List<MovieVO> setMovieTheater(String movieName, String movieDate){
		List<MovieVO> theaterList = new ArrayList<MovieVO>();
		try {
			dbConn();
			String sql = "select s.theater, s.start_time, to_char(s.set_mdate, 'DY/DD') from mschedule s join movie m on s.movie_code = m.movie_code\r\n"
					+ "where mname=? and to_char(s.set_mdate, 'DD')=?";
			System.out.println("����?");
			System.out.println(movieName);
			System.out.println(movieDate);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieName);
			pstmt.setString(2, movieDate);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setTheater(rs.getString(1));
				theaterList.add(vo);
				System.out.println(vo.getTheater());
			}
			
		}catch(Exception e) {
			System.out.println("�󿵰� ��ȸ ����");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return theaterList;
		
	}
	public List<MovieVO> setMovieTime(String movieName, String movieDate){
		List<MovieVO> timeList = new ArrayList<MovieVO>();
		try {
			dbConn();
			String sql = "select s.theater, s.start_time, to_char(s.set_mdate, 'DY/DD') from mschedule s join movie m on s.movie_code = m.movie_code\r\n"
					+ "where mname=? and to_char(s.set_mdate, 'DD')=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movieName);
			pstmt.setString(2, movieDate);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("���� �� �ȿ��ı�..");
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));

				MovieVO vo = new MovieVO();
				vo.setStart_time(rs.getString(2));
				timeList.add(vo);
				System.out.println(vo.getStart_time());
				
			}
			
		}catch(Exception e) {
			System.out.println("�󿵰� ��ȸ ����");
			e.printStackTrace();
			
		}finally {
			dbClose();
		}
		return timeList;
		
	}
	public String thrwoScheuleCode(String movieName, String movieDate, String movieTime) {
		String code = null;
		try {
	
			dbConn();
			String sql = "select s.schedule_code from mschedule s join movie m on s.movie_code = m.movie_code"
					+"where mname=? and start_time=? and to_char(s.set_mdate, 'DD')=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, movieName);
			pstmt.setString(2, movieDate);
			pstmt.setString(3, movieTime);
			rs = pstmt.executeQuery();
			code = rs.getString(1);
		}catch(Exception e) {
			System.out.println("���� ���� ����");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return code;
	}

	
}
