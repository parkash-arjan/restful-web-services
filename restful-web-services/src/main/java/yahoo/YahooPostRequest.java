package yahoo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class YahooPostRequest {
	private static final Logger LOGGER = LoggerFactory.getLogger(YahooAPI.class);

	//private static List<String> sectors = Arrays.asList("Basic Materials", "Consumer Goods", "Healthcare", "Services", "Utilities", "Conglomerates", "Financial", "Industrial Goods", "Technology");
	private static List<String> sectors = Arrays.asList("Services");

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();

		for (String sector : sectors) {
			try {

				String URI = "https://query2.finance.yahoo.com/v1/finance/screener?lang=en-US&region=US&formatted=true&corsDomain=finance.yahoo.com";
				String request = " {" + "\"offset\": offset," + "\"size\": size," + "\"sortType\": \"DESC\"," + "\"sortField\": \"intradaymarketcap\"," + "\"quoteType\": \"EQUITY\"," + "\"query\": {" + " \"operator\": \"and\"," + "\"operands\": [" + "{" + "\"operator\": \"or\"," + "\"operands\": [" + "{\"operator\": \"EQ\", \"operands\": [\"region\", \"us\"]}" + "]" + "}," + "{" + "\"operator\": \"or\"," + "\"operands\": [" + "{\"operator\": \"EQ\", \"operands\": [\"sector\", \"" + sector + "\"]}" + "]" + "}" + "]" + "}," + "\"userId\": \"\"," + "\"userIdType\": \"guid\"" + "}";

				ResponseEntity<String> responseEntity = restTemplate.postForEntity(URI, request, String.class);

				write(sector, responseEntity.getBody());

			} catch (HttpClientErrorException exp) {
				System.out.println(exp.getRawStatusCode());
				if (exp.getStatusCode() != HttpStatus.NOT_FOUND) {
					System.out.println("Not Found");
				}
			}
		}

	}

	private static void write(String fileName, String content) {
		String directory = "C:\\Users\\localadmin\\Desktop\\Financials\\" + fileName + "_" + new Date().toString().replace(":", "_") + ".json";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(directory))) {
			bw.write(content);
			System.out.println("Done");
		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
