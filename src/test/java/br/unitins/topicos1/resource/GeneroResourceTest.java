package br.unitins.topicos1.resource;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.GeneroDTO;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


@QuarkusTest
public class GeneroResourceTest {
    
    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/generos")
        .then()
            .statusCode(200)
            .body("nome", hasItems("Romance", "Ficção Científica", "Alta ajuda", "Fantasia", "Mistério", "Aventura"));
    }

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/generos/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        given()
            .when()
            .get("/generos/search/nome/Aventura")
            .then()
            .statusCode(200)
            .body("nome", everyItem(equalTo("Aventura")));    
    }

    @Test
    public void findByDescricaoTest() {
        given()
            .when()
            .get("/generos/search/descricao/amorosos")
            .then()
            .statusCode(200)
            .body("descricao", everyItem(containsString("amorosos")));
    }


    @Test
    public void createTest() {
        GeneroDTO dto = new GeneroDTO(
            "Terror", 
            "Gênero literário que busca provocar medo e suspense nos leitores, explorando temas como o sobrenatural, o desconhecido e o horror."
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/generos")
            .then()
            .statusCode(201)
            .body("nome", is("Terror"))
            .body("descricao", is("Gênero literário que busca provocar medo e suspense nos leitores, explorando temas como o sobrenatural, o desconhecido e o horror."));
    }

    
    @Test
    public void updateTest() {
        GeneroDTO dto = new GeneroDTO(
            "Alta ajuda", 
            "Gênero literário que busca oferecer orientações práticas e conselhos úteis para melhorar a vida pessoal e profissional dos leitores."
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/generos/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest() {
        given()
            .when()
            .pathParam("id", 7)
            .delete("/generos/{id}")
            .then()
            .statusCode(204);
    }
}
