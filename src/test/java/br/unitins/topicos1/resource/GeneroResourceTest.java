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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/generos")
            .then()
            .statusCode(200)
            .body("nome", hasItems("Romance", "Ficção Científica", "Alta ajuda", "Fantasia", "Mistério", "Aventura"));
    }

    @Test
    public void findByIdTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/generos/1")
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
            .get("/generos/search/nome/Aventura")
            .then()
            .statusCode(200)
            .body("nome", everyItem(equalTo("Aventura")));    
    }

    @Test
    public void findByDescricaoTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
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

        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
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

        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
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
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .pathParam("id", 7)
            .delete("/generos/{id}")
            .then()
            .statusCode(204);
    }
}
