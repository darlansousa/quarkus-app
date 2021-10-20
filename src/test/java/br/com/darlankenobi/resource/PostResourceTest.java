package br.com.darlankenobi.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class PostResourceTest {

    @Test
    public void testaSeStatusCodeRequisicaoIgual200(){
        RestAssured
                .given()
                .get("posts")
                .then()
                .statusCode(200);
    }
}
