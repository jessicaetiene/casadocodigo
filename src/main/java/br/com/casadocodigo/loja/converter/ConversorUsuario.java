package br.com.casadocodigo.loja.converter;

import br.com.casadocodigo.loja.dto.UsuarioDTO;
import br.com.casadocodigo.loja.models.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ConversorUsuario implements Conversor<UsuarioDTO, Usuario> {


    @Override
    public Usuario converter(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(new BCryptPasswordEncoder().encode(dto.getSenha()));
        return usuario;
    }
}
