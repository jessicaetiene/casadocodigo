package br.com.casadocodigo.loja.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PedidoDTO {

    private Integer id;
    private BigDecimal valor;
    private Long data;
    private List<ProdutoDTO> produtos;
}
