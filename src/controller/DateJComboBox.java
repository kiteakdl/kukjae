package controller;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;

class DateJComboBox{
	
	//JComboBox 선언
	JComboBox<String> comboYear,comboMonth,comboDay;
	
	//날짜배열 선언
	ArrayList<String> yearArray; // 년도
	ArrayList<String> monthArray; // 월
	ArrayList<String> dayArray; // 일
	
	Calendar oCalendar = Calendar.getInstance( );  // 현재 날짜/시간 등의 각종 정보 얻기
	
	//현재 날짜
	int curYear = oCalendar.get(Calendar.YEAR);
	int curMonth = oCalendar.get(Calendar.MONTH) + 1;
	int curDay = oCalendar.get(Calendar.DAY_OF_MONTH);
	
	// 년도
	public JComboBox<String> getYear(){
		yearArray = new ArrayList<String>();
		
		//현재부터 -100년까지
		for(int i = curYear; i>= curYear -100; i--){
			yearArray.add(String.valueOf(i));
		}  
		comboYear= new JComboBox<String>(yearArray.toArray(new String[yearArray.size()]));
		comboYear.setSelectedItem(String.valueOf(curYear));
		
		return comboYear;
	}

	//월
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
	
	//일
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
	
	//한자리 숫자 앞에 + 0 예) 7일 -> 07일 
	private String addZeroString(int k){
	     String value=Integer.toString(k);
	     if(value.length()==1) {
	      value="0"+value;
	     }
	     return value;
	}
}