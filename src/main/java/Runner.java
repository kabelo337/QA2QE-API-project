
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;


import static io.restassured.RestAssured.given;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/", glue = "stepdefinitions")
public class Runner {



    public static void Runner(String[] args) {
        // Variables needed to log onto API
        String baseUri = "https://magento.abox.co.za/rest/V1/";
        String loginPath = "integration/admin/token";
        // String productCatalogPath = "products";
        String apiUserName = "training_api_user";
        String apiPassword = "PtkekYqgRZW8pCVN";
        String sessionToken = "";



        sessionToken =
                given()
                        .baseUri(baseUri)
                        .basePath(loginPath)
                        .queryParam("username", apiUserName)
                        .queryParam("password", apiPassword)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .body().asString();
        System.out.println(sessionToken.toString());
    }

}
