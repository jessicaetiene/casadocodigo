package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.converter.ConversorUsuario;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.dto.UsuarioDTO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.ProdutoValidation;
import br.com.casadocodigo.loja.validation.UsuarioValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioValidation usuarioValidation;

    @Autowired
    private ConversorUsuario conversorUsuario;

    @Autowired
    private UsuarioDAO dao;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(usuarioValidation);
    }

    @RequestMapping("/form")
    public ModelAndView form(UsuarioDTO usuario){
        ModelAndView modelAndView = new ModelAndView("usuarios/form");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView cadastrar(@Valid UsuarioDTO usuario, BindingResult result,
                                  RedirectAttributes redirectAttributes){

        if(result.hasErrors()) {
            return form(usuario);
        }

        dao.gravar(conversorUsuario.converter(usuario));
        redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso!");
        return new ModelAndView("redirect:/usuarios");
    }

    @GetMapping
    public ModelAndView listar(){
        List<Usuario> usuarios = dao.listar();
        ModelAndView modelAndView = new ModelAndView("usuarios/lista");
        modelAndView.addObject("usuarios", usuarios);
        return modelAndView;
    }
}
