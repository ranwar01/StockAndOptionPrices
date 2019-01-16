import java.io.IOException;
import org.json.JSONException;

public class MainClass {
		
	public static void main (String [] args) throws JSONException, IOException{

		 GetStockPrice gsp = new GetStockPrice();
		 gsp.returnStockPrice("amd");
		 MainGuiWindow gui = new MainGuiWindow(gsp);
		
	}
    

}
