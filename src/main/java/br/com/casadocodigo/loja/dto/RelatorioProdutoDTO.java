package br.com.casadocodigo.loja.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioProdutoDTO {

    private Long dataGeracao;
    private Integer quantidade;
    private List<ProdutoDTO> produtos;



}
