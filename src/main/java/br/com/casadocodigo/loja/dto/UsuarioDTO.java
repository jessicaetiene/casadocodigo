package br.com.casadocodigo.loja.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private String senhaRepetida;
}
