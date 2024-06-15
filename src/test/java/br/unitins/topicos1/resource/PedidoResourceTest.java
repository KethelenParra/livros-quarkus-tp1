package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.CartaoCreditoDTO;
import br.unitins.topicos1.dto.ItemPedidoDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;
import java.util.List;

@QuarkusTest
public class PedidoResourceTest {

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findAllTest() {
        given()
            .when()
            .get("/pedidos")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByIdTest() {
        
        given()
            .when()
            .get("/pedidos/1")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "teste", roles = "Funcionario")
    public void findByClienteTest() {
        given()
            .when()
            .get("/pedidos/search/clientes/1")
            .then()
            .statusCode(200);
    }

    @Test
    public void createTest() {
        ItemPedidoDTO item = new ItemPedidoDTO(1L, 2);
        PedidoDTO dto = new PedidoDTO(4L, List.of(item));

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjozLCJzdWIiOiJhbmFvbGl2ZWlyYSIsImdyb3VwcyI6WyJDbGllbnRlIl0sImV4cCI6MTc0OTk1ODM2MywiaWF0IjoxNzE4NDIyMzYzLCJqdGkiOiI0ZTk3YzVjYy1jNzRjLTQxMDUtYWM2YS0wN2QwMWExZTRhOTQifQ.naLkGeq8--RNi80UiJbXO5ssvALmt7FWmbzQ0IPTAxTA9KvZSmkicvDrVIG_bF2UT1273mPc29CelBLItOZDE9zCbJdTQl_YDf0p9ZDUqqgIoO3G7zE00BzO6JvccmStcHpcZc12ybyq1D7kcXzUnybZrqSJvE5r56od8xewE3UdhfQJ5El_0MEClxV8HqL5t0Y8wkt8CiXdxiTpANuuSfY8gkS-XCGQ4wzeSw4ZpXgFXT3WUr9WmgpVseAFSVGgzX8eazA21BwMRbM5sKV1UiRp2bBE-uuSeQvweL7QvT5grl4m6t2tuj1oUoHm-U1L7ZzQEQa9eXYjjnX3SRn-Mw";
      
        given()
        .header("Authorization", "Bearer" + token)
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/pedidos")
            .then()
            .statusCode(201)
            .body("cliente.id", is(4));
    }
    

    @Test
    public void cancelarPedidoTest() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjozLCJzdWIiOiJhbmFvbGl2ZWlyYSIsImdyb3VwcyI6WyJDbGllbnRlIl0sImV4cCI6MTc0OTk1ODM2MywiaWF0IjoxNzE4NDIyMzYzLCJqdGkiOiI0ZTk3YzVjYy1jNzRjLTQxMDUtYWM2YS0wN2QwMWExZTRhOTQifQ.naLkGeq8--RNi80UiJbXO5ssvALmt7FWmbzQ0IPTAxTA9KvZSmkicvDrVIG_bF2UT1273mPc29CelBLItOZDE9zCbJdTQl_YDf0p9ZDUqqgIoO3G7zE00BzO6JvccmStcHpcZc12ybyq1D7kcXzUnybZrqSJvE5r56od8xewE3UdhfQJ5El_0MEClxV8HqL5t0Y8wkt8CiXdxiTpANuuSfY8gkS-XCGQ4wzeSw4ZpXgFXT3WUr9WmgpVseAFSVGgzX8eazA21BwMRbM5sKV1UiRp2bBE-uuSeQvweL7QvT5grl4m6t2tuj1oUoHm-U1L7ZzQEQa9eXYjjnX3SRn-Mw";
      
        given()
        .header("Authorization", "Bearer " + token)
            .when()
            .delete("/pedidos/search/cancelar-Pedido")
            .then()
            .statusCode(204);
    }

    @Test
    public void meusPedidosTest() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjozLCJzdWIiOiJhbmFvbGl2ZWlyYSIsImdyb3VwcyI6WyJDbGllbnRlIl0sImV4cCI6MTc0OTk1ODM2MywiaWF0IjoxNzE4NDIyMzYzLCJqdGkiOiI0ZTk3YzVjYy1jNzRjLTQxMDUtYWM2YS0wN2QwMWExZTRhOTQifQ.naLkGeq8--RNi80UiJbXO5ssvALmt7FWmbzQ0IPTAxTA9KvZSmkicvDrVIG_bF2UT1273mPc29CelBLItOZDE9zCbJdTQl_YDf0p9ZDUqqgIoO3G7zE00BzO6JvccmStcHpcZc12ybyq1D7kcXzUnybZrqSJvE5r56od8xewE3UdhfQJ5El_0MEClxV8HqL5t0Y8wkt8CiXdxiTpANuuSfY8gkS-XCGQ4wzeSw4ZpXgFXT3WUr9WmgpVseAFSVGgzX8eazA21BwMRbM5sKV1UiRp2bBE-uuSeQvweL7QvT5grl4m6t2tuj1oUoHm-U1L7ZzQEQa9eXYjjnX3SRn-Mw";
      
