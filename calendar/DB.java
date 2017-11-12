package calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
create table( day varchar(100), title varchar(100), contents varchar(100));
���̺� �����ϴ� sql��
*/
public class DB {
	Schedule sch;
	public DB(Schedule sch) {
		this.sch = sch;
	}
	
	static Connection conn;
	
	public void DBINFO() throws Exception {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String dbid = "system";
		String dbpw = "2624";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, dbid, dbpw);
	}

	public int addDaySchedule(Schedule schedule) throws Exception {
		DBINFO();
		PreparedStatement pst = conn.prepareStatement("insert into Calendar values(?,?,?)");
		pst.setString(1, schedule.getDate());
		pst.setString(2, schedule.getTitle());
		pst.setString(3, schedule.getContents());
		int cnt = pst.executeUpdate();
		return cnt;// ���ϰ� int�� ������ �߰� �Ǿ����� cnt>0 �̻��ϰ�쿡 ��� �߰��� �������� �� �� �ִ�.
	}

	public ArrayList<Schedule> getDaySchedule() throws Exception {
		DBINFO();
			
		ArrayList<Schedule> sch_list = new ArrayList<>();
		PreparedStatement pst = conn.prepareStatement("select * from Calendar");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String date = rs.getString(1);
			String title = rs.getString(2);
			String contents = rs.getString(3);
			sch_list.add(new Schedule(date,title,contents));
		}
		return sch_list;

	}
}
