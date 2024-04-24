package br.unitins.topicos1.resource;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.EditoraDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class EditoraResourceTest {
    
    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/editoras")
        .then()
            .statusCode(200)
            .body("nome", hasItems("Atria Books", "Globo Livros", "Intrínseca", "Editora Rocco"));
    }

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/editoras/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        given()
            .when()
            .get("/editoras/search/nome/Atria")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Atria Books")));    
    } 

    @Test
    public void findByEstadoTest() {
        given()
            .when()
            .get("/editoras/search/estado/Rio")
            .then()
            .statusCode(200)
            .body("estado", everyItem(containsString("Janeiro")));
    }

    @Test
    public void createTest() {
        TelefoneDTO telefoneDTO = new TelefoneDTO("12", "4567890");
        EditoraDTO dto = new EditoraDTO(
            "Test",
            "tet@example.com",
            "Rua 20",
            "Tocantins",
            telefoneDTO
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/editoras")
        .then()
            .statusCode(201)
            .body("nome", is("Test"))
            .body("email", is("tet@example.com"))
            .body("endereco", is("Rua 20"))
            .body("estado", is("Tocantins"))
            .body("telefone.codigoArea", is("12"))
            .body("telefone.numero", is("4567890"));

    }
     
    @Test
    public void updateTest() {
        TelefoneDTO telefoneDTO = new TelefoneDTO("23", "4567856");
        EditoraDTO dto = new EditoraDTO(
            "test2",
            "test2@example.com",
            "Rua 23",
            "Para",
            telefoneDTO
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 5)
            .put("/editoras/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest() {
        given()
            .when()
            .pathParam("id", 5)
            .delete("/editoras/{id}")
            .then()
            .statusCode(204);
    }
     
}
