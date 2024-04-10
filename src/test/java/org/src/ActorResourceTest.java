package org.src;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActorResourceTest
{

    private static int actorId = 0;

    @Test
    @Order(1)
    public void testActorListAll()
    {
        given().when().get("/actor").then().statusCode(200).body("", hasSize(9));
    }
    @Test
    @Order(2)
    public void testCreateActor()
    {
        String newActorJson = "{\"first_name\":\"Rok\",\"last_name\":\"Fiser\",\"born_date\":\"1997-10-19\"}";

        given()
                .contentType("application/json")
                .body(newActorJson)
                .when()
                .post("/actor")
                .then()
                .statusCode(200)
                .body("first_name.string", equalTo("Rok"))
                .body("last_name.string", equalTo("Fiser"))
                .body("born_date.string", equalTo("1997-10-19"));

        Response response = given()
                .queryParam("first_name", "Rok")
                .queryParam("last_name", "Fiser")
                .when()
                .get("/actor")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0)) // Ensure at least one actor is returned
                .extract()
                .response();

        actorId = response.jsonPath().getInt("find { it.first_name == 'Rok' && it.last_name == 'Fiser' }.id");
    }
    @Test
    @Order(3)
    public void testUpdateActor()
    {
        String updatedActorJson = "{\"first_name\":\"Rock\",\"last_name\":\"Fiser\",\"born_date\":\"1997-10-20\"}";
        given()
                .contentType("application/json")
                .body(updatedActorJson)
                .when()
                .put("/actor/" + actorId)
                .then()
                .statusCode(200)
                .body("firstName", equalTo("Rock"))
                .body("lastName", equalTo("Fiser"))
                .body("bornDate", equalTo("1997-10-20"));

        given()
                .when()
                .get("/actor/" + actorId)
                .then()
                .statusCode(200)
                .body("first_name", equalTo("Rock"))
                .body("last_name", equalTo("Fiser"))
                .body("born_date", equalTo("1997-10-20"));
    }
    @Test
    @Order(4)
    public void testDeleteActor()
    {
        given()
                .when()
                .delete("/actor/" + actorId)
                .then()
                .statusCode(204);

        given()
                .when()
                .get("/actor/" + actorId)
                .then()
                .statusCode(404);
    }
}
