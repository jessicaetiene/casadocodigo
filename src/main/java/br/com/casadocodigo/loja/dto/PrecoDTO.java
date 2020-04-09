package br.com.casadocodigo.loja.dto;

import br.com.casadocodigo.loja.models.TipoPreco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrecoDTO {

    private BigDecimal valor;
    private TipoPreco tipo;
}
