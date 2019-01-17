import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class EarningsToday {
	public static final String APIADDRESS = "https://api.iextrading.com/1.0/stock/";
	private String symbol = "AAPL";
	///stock/{symbol}/earnings
	private URL url;
	private HttpURLConnection conn;
	StringBuffer response;
	JSONObject myResponse;
	BufferedReader in;
	String inputLine;

	static String json = "...";
	public static void main(String [] args) throws IOException, JSONException {

		EarningsToday et = new EarningsToday();
		et.getEarnings();



	}

	public void getEarnings() throws IOException, JSONException {


		url = new URL(EarningsToday.APIADDRESS+ symbol + "/earnings");
		System.out.println("Url is: "+ url);

		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		int code;
		code = conn.getResponseCode();

		System.out.println(code);
		Scanner sc = new Scanner(url.openStream());
		while (sc.hasNext()) {
			inputLine +=sc.nextLine();
		}
		System.out.println("\nJSon data in string");
		System.out.println(inputLine);
		sc.close();
		
		JSONParser parse = new JSONParser();
//		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//		response = new StringBuffer();
//
//		try {
//			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}	
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//
//		myResponse = new JSONObject(response.toString());
//		JSONObject obj = new JSONObject(json);
//		
//	    String pageName = myResponse.getJSONObject("symbol");
//	    
//	   
//
//        System.out.println(pageName);
//		System.out.println(myResponse);




	}
}
