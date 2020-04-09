package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.converter.ConversorProduto;
import br.com.casadocodigo.loja.converter.ConversorRelatorioProduto;
import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.dto.RelatorioProdutoDTO;
import br.com.casadocodigo.loja.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/relatorio-produtos")
public class RelatorioProdutosController {
    
    @Autowired
    private ProdutoDAO produtoDAO;

  @Autowired
    private ConversorRelatorioProduto conversorRelatorioProduto;

    @RequestMapping( method= RequestMethod.GET)
    @ResponseBody
    public RelatorioProdutoDTO gerarRelatorio(String data) throws ParseException {
        return conversorRelatorioProduto.conventer(produtoDAO.relatorio(data));
    }
}
