package br.com.casadocodigo.loja.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Integer id;
    private String titulo;
    private String descricao;
    private Integer paginas;
    private String sumarioPath;
    private List<PrecoDTO> precos;
    private Long dataLancamento;
}
