package integrationTest.integratioUtilities;
/**
 *
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import net.minidev.json.JSONValue;

public class BaseTestCase {

	public static final String ENDPOINT_URL = "endpointUrl";
	public static final String HEADER = "header";
	public static final String TOKEN_HEADER = "XSRF-TOKEN";
	
	
	private static final String HEADER_PASSTHRU_VALUES = "X-Passthru-Values";
	
	private static final String STATUS = "status";
	private static final String MESSAGE = "message";
	
	public static void verifyTestException(Integer statusCode, String responseBody, String metadataMessage) {
		
		JSONObject response =  (JSONObject) JSONValue.parse(responseBody);
		try {
			assertNotNull(response.get(STATUS));
			assertEquals(statusCode, Integer.valueOf(response.get(STATUS).toString()));
			
			if (StringUtils.isNotEmpty(metadataMessage)) {
				assertNotNull(response.get(MESSAGE));
				assertTrue(response.get(MESSAGE).toString().contains(metadataMessage));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
