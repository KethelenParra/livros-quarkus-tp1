package br.unitins.topicos1.resource;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class FuncionarioResourceTest {

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/funcionarios")
        .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/funcionarios/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByCpfTest() {
        given()
            .when()
            .get("/funcionarios/search/cpf/9876")
            .then()
            .statusCode(200)
            .body("cpf", everyItem(containsString("9876")));    
    }

    @Test
    public void findByCargoTest() {
        given()
            .when()
            .get("/funcionarios/search/cargo/gerente")
            .then()
            .statusCode(200)
            .body("cargo", everyItem(containsStringIgnoringCase("gerente")));
    }

    @Test
    public void createTest() {
        TelefoneDTO telefoneDTO = new TelefoneDTO("77", "32165");
        FuncionarioDTO dto = new FuncionarioDTO(
            3000.00,
            "Operador",
            "Jaimer",
            "jaimer40", 
            LocalDate.parse("2001-03-11"),
            "jaimer@gmail.com",
            "jaimer123",
            "075486953",
            1,
            telefoneDTO
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
        .post("/funcionarios")
        .then()
            .statusCode(201)
            .body("salario", is(3000.00F));
    }

    @Test
    public void updateTest() {
        TelefoneDTO telefoneDTO = new TelefoneDTO("78", "34534");
        FuncionarioDTO dto = new FuncionarioDTO(
            2500.90,
            "Analista",
            "Judas",
            "judas50",
            LocalDate.parse("1982-04-11"),
            "judas@gmail.com",
            "judas089",
            "2524352",
            1,
            telefoneDTO
        );
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 2)
            .put("/funcionarios/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest() {
        given()
            .when()
            .pathParam("id", 2)
            .delete("/funcionarios/{id}")
            .then()
            .statusCode(204);
    }
  
}
