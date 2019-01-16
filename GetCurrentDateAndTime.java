import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetCurrentDateAndTime {
	
	public static String time;
	public static LocalDateTime now;
	
	public static String getTimeAndDate(){
		
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   now = LocalDateTime.now();  
		   time = dtf.format(now);
//		   System.out.println(dtf.format(now));  
//		   time = dtf.format(now).toString();
		   return time;
	}
	

	
	public static void main(String [] args){
		getTimeAndDate();
		System.out.println(time);
	}

}
