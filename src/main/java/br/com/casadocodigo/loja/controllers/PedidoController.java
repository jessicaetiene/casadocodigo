package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.dto.PedidoDTO;
import br.com.casadocodigo.loja.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/pedidos")
@Scope(value= WebApplicationContext.SCOPE_REQUEST)
public class PedidoController {

    private static final String URI = "https://book-payment.herokuapp.com/orders";

    @Autowired
    private Pedido pedido;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ModelAndView pedidos() {
        ResponseEntity<PedidoDTO[]> response = restTemplate.getForEntity(URI, PedidoDTO[].class);
        PedidoDTO[] pedidos = response.getBody();
        pedido.setItens(Arrays.asList(pedidos));
        return new ModelAndView("pedido/pedidos");
    }
}
