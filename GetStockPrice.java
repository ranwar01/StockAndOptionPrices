import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetStockPrice {
	
	public static final String APIADDRESS = "https://api.iextrading.com/1.0";
	String s = "/stock/";
//	String nameOfStockToSearch = "a";
	URL url;
	HttpsURLConnection conn;
	BufferedReader in;
	String inputLine;
	StringBuffer response;
	JSONObject myResponse;
	JSONObject newj;
	JSONArray ar;

	
	
	public void returnStockPrice(String stockName) throws IOException, JSONException{
		url = new URL(GetStockPrice.APIADDRESS + s  + stockName + "/quote");
		System.out.println(url);
		conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		response = new StringBuffer();
        try {
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			    System.out.println(inputLine);
//			    newj = new JSONObject(response);
//			 	System.out.println("My Response: " + myResponse);
//		    	System.out.println(myResponse.get("symbol"));
//		    	System.out.println(myResponse.get("iexRealtimePrice"));
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        myResponse = new JSONObject(response.toString());
        newj = new JSONObject(response.toString());
//        ar = new JSONArray(response.toString());
//        ar = new JSONArray(response.toString());
//        System.out.println(ar.toString() + "array");
//		System.out.println( myResponse.get("companyName"));
	
		
		
	}
	public static void main (String [] args) throws IOException, JSONException{
		GetStockPrice gsp = new GetStockPrice();
		gsp.returnStockPrice("amd");
		gsp.getCompanyName();
		gsp.getFiftyTwoWeekLow();
		gsp.getFiftyTwoWeekHigh();
		gsp.getPriceEarningsRatio();
		gsp.getAverageTotalVolume();
		gsp.loopingThrough();

		
		
		
		
	}
	public void loopingThrough() throws JSONException{
//		newj = new JSONObject(response);
//		JSONObject posts = mainObject.getJSONObject(newj);
//		Map<String, JSONObject> map = (Map<String,JSONObject>)newj.getMap();
//
//		ArrayList<String> list = new ArrayList<String>(map.keySet());
//
		if (newj instanceof JSONObject){
			System.out.println("hello11");
			System.out.println(newj);
			System.out.println(newj.get("symbol"));}
		
//			for (int i = 0; i < newj.length(); i++){
////				System.out.println(newj.get
//			}
		for(Iterator iterator = newj.keys(); iterator.hasNext();) {
		    String key = (String) iterator.next();
		    System.out.println(key + "    value is:  " + newj.get(key));
		}
//		String jsonstring = { "child": { "something": "value", "something2": "value" } };
//			newj = new JSONObject(response);
//			Iterator<?> keys = newj.keys();
//
//			while( keys.hasNext() ) {
//			    String key = (String)keys.next();
//			    System.out.println(key);
//			   
//	
//	
//			}
		
		
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
