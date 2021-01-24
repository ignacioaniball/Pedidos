package pizzeriaTest;



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

	//Arrange
	@BeforeEach
	public void Setup() {
//		requestSpec = new PizzeriaRequestSpecBuilder().buildWithDefault("default");
//		requestWithoutParams = new PizzeriaRequestSpecBuilder().buildWithDefault("requestWithoutParams");
	}

	@Test
	@DisplayName("Test usando RestAssure para enviar request de forma externa" )
	@Disabled
	public void crearPedido() {

		//Action
		String responseString = RestAssured.given().spec(requestSpec)
				.when().get().andReturn()
				.then().log().all().statusCode(HttpStatus.SC_OK)
				.and().extract().body().asString();




		//Assertion
//				RestAssured.post("/pedidos").then()
//		.statusCode(200)
//		.body();
	}

	@Test
	@DisplayName("Test usan Moquito para hacer Mocks")
	public void crearPedidoCabeceraTest(){

		//Action

		//Assertion

	}
}
