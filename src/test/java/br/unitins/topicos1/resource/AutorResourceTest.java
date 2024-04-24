package br.unitins.topicos1.resource;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.AutorDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class AutorResourceTest {

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/autores")
        .then()
            .statusCode(200)
            .body("nome", hasItems("Colleen Hoover", "Ali Hazelwood", "Augusto Cury", "Nicholas Sparks", "test", "George Orwell"));
    }

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/autores/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        given()
            .when()
            .get("/autores/search/nome/Colleen")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Colleen Hoover")));    
    } 

    @Test
    public void findByBiografiaTest() {
        given()
            .when()
            .get("/autores/search/biografia/psiquiatra")
            .then()
            .statusCode(200)
            .body("biografia", everyItem(containsString("psiquiatra")));
    } 

     @Test
    public void createTest() {
        AutorDTO dto = new AutorDTO("Gillian Flynn", "Gillian Schieber Flynn, é uma escritora americana e crítica televisiva na Entertainment Weekly.");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/autores")
            .then()
            .statusCode(201)
            .body("nome", is("Gillian Flynn"))
            .body("biografia", is("Gillian Schieber Flynn, é uma escritora americana e crítica televisiva na Entertainment Weekly."));
    }
     
    @Test
    public void updateTest() {
        AutorDTO dto = new AutorDTO("test", "test é uma escritora");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .pathParam("id", 5)
            .put("/autores/{id}")
            .then()
            .statusCode(204);
  
    }

    @Test
    public void deleteTest() {
        
        given()
            .when()
            .pathParam("id", 7)
            .delete("/autores/{id}")
            .then()
            .statusCode(204);
    }   
}
