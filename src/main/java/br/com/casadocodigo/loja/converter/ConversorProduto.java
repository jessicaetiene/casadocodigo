package br.com.casadocodigo.loja.converter;

import br.com.casadocodigo.loja.dto.PrecoDTO;
import br.com.casadocodigo.loja.dto.ProdutoDTO;
import br.com.casadocodigo.loja.dto.RelatorioProdutoDTO;
import br.com.casadocodigo.loja.models.Preco;
import br.com.casadocodigo.loja.models.Produto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConversorProduto implements Conversor<Produto, ProdutoDTO>  {


    @Override
    public ProdutoDTO converter(Produto produto) {
        return ProdutoDTO.builder()
                .id(produto.getId())
                .titulo(produto.getTitulo())
                .descricao(produto.getDescricao())
                .dataLancamento(produto.getDataLancamento().getTimeInMillis())
                .sumarioPath(produto.getSumarioPath())
                .paginas(produto.getPaginas())
                .precos(precos(produto.getPrecos()))
                .build();
    }

    private List<PrecoDTO> precos(List<Preco> precos) {
        return precos.stream().map(this::mapPrecos).collect(Collectors.toList());
    }

    private PrecoDTO mapPrecos(Preco preco) {
        return PrecoDTO.builder()
                .valor(preco.getValor())
                .tipo(preco.getTipo())
                .build();
    }
}
