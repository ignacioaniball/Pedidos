package integrationTest.integratioUtilities;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.FilterableRequestSpecification;

public class PizzeriaRequestSpecBuilder {

	private static final String BASE_URI = "base.uri";
	private static final String BASE_PATH = "/v1";

	public FilterableRequestSpecification buildWithDefault(String requestType) {
		return StringUtils.isNotEmpty(requestType) && requestType.equals("default") ? 
			(FilterableRequestSpecification) defaultBuilder().build() :
			(FilterableRequestSpecification) requetWithoutParams();
	}

	private RequestSpecBuilder defaultBuilder() {

		return new RequestSpecBuilder().log(LogDetail.ALL)
				.setBaseUri(PropertiesManager.getEnvironmentProperty(BASE_URI)).setBasePath(BASE_PATH)
				.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
	}
	
	private RequestSpecBuilder requetWithoutParams() {
		return new RequestSpecBuilder().log(LogDetail.ALL)
				.setBaseUri(PropertiesManager.getEnvironmentProperty(BASE_URI))
				.setBasePath(BASE_PATH);
	}
}
