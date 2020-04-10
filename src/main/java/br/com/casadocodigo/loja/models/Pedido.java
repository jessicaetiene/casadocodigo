package br.com.casadocodigo.loja.models;

import br.com.casadocodigo.loja.dto.PedidoDTO;
import br.com.casadocodigo.loja.dto.ProdutoDTO;
import br.com.casadocodigo.loja.utils.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Setter
@Getter
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<PedidoDTO> itens;

    public String dataFormatada(Long dataTimeMili){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(dataTimeMili), ZoneId.systemDefault())
        .format(DateTimeFormatter.ofPattern(DateUtils.FORMATO_DD_MM_YY));
    }

    public String titulos(List<ProdutoDTO> produtos){
        List<String> titulos = produtos.stream().map(ProdutoDTO::getTitulo).collect(Collectors.toList());
        return String.join(", ", titulos);
    }
}
