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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/editoras")
            .then()
            .statusCode(200)
            .body("nome", hasItems("Atria Books", "Globo Livros", "Intrínseca", "Editora Rocco"));
    }

    @Test
    public void findByIdTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/editoras/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByNomeTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/editoras/search/nome/Atria")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Atria Books")));    
    } 

    @Test
    public void findByEstadoTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
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

        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .pathParam("id", 5)
            .delete("/editoras/{id}")
            .then()
            .statusCode(204);
    }
     
}
