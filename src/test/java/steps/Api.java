package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Exception;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.junit.Assert;


public class Api {

    Response response;

    @When("Post işleminden dönen petid degeri ile get istegi atılır")
    public void postRequest() throws InterruptedException {

        String requestBody= "{\n" +
                "\n" +
                "  \"id\": 0,\n" +
                "\n" +
                "  \"petId\": 1,\n" +
                "\n" +
                "  \"quantity\": 0,\n" +
                "\n" +
                "  \"shipDate\": \"2025-01-17T10:31:13.875Z\",\n" +
                "\n" +
                "  \"status\": \"placed\",\n" +
                "\n" +
                "  \"complete\": true\n" +
                "\n" +
                "}\n" +
                " ";
        response= RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("https://petstore.swagger.io/v2/store/order");
        int id = response.jsonPath().getInt("petId");
        System.out.println("pet id = "+id);
        System.out.println(response.getBody().prettyPrint());
        Response responseGet= RestAssured.get("https://petstore.swagger.io/v2/pet/"+id);
        System.out.println(responseGet.getBody().prettyPrint());

    }

    @Then("Response kontrol edilir")
    public void responseKontrol() {

        Assert.assertEquals("Karşılaştırma sonucu:", response.getStatusCode(), 200);

    }

}
