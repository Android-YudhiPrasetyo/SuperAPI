import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class SuperApi {

    @Test
    public void getPokemon() {

        Response response = given().baseUri("https://pokeapi.co/")
                .log().all()
                .basePath("/api/v2/")
                .accept(ContentType.JSON)
                .get("/pokemon/pikachu");

        Object pokemonName = given().baseUri("https://pokeapi.co/")
                .log().all()
                .basePath("/api/v2/")
                .accept(ContentType.JSON)
                .get("/pokemon/pikachu").then().extract().path("forms.name");

        Object pokemonId = given().baseUri("https://pokeapi.co/")
                .log().all()
                .basePath("/api/v2/")
                .accept(ContentType.JSON)
                .get("/pokemon/pikachu").then().extract().path("id");

        response.getBody().prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
        System.out.println("Extract Pokemon Name is  = " + pokemonName);
        System.out.println("Extract Pokemon Name id  = " + pokemonId);
    }
}
