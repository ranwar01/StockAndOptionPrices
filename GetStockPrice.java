import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetStockPrice {
	
	public static final String APIADDRESS = "https://api.iextrading.com/1.0";
	private String stock = "/stock/";

	URL url;
	HttpsURLConnection conn;
	BufferedReader in;
	String inputLine;
	StringBuffer response;
	JSONObject myResponse;

	public HashMap <String, String> hm;
	public LinkedList<String> ll;


	
	// takes in a string value
	public void returnStockPrice(String stockName) throws IOException, JSONException{
		
		url = new URL(GetStockPrice.APIADDRESS + stock  + stockName + "/quote");

//		url = new URL(GetStockPrice.APIADDRESS + stock  + "market/list/gainers");
		System.out.println("Url is: - " + url);
		
		conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		response = new StringBuffer();
		
        try {
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}	
		} catch (IOException e) {

			e.printStackTrace();
		}
        
        myResponse = new JSONObject(response.toString());

	
		loopingThrough();
//		printValues();
		
	}
	
	

	public void loopingThrough() throws JSONException{

		hm = new HashMap<String,String>();
		ll = new LinkedList<String>();

		for(Iterator iterator = myResponse.keys(); iterator.hasNext();) {
		    String key = (String) iterator.next();
		    ll.add(key);
		    hm.put(key, myResponse.get(key).toString());
		    System.out.println(key + "    value is:  " + myResponse.get(key));
		}
		
	}
	
	public  void getMostGained() throws MalformedURLException, IOException, JSONException  {
		
		url = new URL(GetStockPrice.APIADDRESS + "/stock/market/list/gainers");

//		url = new URL(GetStockPrice.APIADDRESS + stock  + "market/list/gainers");
		System.out.println("Url is: - " + url);
		
		conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		response = new StringBuffer();
		
        try {
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
				System.out.println(response);
			}	
		} catch (IOException e) {

			e.printStackTrace();
		}
        myResponse = new JSONObject(response.toString());
//        System.out.println("myResponse is " + myResponse);
    	
//		loopingThrough();
        
//        myResponse = new JSONObject(response.toString());	
//        return null;
	}
	
	public void callMyMethod(String stockName){
		try {
			this.returnStockPrice(stockName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public LinkedList<String> getFields(){
		
		return ll;
		
	}
	public String printValues(String key){
		
		System.out.println("Key is: " + key);
		if (hm.containsKey(key)) {
			System.out.println("Key is: " + key + " value is: " + hm.get(key));
			return hm.get(key);	
		}
		System.out.println("returning null");
		return null;
		
		
		
	}
	public String getValue(String key) throws JSONException{
		return myResponse.get(key).toString();
	}
	
	public String getCompanyName() throws JSONException{
		System.out.println(myResponse.get("companyName"));
		return  myResponse.get("companyName").toString();
	}
	
	public String getFiftyTwoWeekLow() throws JSONException{
		System.out.println(myResponse.get("week52Low"));
		return  myResponse.get("week52Low").toString();
	}
	
	public String getFiftyTwoWeekHigh() throws JSONException{
		System.out.println(myResponse.get("week52High"));
		return  myResponse.get("week52High").toString();
	}
	
	public String getPriceEarningsRatio() throws JSONException{
		System.out.println(myResponse.get("peRatio"));
		return  myResponse.get("peRatio").toString();
	}
	
	public String getAverageTotalVolume() throws JSONException{
		System.out.println(myResponse.get("avgTotalVolume"));
		return  myResponse.get("avgTotalVolume").toString();
	}
	

	
	
	
	

}
