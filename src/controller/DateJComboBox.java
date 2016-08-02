package controller;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;

class DateJComboBox{
	
	//JComboBox ����
	JComboBox<String> comboYear,comboMonth,comboDay;
	
	//��¥�迭 ����
	ArrayList<String> yearArray; // �⵵
	ArrayList<String> monthArray; // ��
	ArrayList<String> dayArray; // ��
	
	Calendar oCalendar = Calendar.getInstance( );  // ���� ��¥/�ð� ���� ���� ���� ���
	
	//���� ��¥
	int curYear = oCalendar.get(Calendar.YEAR);
	int curMonth = oCalendar.get(Calendar.MONTH) + 1;
	int curDay = oCalendar.get(Calendar.DAY_OF_MONTH);
	
	// �⵵
	public JComboBox<String> getYear(){
		yearArray = new ArrayList<String>();
		
		//������� -100�����
		for(int i = curYear; i>= curYear -100; i--){
			yearArray.add(String.valueOf(i));
		}  
		comboYear= new JComboBox<String>(yearArray.toArray(new String[yearArray.size()]));
		comboYear.setSelectedItem(String.valueOf(curYear));
		
		return comboYear;
	}

	//��
	public JComboBox<String> getMonth(){
		monthArray = new ArrayList<String>();
		
		for(int i = 1; i <= 12; i++){
			monthArray.add(addZeroString(i));
		}  
		comboMonth = new JComboBox<String>(monthArray.toArray(new String[monthArray.size()]));
		String mcom = curMonth >= 10?String.valueOf(curMonth):"0"+curMonth;
		comboMonth.setSelectedItem(mcom);

		return comboMonth;
	}
	
	//��
	public JComboBox<String> getDay(){
		dayArray = new ArrayList<String>();
	
		for(int i = 1; i <= 31; i++){
			dayArray.add(addZeroString(i));
		}  
		comboDay = new JComboBox<String>(dayArray.toArray(new String[dayArray.size()]));
		String dcom = curDay >= 10?String.valueOf(curDay):"0"+curDay;
		comboDay.setSelectedItem(dcom);
		return comboDay;
	}
	
	//���ڸ� ���� �տ� + 0 ��) 7�� -> 07�� 
	private String addZeroString(int k){
	     String value=Integer.toString(k);
	     if(value.length()==1) {
	      value="0"+value;
	     }
	     return value;
	}
}