package br.com.kr.vendas.exceptions;

import br.com.kr.vendas.utils.FacesUtils;

public class ValidarEnderecoException extends Exceptions {

    public ValidarEnderecoException(String message) {
        super(message);
        FacesUtils.addErrorMessage(message);

    }

    public ValidarEnderecoException(Throwable t) {
        super(t);
    }

}
