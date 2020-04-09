package br.com.casadocodigo.loja.converter;

import br.com.casadocodigo.loja.dto.ProdutoDTO;
import br.com.casadocodigo.loja.dto.RelatorioProdutoDTO;
import br.com.casadocodigo.loja.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.List;

@Component
public class ConversorRelatorioProduto {

    @Autowired
    private ConversorProduto conversorProduto;

    public RelatorioProdutoDTO conventer(List<Produto> produtos){
        List<ProdutoDTO> produtoConvertidos = conversorProduto.converterList(produtos);
        return RelatorioProdutoDTO.builder()
                .dataGeracao(Calendar.getInstance().getTimeInMillis())
                .produtos(produtoConvertidos)
                .quantidade(produtoConvertidos.size())
                .build();
    }
}
