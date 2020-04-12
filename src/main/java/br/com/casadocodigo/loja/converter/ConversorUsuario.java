package br.com.casadocodigo.loja.converter;

import br.com.casadocodigo.loja.dto.UsuarioDTO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConversorUsuario implements Conversor<Usuario, UsuarioDTO> {

    @Override
    public UsuarioDTO converterParaDTO(Usuario entidade) {
        List<String> roles = entidade.getRoles().stream().map(Role::getNome).collect(Collectors.toList());
        return UsuarioDTO.builder()
                .nome(entidade.getNome())
                .email(entidade.getEmail())
                .roles(roles)
                .build();
    }

    @Override
    public Usuario converterParaEntidade(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(new BCryptPasswordEncoder().encode(dto.getSenha()));
        return usuario;
    }
}
