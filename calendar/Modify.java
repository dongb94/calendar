package calendar;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;

public class Modify extends JPanel {

	Schedule modified_schedule;
	DB sender;
	Detail d;

	String type_flag;

	private double width;
	private double height;

	JTextField schedule_title = new JTextField();

	JComboBox duration_start_month;
	JComboBox duration_start_date;
	JComboBox duration_end_month;
	JComboBox duration_end_date;
	JComboBox duration_start_time;
	JComboBox duration_end_time;
	JComboBox duration_start_minute;
	JComboBox duration_end_minute;

	JLabel la_title = new JLabel("제목");
	JLabel la_duration = new JLabel("날짜");
	JLabel la_content = new JLabel("내용");
	JLabel la_start1 = new JLabel("시작 ");
	JLabel la_end1 = new JLabel("종료 ");
	JLabel la_time = new JLabel("시간");
	JLabel la_start2 = new JLabel("시작 ");
	JLabel la_end2 = new JLabel("종료 ");

	JTextArea schedule_content = new JTextArea();

	JButton confirm_button = new JButton("확인");

	String du_mon[] = new String[12];
	String du_day[] = new String[31];
	String du_time[] = new String[24];
	String du_minute[] = new String[60];

	String title;
	String date;
	String duration;
	String content;
	String start_mon;
	String start_day;
	String end_mon;
	String end_day;
	String start_time;
	String start_minute;
	String end_time;
	String end_minute;
	String year = "2017";

	int send_count;

