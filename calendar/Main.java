package calendar;
/* Version 1.0
 * ****************************
 * �����ۼ���	2017.11.09 23:30
 * �ۼ���		������
 * ****************************
 * ������		2017.11.10 23:30
 * ��������	Calendar �� Detail Ŭ����  �߰�
 * �ۼ���		������
 * ****************************
 * ������		2017.11.12 23:30
 * ��������	Calendar Ŭ���� ���� -> CalendarPanel
 * 			�ػ󵵿� ���缭 ������ ������ ����, ������ ������ ���� �Ұ����ϵ��� ����
 * �ۼ���		������
 */

/**���� ������*/
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

	private double width;
	private double height;
	Main(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		makeGUI();
		
		setResizable(false);
		setVisible(true);
	}
	
	void makeGUI(){

		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		width = res.width*0.8;
		height = res.height*0.8;
		setSize((int)(width), (int)(height));
		setLocation((int)(width*0.1), (int)(height*0.1));
		setLayout(null);
		
		//set calendar
		CalendarPanel C = new CalendarPanel();
		C.setSize((int)(width*0.7), (int)(height*0.97));
		C.setLocation(0, 0);
		//set today
		Today T = new Today();
		T.setSize((int)(width*0.3), (int)(height*0.17));
		T.setLocation((int)(width*0.7),0);
		Thread thread = new Thread(T);
		thread.start();
		//set detail
		Detail D = new Detail();
		D.setSize((int)(width*0.3), (int)(height*0.80));
		D.setLocation(700, 100);
		
		add(C);
		add(T);
		add(D);
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
