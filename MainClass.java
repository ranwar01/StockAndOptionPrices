//import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainClass {
	
	static URLConnection myURLConnection;
	static HttpsURLConnection conn;
	static BufferedReader in;
	static String symbol ="amd";
//	JSONObject myResponse;
	static String inputLine;
//	static StringBuffer response = new StringBuffer();
	static StringBuffer response;
	static String [] symbols = {"amd","snap","fcx", "aapl"};

	
	public static void main (String [] args) throws JSONException{
		
//		MainGuiWindow mgw = new MainGuiWindow();
		for (int i = 0; i< symbols.length; i++){
		
		try {
			
		    URL myURL = new URL("https://api.iextrading.com/1.0/stock/" + symbols[i] + "/quote");
		    System.out.println(symbols[i]);
		    conn = (HttpsURLConnection) myURL.openConnection();
//		    myURLConnection = myURL.openConnection();
		    conn.setRequestMethod("GET");
		} 
		catch (MalformedURLException e) { 
		    // new URL() failed
		    // ...
		} 
		catch (IOException e) {   
		    // openConnection() failed
		    // ...
		}
		try {
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
			while ((inputLine = in.readLine()) != null) {
				response = new StringBuffer();
				response.append(inputLine);
			    System.out.println(inputLine);
			    
			    JSONObject myResponse = new JSONObject(response.toString());
			 	System.out.println("My Response: " + myResponse);
		    	System.out.println(myResponse.get("symbol"));
		    	System.out.println(myResponse.get("iexRealtimePrice"));
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	JSONObject myResponse = new JSONObject(response.toString());
//      	JSONObject myResponse2 = new JSONObject(inputLine.toString());
//    	System.out.println("My Response: " + myResponse);
//    	System.out.println(myResponse.get("symbol"));
//    	System.out.println(myResponse2.get("symbol"));
//    	System.out.println(myResponse.get());
//    	 JSONArray results = myResponse.getJSONArray("companyName");
//    	 System.out.println("Results: " + results);
    	
//        try {
//        	String name = (String) myResponse.get("sector");
//			System.out.println(name);
//		} catch (JSONException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//        try {
//			JSONObject obj = new JSONObject(response.toString());
//		} catch (JSONException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
        try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
        
//		try {
//			myResponse = new JSONObject(inputLine.toString());
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println(inputLine.toString());
		 final MainClass sampleSuite = new MainClass();
//		 MainGuiWindow gui = new MainGuiWindow();
		 

	 
		
	
		
	}
    

}
