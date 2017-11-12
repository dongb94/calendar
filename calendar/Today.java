package calendar;
/* Version 1.0
 * ****************************
 * �����ۼ���	2017.11.09 11:30
 * �ۼ���		������
 * ****************************
 * ������		2017.11.13 02:31
 * ��������	Ŭ���� �Լ� �� ������ ����
 * �ۼ���		������
 * ****************************
 */


import java.awt.Color;
import java.awt.Font;
/**ȭ�� ������ ��� ����ð��� �����ִ� Ŭ����*/
import java.util.Date;

import javax.swing.*;
import javax.swing.event.*;

public class Today extends JPanel implements Runnable{
	private Date d;
	private JLabel now;
	Today(){
		d =new Date();
		makeGUI();
		updateText();
	}
	private void makeGUI(){
		now = new JLabel();
		Font f = now.getFont();
		f = new Font(f.getFamily(), f.getStyle(), 20);
		now.setFont(f);
		add(now);
		
		setVisible(true);
	}
	private void updateText(){
		now.setSize(getSize());
		String time = null;
		if(d.getHours()<10)
			time = "0"+d.getHours(); 
		else
			time = ""+d.getHours();

		if(d.getMinutes()<10)
			time += ":0"+d.getMinutes();
		else
			time += ":"+d.getMinutes();
		
		if(d.getSeconds()<10)
			time += ":0"+d.getSeconds();
		else
			time += ":"+d.getSeconds();
		
		now.setText((d.getYear()+1900)+"."+(d.getMonth()+1)+"."+d.getDate()+"("+d.toString().substring(0,3)+")"+" "+time);
	}
	public void run() {
		while(true){
			updateText();
			repaint();
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				System.err.println(e);
			}
		}
	}
}
