package yahoo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class YahooAPI {

	private static final Logger LOGGER = LoggerFactory.getLogger(YahooAPI.class);

	/*
	 * private static final String[][] INVESTEMENT_VALUATION= new String[][] {
	 * {"Value/Small","Blend/Small","Growth/Small"},
	 * {"Value/Medium","Blend/Medium","Growth/Medium"},
	 * {"Value/Large","Blend/Large","Growth/Large"}, };
	 */

	private static final String[] INVESTEMENT_VALUATION = new String[] {

			"EMPTY",

			"Value/Large", "Blend/Large", "Growth/Large",

			"Value/Medium", "Blend/Medium", "Growth/Medium",

			"Value/Small", "Blend/Small", "Growth/Small",

	};

	public static void main(String args[]) {

		// HttpHeaders headers = new HttpHeaders();
		// headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		// HttpEntity<String> request = new HttpEntity<String>(headers);

		RestTemplate restTemplate = new RestTemplate();
		// ResponseEntity<String> response =
		// restTemplate.exchange("https://query2.finance.yahoo.com/v10/finance/quoteSummary/VEND.L?formatted=false&modules=fundProfile",
		// HttpMethod.GET, request, String.class);
		//
		//

		try {
			// String response =
			// restTemplate.getForObject("https://query2.finance.yahoo.com/v10/finance/quoteSummary/FCNTX?formatted=false&modules=fundProfile",
			// String.class);
			// String response =
			// restTemplate.getForObject("https://query2.finance.yahoo.com/v10/finance/quoteSummary/VASIX?formatted=false&modules=fundProfile",
			// String.class);
			// String response =
			// restTemplate.getForObject("https://query2.finance.yahoo.com/v10/finance/quoteSummary/TLSVX?formatted=false&modules=fundProfile",
			// String.class);
			// String response =
			restTemplate.getForObject("https://query2.finance.yahoo.com/v10/finance/quoteSummary/VEND.L?formatted=false&modules=fundProfile", String.class);

		} catch (HttpClientErrorException exp) {
			System.out.println(exp.getRawStatusCode());
			if (exp.getStatusCode() != HttpStatus.NOT_FOUND) {
				System.out.println("Not Found");
			}
		}

		// int styleBoxUrlIndex = response.indexOf("styleBoxUrl");
		// int gifIndex = response.indexOf(".gif");
		//
		//
		// if(styleBoxUrlIndex > -1 && gifIndex>-1) {
		// String url = response.substring(response.indexOf("styleBoxUrl"),
		// response.indexOf(".gif") );
		// String[] array = url.split("/");
		// String result = array[array.length-1];
		//
		//
		// //int start =Character.getNumericValue(result.charAt(0));
		// int end =Character.getNumericValue(result.charAt(result.length()-1));
		// System.out.println(INVESTEMENT_VALUATION[end]);
		// }else{
		//
		// }

		// System.out.println(response);
	}

}