	Modify(Detail d) {

		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		width = res.width * 0.8;
		height = res.height * 0.8;
		width = width * 0.3;
		height = height * 0.82;

		this.d = d;
		setLayout(null);

		this.setBackground(new Color(0, 0, 0, 150));

		for (int i = 1; i < 13; i++)
			du_mon[i - 1] = Integer.toString(i) + "월";
		for (int i = 1; i < 32; i++)
			du_day[i - 1] = Integer.toString(i) + "일";
		for (int i = 0; i < 24; i++)
			du_time[i] = Integer.toString(i) + "시";
		for (int i = 0; i < 60; i++)
			du_minute[i] = Integer.toString(i) + "분";

		duration_start_month = new JComboBox(du_mon);
		duration_start_date = new JComboBox(du_day);
		duration_end_month = new JComboBox(du_mon);
		duration_end_date = new JComboBox(du_day);
		duration_start_time = new JComboBox(du_time);
		duration_end_time = new JComboBox(du_time);
		duration_start_minute = new JComboBox(du_minute);
		duration_end_minute = new JComboBox(du_minute);
		
		if(type_flag == "mod"){
		
		title = modified_schedule.getTitle();
		String date_string = modified_schedule.getDate();
		String date_piece[] = date_string.split(".");
		content = modified_schedule.getContents();
		
		schedule_content.setText(content);
		schedule_title.setText(title);
		duration_start_month.setSelectedIndex(Integer.parseInt(date_piece[1])-1);
		duration_start_date.setSelectedIndex(Integer.parseInt(date_piece[2])-1);
		duration_end_month.setSelectedIndex(Integer.parseInt(date_piece[3])-1);
		duration_end_date.setSelectedIndex(Integer.parseInt(date_piece[4])-1);
		duration_start_time.setSelectedIndex(Integer.parseInt(date_piece[5]));
		duration_start_minute.setSelectedIndex(Integer.parseInt(date_piece[6]));
		duration_end_time.setSelectedIndex(Integer.parseInt(date_piece[7]));
		duration_end_minute.setSelectedIndex(Integer.parseInt(date_piece[8]));
		
		}
		
		// x y w h
		confirm_button.setBounds((int) width * 200 / 300, (int) height / 80, (int) width * 90 / 300, (int) height / 13);
		la_title.setBounds((int) width / 30, (int) height / 16, (int) width / 10, (int) height * 30 / 800);
		schedule_title.setBounds((int) width / 30, (int) height / 10, (int) width * 28 / 30, (int) height * 30 / 800);
		la_duration.setBounds((int) width * 10 / 300, (int) height * 110 / 800, (int) width * 30 / 300,
				(int) height * 30 / 800);
		la_start1.setBounds((int) width * 10 / 300, (int) height * 140 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		duration_start_month.setBounds((int) width * 40 / 300, (int) height * 140 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		duration_start_date.setBounds((int) width * 100 / 300, (int) height * 140 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		la_end1.setBounds((int) width * 150 / 300, (int) height * 140 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		duration_end_month.setBounds((int) width * 180 / 300, (int) height * 140 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		duration_end_date.setBounds((int) width * 240 / 300, (int) height * 140 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		la_time.setBounds((int) width * 10 / 300, (int) height * 170 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		la_start2.setBounds((int) width * 10 / 300, (int) height * 200 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		duration_start_time.setBounds((int) width * 40 / 300, (int) height * 200 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		duration_start_minute.setBounds((int) width * 100 / 300, (int) height * 200 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		la_end2.setBounds((int) width * 150 / 300, (int) height * 200 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		duration_end_time.setBounds((int) width * 180 / 300, (int) height * 200 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		duration_end_minute.setBounds((int) width * 240 / 300, (int) height * 200 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		la_content.setBounds((int) width * 10 / 300, (int) height * 230 / 800, (int) width * 50 / 300,
				(int) height * 30 / 800);
		schedule_content.setBounds((int) width * 10 / 300, (int) height * 270 / 800, (int) width * 280 / 300,
				(int) height * 500 / 800);
		// 300 * 800

		add(confirm_button);
		add(la_title);
		add(schedule_title);
		add(la_duration);
		add(la_start1);
		add(duration_start_month);
		add(duration_start_date);
		add(la_end1);
		add(duration_end_month);
		add(duration_end_date);
		add(la_time);
		add(la_start2);
		add(duration_start_time);
		add(duration_start_minute);
		add(la_end2);
		add(duration_end_time);
		add(duration_end_minute);
		add(la_content);
		add(schedule_content);

		confirm_button.addActionListener(new ConfirmAction());

	}

	public void set_modify() {

		this.type_flag = "mod";
	}

	public void set_create() {

		this.type_flag = "cre";
	}
	public void set_schedule(Schedule schedule){
		this.modified_schedule = schedule;
		set_modify();
	}

	class ConfirmAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			title = schedule_title.getText();
			content = schedule_content.getText();
			start_mon = (String) duration_start_month.getSelectedItem();
			start_mon = start_mon.replace("월", "");
			start_day = (String) duration_start_date.getSelectedItem();
			start_day = start_day.replace("일", "");
			end_mon = (String) duration_end_month.getSelectedItem();
			end_mon = end_mon.replace("월", "");
			end_day = (String) duration_end_date.getSelectedItem();
			end_day = end_day.replace("일", "");
			start_time = (String) duration_start_time.getSelectedItem();
			start_time = start_time.replace("시", "");
			start_minute = (String) duration_start_minute.getSelectedItem();
			start_minute = start_minute.replace("분", "");
			end_time = (String) duration_end_time.getSelectedItem();
			end_time = end_time.replace("시", "");
			end_minute = (String) duration_end_minute.getSelectedItem();
			end_minute = end_minute.replace("분", "");

			int start_date = Integer.parseInt(start_mon + start_day);
			int end_date = Integer.parseInt(end_mon + end_day);
			int start_mon_int = Integer.parseInt(start_mon);
			int end_mon_int = Integer.parseInt(end_mon);
			int start_day_int = Integer.parseInt(start_day);
			int end_day_int = Integer.parseInt(end_day);
			int year_int = Integer.parseInt(year);

			int mon_count = end_mon_int - start_mon_int;
			int temp_mon = start_mon_int;
			int temp_start_day = start_day_int;

			if (start_mon_int > end_mon_int) {

			} // 기간 범위는 1년 한정 아닐시 DB작업 NO
			else {
				if (start_day_int == end_day_int && start_mon_int == end_mon_int) {
					send_count = 1;
				} else {
					if (start_mon_int == end_mon_int)
						send_count = end_day_int - start_day_int + 1;
					else {
						for (int i = 0; i < mon_count; i++) {
							if (start_mon_int == 1 || start_mon_int == 3 || start_mon_int == 5 || start_mon_int == 7
									|| start_mon_int == 8 || start_mon_int == 10 || start_mon_int == 12) {
								start_day_int = 31 - start_day_int + 1;
							} else if (start_mon_int == 4 || start_mon_int == 6 || start_mon_int == 9
									|| start_mon_int == 11) {
								start_day_int = 30 - start_day_int + 1;
							} else {
								if (year_int % 4 == 0 && year_int % 100 != 0 || year_int % 400 == 0)
									start_day_int = 29 - start_day_int + 1;
								else
									start_day_int = 28 - start_day_int + 1;
							}
							send_count = send_count + start_day_int;
							start_day_int = 0;
						}
					}
					send_count = send_count + end_day_int;

				}
				start_day_int = temp_start_day;
				start_mon_int = temp_mon;
				if (Integer.parseInt(start_time) < 10)
					start_time = "0" + start_time;
				if (Integer.parseInt(start_minute) < 10)
					start_minute = "0" + start_minute;
				if (Integer.parseInt(end_time) < 10)
					end_time = "0" + end_time;
				if (Integer.parseInt(end_minute) < 10)
					end_minute = "0" + end_minute;

				while (send_count > 0) {

					date = year + "." + start_mon.toString() + "." + start_day.toString() + "." +end_mon.toString() + "."+ end_day.toString()
					+ "." +start_time + "." + start_minute + "." + end_time + "." + end_minute;
					modified_schedule = new Schedule(title, date, content);
					
					try {
						if(type_flag =="cre")
						new DB(modified_schedule).ADDWEBDB(modified_schedule);
						else
							// update
							;
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					start_day_int++;
					if (year_int % 4 == 0 && year_int % 100 != 0 || year_int % 400 == 0) {
						if (start_mon_int == 2 && start_day_int == 29) {
							start_day_int = 1;
							start_mon_int++;
						}
					} else {
						if (start_mon_int == 2 && start_day_int == 28) {
							start_day_int = 1;
							start_mon_int++;
						}
					}
					if ((start_mon_int == 4 || start_mon_int == 6 || start_mon_int == 9 || start_mon_int == 11)
							&& start_day_int == 30) {
						start_day_int = 1;
						start_mon_int++;
					}
					if ((start_mon_int == 1 || start_mon_int == 3 || start_mon_int == 5 || start_mon_int == 7
							|| start_mon_int == 8 || start_mon_int == 10 || start_mon_int == 12)
							&& start_day_int == 31) {
						start_day_int = 1;
						start_mon_int++;
					}
					start_day_int++;
					send_count--;
				}

			} // 기간 범위가 1년

			d.change("scheduleList");
			set_create();
		}

	}

}

