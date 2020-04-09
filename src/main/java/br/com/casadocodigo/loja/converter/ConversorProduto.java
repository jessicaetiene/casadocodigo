package br.com.casadocodigo.loja.converter;

import br.com.casadocodigo.loja.dto.ProdutoDTO;
import br.com.casadocodigo.loja.dto.RelatorioProdutoDTO;
import br.com.casadocodigo.loja.models.Produto;

import java.util.List;

public class ConversorRelatorioProduto extends Conversor<Produto, RelatorioProdutoDTO>  {



    @Override
    public List<RelatorioProdutoDTO> converterLista(List<Produto> entidade) {
        return null;
    }

    private List<ProdutoDTO> produtos(List<Produto> produtos){
        return null;
    }
}
