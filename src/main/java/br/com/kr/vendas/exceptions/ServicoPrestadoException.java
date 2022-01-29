package br.com.kr.vendas.exceptions;

import br.com.kr.vendas.utils.FacesUtils;

public class ServicoPrestadoException extends Exceptions{

    public ServicoPrestadoException(String message) {
        super(message);
        FacesUtils.addErrorMessage(message);

    }

    public ServicoPrestadoException(Throwable t) {
        super(t);
    }

}