        given()
        .header("Authorization", "Bearer " + token)
            .when()
            .get("/pedidos/search/meus-Pedidos")
            .then()
            .statusCode(200);
    }

    @Test
    public void pagarBoletoTest() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjozLCJzdWIiOiJhbmFvbGl2ZWlyYSIsImdyb3VwcyI6WyJDbGllbnRlIl0sImV4cCI6MTc0OTk1ODM2MywiaWF0IjoxNzE4NDIyMzYzLCJqdGkiOiI0ZTk3YzVjYy1jNzRjLTQxMDUtYWM2YS0wN2QwMWExZTRhOTQifQ.naLkGeq8--RNi80UiJbXO5ssvALmt7FWmbzQ0IPTAxTA9KvZSmkicvDrVIG_bF2UT1273mPc29CelBLItOZDE9zCbJdTQl_YDf0p9ZDUqqgIoO3G7zE00BzO6JvccmStcHpcZc12ybyq1D7kcXzUnybZrqSJvE5r56od8xewE3UdhfQJ5El_0MEClxV8HqL5t0Y8wkt8CiXdxiTpANuuSfY8gkS-XCGQ4wzeSw4ZpXgFXT3WUr9WmgpVseAFSVGgzX8eazA21BwMRbM5sKV1UiRp2bBE-uuSeQvweL7QvT5grl4m6t2tuj1oUoHm-U1L7ZzQEQa9eXYjjnX3SRn-Mw";
      
        given()
            .header("Authorization", "Bearer " + token)
            .when()
            .patch("/pedidos/search/pagar-Boleto")
            .then()
            .statusCode(202);
    }

    @Test
    public void pagarPixTest() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjozLCJzdWIiOiJhbmFvbGl2ZWlyYSIsImdyb3VwcyI6WyJDbGllbnRlIl0sImV4cCI6MTc0OTk1ODM2MywiaWF0IjoxNzE4NDIyMzYzLCJqdGkiOiI0ZTk3YzVjYy1jNzRjLTQxMDUtYWM2YS0wN2QwMWExZTRhOTQifQ.naLkGeq8--RNi80UiJbXO5ssvALmt7FWmbzQ0IPTAxTA9KvZSmkicvDrVIG_bF2UT1273mPc29CelBLItOZDE9zCbJdTQl_YDf0p9ZDUqqgIoO3G7zE00BzO6JvccmStcHpcZc12ybyq1D7kcXzUnybZrqSJvE5r56od8xewE3UdhfQJ5El_0MEClxV8HqL5t0Y8wkt8CiXdxiTpANuuSfY8gkS-XCGQ4wzeSw4ZpXgFXT3WUr9WmgpVseAFSVGgzX8eazA21BwMRbM5sKV1UiRp2bBE-uuSeQvweL7QvT5grl4m6t2tuj1oUoHm-U1L7ZzQEQa9eXYjjnX3SRn-Mw";
      
        given()
        .header("Authorization", "Bearer " + token)
            .when()
            .patch("/pedidos/search/pagar-Pix")
            .then()
            .statusCode(202);
    }

    @Test
    public void pagarCartaoCreditoTest() {
        CartaoCreditoDTO cartao = new CartaoCreditoDTO("0980909232", "teste", 325, LocalDate.parse("2023-10-10"), "123123", 1);

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ1bml0aW5zLWp3dCIsImlkIjozLCJzdWIiOiJhbmFvbGl2ZWlyYSIsImdyb3VwcyI6WyJDbGllbnRlIl0sImV4cCI6MTc0OTk1ODM2MywiaWF0IjoxNzE4NDIyMzYzLCJqdGkiOiI0ZTk3YzVjYy1jNzRjLTQxMDUtYWM2YS0wN2QwMWExZTRhOTQifQ.naLkGeq8--RNi80UiJbXO5ssvALmt7FWmbzQ0IPTAxTA9KvZSmkicvDrVIG_bF2UT1273mPc29CelBLItOZDE9zCbJdTQl_YDf0p9ZDUqqgIoO3G7zE00BzO6JvccmStcHpcZc12ybyq1D7kcXzUnybZrqSJvE5r56od8xewE3UdhfQJ5El_0MEClxV8HqL5t0Y8wkt8CiXdxiTpANuuSfY8gkS-XCGQ4wzeSw4ZpXgFXT3WUr9WmgpVseAFSVGgzX8eazA21BwMRbM5sKV1UiRp2bBE-uuSeQvweL7QvT5grl4m6t2tuj1oUoHm-U1L7ZzQEQa9eXYjjnX3SRn-Mw";
      
        given()
        .header("Authorization", "Bearer " + token)
            .contentType(MediaType.APPLICATION_JSON)
            .body(cartao)
            .when()
            .patch("/pedidos/search/pagar-Cartao-Credito")
            .then()
            .statusCode(202);
    }

}
