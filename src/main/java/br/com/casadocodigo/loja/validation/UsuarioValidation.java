package br.com.casadocodigo.loja.validation;

import br.com.casadocodigo.loja.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidation implements Validator{

	@Autowired
	private EmailValidation emailValidation;

	@Override
	public boolean supports(Class<?> clazz) {
		return UsuarioDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senha", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senhaRepetida", "field.required");
		UsuarioDTO usuario = (UsuarioDTO) target;
		validaSenha(usuario, errors);
		ValidationUtils.invokeValidator(emailValidation,
				usuario.getEmail(), errors);
	}

	private void validaSenha(UsuarioDTO usuario, Errors errors) {
		if(!usuario.getSenha().equals(usuario.getSenhaRepetida())){
			errors.rejectValue("senhaRepetida", "passwordsMismatch");
		}


	}

}
