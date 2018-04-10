package yahoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

public class YahooAPI {

	private static final Logger log = LoggerFactory.getLogger(YahooAPI.class);

	private static final String[][] INVESTEMENT_VALUATION= new String[][] {
																			{"Value/Small","Blend/Small","Growth/Small"},
																			{"Value/Medium","Blend/Medium","Growth/Medium"},
																			{"Value/Large","Blend/Large","Growth/Large"},
	};
	
	public static void main(String args[]) {
		RestTemplate restTemplate = new RestTemplate();
		//String response = restTemplate.getForObject("https://query2.finance.yahoo.com/v10/finance/quoteSummary/FCNTX?formatted=false&modules=fundProfile", String.class);
		String response = restTemplate.getForObject("https://query2.finance.yahoo.com/v10/finance/quoteSummary/VASIX?formatted=false&modules=fundProfile", String.class);
		String url = response.substring(response.indexOf("styleBoxUrl"), response.indexOf(".gif") );
		String[] array = url.split("/");		
		String result = array[array.length-1];
		
		
		int start =Character.getNumericValue(result.charAt(0));
		int end =Character.getNumericValue(result.charAt(result.length()-1));
		System.out.println(INVESTEMENT_VALUATION[start-1][end-1]);
		//System.out.println(response);
	}

}
