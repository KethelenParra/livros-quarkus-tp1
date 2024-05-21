package br.unitins.topicos1.resource;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.LivroDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.containsString;


@QuarkusTest
public class LivroResourceTest {
    
     @Test
    public void findAllTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/livros")
            .then()
            .statusCode(200)
            .body("titulo", hasItems("Confess", "A Hipotese do Amor", "Livrotext", "Harry Potter e a Pedra Filosofal", "1984", "O Diário da Nossa Paixão"));
    }

    @Test
    public void findByIdTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/livros/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByTituloTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/livros/search/titulo/Hipotese")
            .then()
            .statusCode(200)
            .body("titulo", everyItem(containsString("Hipotese")));    
    }

    @Test
    public void findByIsbnTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/livros/search/isbn/97885")
            .then()
            .statusCode(200)
            .body("isbn", everyItem(containsString("97885")));
    }

    @Test
    public void findByDescricaoTest() {
        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .when()
            .get("/livros/search/descricao/jovem")
            .then()
            .statusCode(200)
            .body("descricao", everyItem(containsString("jovem")));
    }


    @Test
    public void createTest() {
        LivroDTO dto = new LivroDTO(
            "O Senhor dos Anéis",
            List.of(2L, 5L), // IDs dos autores
            1L, // ID da editora
            List.of(5L), // IDs dos gêneros
            39.90, // preço
            50, // quantidade em estoque
            "9788578275060", // ISBN
            LocalDate.parse("2022-03-10"), // data de lançamento
            1, // ID da classificação
            "A saga de um grupo de heróis na Terra Média.", // descrição
            1L // ID do fornecedor
        );

        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .post("/livros")
        .then()
            .statusCode(201)
            .body("titulo", is("O Senhor dos Anéis"))
            .body("quantidadeEstoque", is(50))
            .body("isbn", is("9788578275060"))
            .body("descricao", is("A saga de um grupo de heróis na Terra Média."))
            .body("datalancamento", is("2022-03-10"))
            .body("preco", is(39.90f))
            .body("id_classificacao.id", is(1))
            .body("fornecedor.id", is(1))
            .body("autores.id", containsInAnyOrder(2, 5))
            .body("generos.id", containsInAnyOrder(5))
            .body("editora.id", is(1));
    }


    
    @Test
    public void updateTest() {
         LivroDTO dto = new LivroDTO(
            "Livrotext",
            List.of(3L, 4L), // IDs dos autores
            3L, // ID da editora
            List.of(5L, 3L), // IDs dos gêneros
            40.90, // preço
            100, // quantidade em estoque
            "3215263418", // ISBN
            LocalDate.parse("2023-10-10"), // data de lançamento
            3, // ID da classificação
            "Livrotext", // descrição
            3L // ID do fornecedor
        );

        String tokenAdm = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsInN1YiI6Ik1hcmlhIFNvdXphIiwiZ3JvdXBzIjpbIkZ1bmNpb25hcmlvIl0sImV4cCI6MTcxNjM0MTg0MiwiaWF0IjoxNzE2MjU1NDQyLCJqdGkiOiIyMzBlN2M2Yy1lYTg4LTRiMDgtYWZkOS0xYTJhODc0ZWFlZjkifQ.XOvP1bnJ00LDqoklxDIvVV-i4IS3SPRzIgBpopjHB1K61zKky1sEGQ6lRWDjCtiG8uHCx0TmZ39-T1HP0k6kO_6Sn4YX6jE8aiTDXEEWE6SlfwprkNmK2484jUNLy4aspxIRyaw27FDbXi8cigVigap2h295E7rf2TYm2ctNNsAyXluk2SlcgrpBYpXQhBS23PMKQnxg9NV1Zs_b2-hzNjYUbouVMnWqnxDz3Uz2U1Yow-2p8LJ4Onq1i9YQETmBOuNhV5hMnTiPyQCGklEQA8PduPQmsLEADkBCBuOzN7GjU0DQJWIcTvjiE0aEfmZd_X-sV0TGvQBJQx0gNZtojA";
        
        given()
            .header("Authorization", "Bearer " + tokenAdm)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
        .when()
            .pathParam("id", 3)
            .put("/livros/{id}")
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
            .delete("/livros/{id}")
            .then()
            .statusCode(204);
    }
}
