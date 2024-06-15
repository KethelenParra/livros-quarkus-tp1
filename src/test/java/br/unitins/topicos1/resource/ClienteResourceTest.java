package br.unitins.topicos1.resource;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.AlterarEmailDTO;
import br.unitins.topicos1.dto.AlterarSenhaDTO;
import br.unitins.topicos1.dto.AlterarUsernameDTO;
import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;

import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class ClienteResourceTest {
 
    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findAllTest() {
        
        given()
            .when()
            .get("/clientes")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByIdTest() {
        
        given()
            .when()
            .get("/clientes/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByCpfTest() {
        
        given()
            .when()
            .get("/clientes/search/cpf/12345678901")
            .then()
            .statusCode(200)
            .body("cpf", everyItem(containsString("123")));    
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByEstadoTest() {
       
        given()
            .when()
            .get("/clientes/search/estado/Belo")
            .then()
            .statusCode(200)
            .body("estado", everyItem(containsString("Horizonte")));
    }

    @Test
    @TestSecurity(user = "testeCliente", roles = "Cliente")
    public void createTest() {
        TelefoneDTO telefoneDTO = new TelefoneDTO("85", "99887766");
        ClienteDTO dto = new ClienteDTO(
            "968695",
            "Rua 80",
            "João Pessoa",
            "PB",
            "Jorge Castanho",
            "jorge190",
            LocalDate.parse("2003-03-10"),
            "jorge.castanho@gmail.com",
            "fefe", 
            "18246936398",
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
            .body("endereco", is("Rua 80"));
    }
 
    @Test
    @TestSecurity(user = "testeCliente2", roles = "Cliente")
    public void updateTest() {
        TelefoneDTO telefoneDTO = new TelefoneDTO("95", "453543");
        ClienteDTO dto = new ClienteDTO(
            "535252",
            "Rua 10",
            "Tocantins",
            "Palmas",
            "Jenifer",
            "jenifer190",
            LocalDate.parse("2004-03-10"),
            "Jenifer@gmail.com",
            "test",
            "3265326",
            2, 
            telefoneDTO
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .pathParam("id", 2)
            .put("/clientes/{id}")
            .then()
            .statusCode(204);
    }
    
    @Test
    @TestSecurity(user = "testeCliente", roles = "Cliente")
    public void deleteTest() {
        
        given()
            .when()
            .pathParam("id", 12)
            .delete("/clientes/{id}")
            .then()
            .statusCode(204);
    }

    @Test
    public void alterarSenhaTest() {
        AlterarSenhaDTO dto = new AlterarSenhaDTO("123", "321");
        /*Login: João */
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjoxLCJzdWIiOiJKb2FvMTAiLCJncm91cHMiOlsiQ2xpZW50ZSJdLCJleHAiOjE3NDk5NDc2ODksImlhdCI6MTcxODQxMTY4OSwianRpIjoiZWUxMzg1YTQtNzkxZC00ZTFlLTg5NDgtMTUxODczZTY4MTlmIn0.IlmaZXIXicDpmubrSy3kk2qkN3E0sUB0Q1vjtbhHEw90gqAE4L6adwRV1yvea0SVCjHTOzkL3dcLudud_KHzfwpwvLoCLO-XNbcuwbH1AhSNUmuo_2yQ6wjKnW4_RoZ5Hlo4Q89DK_m1xebThPc2jl2nYqFq4LeEDdo19x1ddHO3L-lgmWtEwlVkPlSr9lYhUYTbdd7ugpvmILpy_Tbe41Kp5Jfi-CGPIMGAdiWgJeufiHl9ea__RTzHx4pNO21CDOKfDYQFRryh16vNWCzD_7DsoGcLX67CW9-r9IBRlWsCn3bQQSOb5Ud25cskVRVxDxQJ1xjlEje8GxdJxIRLvw";
        given()
        .header("Authorization", "Bearer " + token)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .patch("/clientes/search/alterar-senha")
            .then()
            .statusCode(204);
    }
/*
    @Test
    public void alterarEmailTest() {
        AlterarEmailDTO dto = new AlterarEmailDTO("123", "novoemail@gmail.com");
       login: Juliana 
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo1LCJzdWIiOiJqdWxpYW5hc2FudG9zIiwiZ3JvdXBzIjpbIkNsaWVudGUiXSwiZXhwIjoxNzQ5OTQ5NzI0LCJpYXQiOjE3MTg0MTM3MjQsImp0aSI6IjNkMjZjMmIyLWUzNGEtNGQ3My05Y2U1LTkwOTZjN2JiM2ZkZiJ9.a0vFnlyWQi47IKgRof0LVvGANBA1dekmYW8qLS9CVALabxNCSupo3pb3fE_Ne41c5j_pSe6T4YkRpa-7WizYw2j9runz5b2N0P0jyqB8eCjLO9iaQZxde97HIPFEW030uDRp7WJLStMbUGnihMHi9FnfC1U7NyfFXJM4ZOs4v52tv7MJkpWgZXm_kU6nuGLBeO8Y08oSxTYjKEavD2lf_7CemZx5f-s9FVKVx-aKl_9_ORsRi4Vw81b4ZbnG_CMuZXNU2_Ydthc5wDuRhepp85P4_z9RhvfVDMkmQ5cX731SkQAaKcuPZitTmklna5XrDWKw12DIuZN70lLBjUM2kw";
        given()
            .header("Authorization", "Bearer " + token)
            .body(dto)
            .when()
            .patch("/clientes/search/alterar-email")
            .then()
            .statusCode(204);
    }
*/
    @Test
    public void alterarUsernameTest() {
        AlterarUsernameDTO dto = new AlterarUsernameDTO("321", "novoUsername");

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjoxLCJzdWIiOiJKb2FvMTAiLCJncm91cHMiOlsiQ2xpZW50ZSJdLCJleHAiOjE3NDk5NDc2ODksImlhdCI6MTcxODQxMTY4OSwianRpIjoiZWUxMzg1YTQtNzkxZC00ZTFlLTg5NDgtMTUxODczZTY4MTlmIn0.IlmaZXIXicDpmubrSy3kk2qkN3E0sUB0Q1vjtbhHEw90gqAE4L6adwRV1yvea0SVCjHTOzkL3dcLudud_KHzfwpwvLoCLO-XNbcuwbH1AhSNUmuo_2yQ6wjKnW4_RoZ5Hlo4Q89DK_m1xebThPc2jl2nYqFq4LeEDdo19x1ddHO3L-lgmWtEwlVkPlSr9lYhUYTbdd7ugpvmILpy_Tbe41Kp5Jfi-CGPIMGAdiWgJeufiHl9ea__RTzHx4pNO21CDOKfDYQFRryh16vNWCzD_7DsoGcLX67CW9-r9IBRlWsCn3bQQSOb5Ud25cskVRVxDxQJ1xjlEje8GxdJxIRLvw";
        given()
            .header("Authorization", "Bearer " + token)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .patch("/clientes/search/alterar-username")
            .then()
            .statusCode(204);
    }

    @Test
    public void meuPerfilTest() {
        /*Perfil: Juliana */
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjo1LCJzdWIiOiJqdWxpYW5hc2FudG9zIiwiZ3JvdXBzIjpbIkNsaWVudGUiXSwiZXhwIjoxNzQ5OTQ5NzI0LCJpYXQiOjE3MTg0MTM3MjQsImp0aSI6IjNkMjZjMmIyLWUzNGEtNGQ3My05Y2U1LTkwOTZjN2JiM2ZkZiJ9.a0vFnlyWQi47IKgRof0LVvGANBA1dekmYW8qLS9CVALabxNCSupo3pb3fE_Ne41c5j_pSe6T4YkRpa-7WizYw2j9runz5b2N0P0jyqB8eCjLO9iaQZxde97HIPFEW030uDRp7WJLStMbUGnihMHi9FnfC1U7NyfFXJM4ZOs4v52tv7MJkpWgZXm_kU6nuGLBeO8Y08oSxTYjKEavD2lf_7CemZx5f-s9FVKVx-aKl_9_ORsRi4Vw81b4ZbnG_CMuZXNU2_Ydthc5wDuRhepp85P4_z9RhvfVDMkmQ5cX731SkQAaKcuPZitTmklna5XrDWKw12DIuZN70lLBjUM2kw";
        given()
            .header("Authorization", "Bearer " + token)
            .when()
            .get("/clientes/search/meu-perfil")
            .then()
            .statusCode(200);
    }
    
}

