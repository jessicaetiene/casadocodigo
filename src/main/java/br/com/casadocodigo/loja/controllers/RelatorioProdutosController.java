package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.converter.ConversorProduto;
import br.com.casadocodigo.loja.converter.ConversorRelatorioProduto;
import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.dto.RelatorioProdutoDTO;
import br.com.casadocodigo.loja.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
@RequestMapping("/relatorio-produtos")
public class RelatorioProdutosController {
    
    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private ConversorRelatorioProduto conversorRelatorioProduto;

    @GetMapping
    @ResponseBody
    public RelatorioProdutoDTO gerarRelatorio(@RequestParam(required = false)
                                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data){
        return conversorRelatorioProduto.conventer(produtoDAO.relatorio(DateUtils.localDateToCalendar(data)));
    }
}
