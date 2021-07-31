package DBconnection;

public class MovieVO {
	
	//유저관련
	private String id;
	private String pwd;
	private String name;
	private String birth;
	private String email;
	private String tel;
	private int point;
	private int pt_ticket;
	private String rank;
	private int accum_points;
	
	//영화 관련
	private int movie_code;
	private int age_limit;
	private String mname;
	private String genre;
	private String release_date;
	private String end_date;
	private int run_time;
	private String m_distributor;
	private String img_addr;
	private String summary;
	private int movie_round;
	private int grade;
	private int mvp;
	
	//상영관 관련
	private String theater;
	private int seat;
	private String remark;
	
	//스케쥴관련
	private int schedule_code;
	private int round;
	private String set_mdate;
	private String start_time;
	private String set_sdate;
	
	//가격
	private String price_code;
	private int price;
	
	//티켓
	private int ticket_code;
	private String seat_code;
	private int man;
	private String tic_date;
	
	
	
	

	public int getMovie_code() {
		return movie_code;
	}

	public void setMovie_code(int movie_code) {
		this.movie_code = movie_code;
	}

	public int getAge_limit() {
		return age_limit;
	}

	public void setAge_limit(int age_limit) {
		this.age_limit = age_limit;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getRun_time() {
		return run_time;
	}

	public void setRun_time(int run_time) {
		this.run_time = run_time;
	}

	public String getM_distributor() {
		return m_distributor;
	}

	public void setM_distributor(String m_distributor) {
		this.m_distributor = m_distributor;
	}

	public String getImg_addr() {
		return img_addr;
	}

	public void setImg_addr(String img_addr) {
		this.img_addr = img_addr;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getMovie_round() {
		return movie_round;
	}

	public void setMovie_round(int movie_round) {
		this.movie_round = movie_round;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getMvp() {
		return mvp;
	}

	public void setMvp(int mvp) {
		this.mvp = mvp;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPt_ticket() {
		return pt_ticket;
	}

	public void setPt_ticket(int pt_ticket) {
		this.pt_ticket = pt_ticket;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getAccum_points() {
		return accum_points;
	}

	public void setAccum_points(int accum_points) {
		this.accum_points = accum_points;
	}

	public int getSchedule_code() {
		return schedule_code;
	}

	public void setSchedule_code(int schedule_code) {
		this.schedule_code = schedule_code;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public String getSet_mdate() {
		return set_mdate;
	}

	public void setSet_mdate(String set_mdate) {
		this.set_mdate = set_mdate;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getSet_sdate() {
		return set_sdate;
	}

	public void setSet_sdate(String set_sdate) {
		this.set_sdate = set_sdate;
	}

	public String getPrice_code() {
		return price_code;
	}

	public void setPrice_code(String price_code) {
		this.price_code = price_code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTicket_code() {
		return ticket_code;
	}

	public void setTicket_code(int ticket_code) {
		this.ticket_code = ticket_code;
	}

	public String getSeat_code() {
		return seat_code;
	}

	public void setSeat_code(String seat_code) {
		this.seat_code = seat_code;
	}

	public int getMan() {
		return man;
	}

	public void setMan(int man) {
		this.man = man;
	}

	public String getTic_date() {
		return tic_date;
	}

	public void setTic_date(String tic_date) {
		this.tic_date = tic_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	// 회원가입 셋
	public void setMember(String id, String pwd, String name, String birth, String tel, String email ) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.email = email;
		this.tel = tel;
   }

	public MovieVO() {
		
	}

}
