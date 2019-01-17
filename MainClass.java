import java.io.IOException;
import org.json.JSONException;

public class MainClass {
		
	public static void main (String [] args) throws JSONException, IOException{

		 GetStockPrice gsp = new GetStockPrice();
		 gsp.returnStockPrice("amd");
		 System.out.println("hellsssdddddffo");
		 MainGuiWindow gui = new MainGuiWindow(gsp);
		
	}
    

}
