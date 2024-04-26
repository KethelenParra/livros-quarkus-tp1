package br.unitins.topicos1.resource;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;

import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class ClienteResourceTest {
    
    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/clientes")
        .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/clientes/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByCpfTest() {
        given()
            .when()
            .get("/clientes/search/cpf/123")
            .then()
            .statusCode(200)
            .body("cpf", everyItem(containsString("123")));    
    }

    @Test
    public void findByEstadoTest() {
        given()
            .when()
            .get("/clientes/search/estado/Belo")
            .then()
            .statusCode(200)
            .body("estado", everyItem(containsString("Horizonte")));
    }

    @Test
    public void createTest() {
        TelefoneDTO telefoneDTO = new TelefoneDTO("62", "54353");
        ClienteDTO dto = new ClienteDTO(
            "23423",
            "Rua 80",
            "Paraiba",
            "Paraiba",
            "Jorge",
            LocalDate.parse("2003-03-10"),
            "jorge@gmail.com",
            "fefe",
            "254234",
            1, 
            telefoneDTO
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
        .post("/clientes")
        .then()
            .statusCode(201)
            .body("endereco", is("Rua 80"))
            .body("cep", is("23423"))
            .body("cidade", is("Paraiba"))
            .body("estado", is("Paraiba"))
            .body("usuario.nome", is("Jorge"))
            .body("usuario.senha", is("fefe"))
            .body("usuario.email", is("jorge@gmail.com"))
            .body("usuario.cpf", is("254234"))
            .body("usuario.dataNascimento", is("2003-03-10"))
            .body("usuario.sexo.id", is(1)) 
            .body("usuario.telefone.codigoArea", is("62"))
            .body("usuario.telefone.numero", is("54353"));
    }

    @Test
    public void updateTest() {
        TelefoneDTO telefoneDTO = new TelefoneDTO("95", "453543");
        ClienteDTO dto = new ClienteDTO(
            "535252",
            "Rua 10",
            "Tocantins",
            "Palmas",
            "Jenifer",
            LocalDate.parse("2004-03-10"),
            "Jenifer@gmail.com",
            "test",
            "5646465",
            2, 
            telefoneDTO
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/clientes/{id}")
        .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest() {
        given()
            .when()
            .pathParam("id", 4)
            .delete("/clientes/{id}")
            .then()
            .statusCode(204);
    }
     
}
