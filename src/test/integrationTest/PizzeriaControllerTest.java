package integrationTest;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

@ExtendWith(SpringExtension.class)
@DisplayName("Test de la clase controller")
public class PizzeriaControllerTest {

	private RequestSpecification requestSpec;
	private RequestSpecification requestWithoutParams;

	@BeforeEach
	public void Setup() {
	}

	@Test
	@DisplayName("Test usando RestAssure para enviar request de forma externa" )
	@Disabled
	public void crearPedido() {

		String responseString = RestAssured.given().spec(requestSpec)
				.when().get().andReturn()
				.then().log().all().statusCode(HttpStatus.SC_OK)
				.and().extract().body().asString();

	}
}
