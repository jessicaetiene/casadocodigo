package br.com.casadocodigo.loja.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private String senhaRepetida;
    private List<String> roles;
}
