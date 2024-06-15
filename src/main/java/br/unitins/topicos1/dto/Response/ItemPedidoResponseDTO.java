package br.unitins.topicos1.dto.Response;

import br.unitins.topicos1.model.pedido.ItemPedido;

public record ItemPedidoResponseDTO(
    Long id,
    String titulo,
    Double preco,
    Integer quantidade,
    Double desconto,
    Double subTotal
) {
    public static ItemPedidoResponseDTO valueOf(ItemPedido item) {
        return new ItemPedidoResponseDTO(
            item.getLivro().getId(), 
            item.getLivro().getTitulo(), 
            item.getLivro().getPreco(),
            item.getQuantidade(),
            item.getDesconto(),
            item.getSubTotal()
        );
    }
}
