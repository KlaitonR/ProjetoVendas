package br.com.kr.vendas.validators;

import br.com.kr.vendas.services.ClienteService;
import br.com.kr.vendas.utils.FacesUtils;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class Validators implements Serializable {

    @Inject
    private ClienteService clienteService;

    public void validateEmail(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String email = (String) o;

        if(email != null){
            if(!clienteService.buscaClientePorEmail(email).isEmpty()) {
                throw new ValidatorException(FacesUtils.addErrorMessageValidate("emailDuplicado"));
            }

            if(!isValidEmailAddress(email)){
                throw new ValidatorException(FacesUtils.addErrorMessageValidate("emailInvalido"));
            }
        }
    }

    public void validateDuplicatedCPF(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Long cpf = (Long) o;

        if(cpf != null){
            if(!clienteService.buscaClientePorCpf(cpf).isEmpty()) {
                throw new ValidatorException(FacesUtils.addErrorMessageValidate("cpfDuplicado"));
            }
        }
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}
