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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/autores")
            .then()
            .statusCode(200)
            .body("nome", hasItems("Colleen Hoover", "Ali Hazelwood", "Augusto Cury", "Nicholas Sparks", "test", "George Orwell"));
    }

    @Test
    public void findByIdTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/autores/1")
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
            .get("/autores/search/nome/Colleen")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Colleen Hoover")));    
    } 

    @Test
    public void findByBiografiaTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/autores/search/biografia/psiquiatra")
            .then()
            .statusCode(200)
            .body("biografia", everyItem(containsString("psiquiatra")));
    } 

     @Test
    public void createTest() {
        AutorDTO dto = new AutorDTO("Gillian Flynn", "Gillian Schieber Flynn, é uma escritora americana e crítica televisiva na Entertainment Weekly.");
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";

        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .pathParam("id", 7)
            .delete("/autores/{id}")
            .then()
            .statusCode(204);
    }   
}
