package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.converter.ConversorUsuario;
import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.dto.UsuarioDTO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.ProdutoValidation;
import br.com.casadocodigo.loja.validation.UsuarioValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioValidation usuarioValidation;

    @Autowired
    private ConversorUsuario conversorUsuario;

    @Autowired
    private UsuarioDAO dao;

    @Autowired
    private RoleDAO roleDAO;

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

        dao.gravar(conversorUsuario.converterParaEntidade(usuario));
        redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso!");
        return new ModelAndView("redirect:/usuarios");
    }

    @GetMapping
    public ModelAndView listar(){
        List<Usuario> usuarios = dao.listar();
        ModelAndView modelAndView = new ModelAndView("usuarios/lista");
        modelAndView.addObject("usuarios", conversorUsuario.converterParaDTO(usuarios));
        return modelAndView;
    }

    @RequestMapping("/roles/form")
    public ModelAndView formRole(@RequestParam("email") String email){
        Usuario usuario = dao.emailCadastrado(email);
        List<Role> roles = roleDAO.listar();
        List<String> nomesRoles = roles.stream().map(Role::getNome).collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView("usuarios/roles");
        modelAndView.addObject("usuario", conversorUsuario.converterParaDTO(usuario));
        modelAndView.addObject("roles", nomesRoles);
        return modelAndView;
    }

    @PostMapping("/roles")
    @Transactional
    public ModelAndView alterarRole(@RequestParam("email") String email,  UsuarioDTO usuario,
                                    RedirectAttributes redirectAttributes){
        Usuario usuarioAlterado = dao.loadUserByUsername(email);
        List<Role> roles = usuario.getRoles().stream().map(this::mapRole).collect(Collectors.toList());
        usuarioAlterado.setRoles(roles);
        dao.atualizarRoles(usuarioAlterado);
        return new ModelAndView("redirect:/usuarios");
    }

    private Role mapRole(String nome) {
        Role role = new Role();
        role.setNome(nome);
        return role;
    }
}
