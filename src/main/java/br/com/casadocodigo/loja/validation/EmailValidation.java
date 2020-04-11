package br.com.casadocodigo.loja.validation;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class EmailValidation implements Validator {

    private static final Pattern PADRAO_EMAIL =  Pattern.compile("^(.+)@(.+)$");

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public boolean supports(Class<?> clazz) {
        return String.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String email =  (String) target;
        if(!Strings.isNullOrEmpty(email)){
            validaFormatoEmail(email, errors);
            validaEmailRepetido(email, errors);
        }

    }

    private void validaFormatoEmail(String email, Errors errors) {
        if(!PADRAO_EMAIL.matcher(email).matches()){
            errors.rejectValue("email", "emailInvalid");
        }
    }

    private void validaEmailRepetido(String email, Errors errors) {
        if(PADRAO_EMAIL.matcher(email).matches() && usuarioDAO.emailCadastrado(email) != null){
            errors.rejectValue("email", "emailExists");
        }
    }

}
