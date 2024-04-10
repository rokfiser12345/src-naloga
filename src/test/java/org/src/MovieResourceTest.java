package org.src;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieResourceTest
{
    @Test
    @Order(1)
    public void testMovieListAll()
    {
        given().when().get("/movie").then().statusCode(200).body("", hasSize(9));
    }
}
