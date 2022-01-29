package br.com.kr.vendas.exceptions;

abstract class Exceptions extends RuntimeException{

    public Exceptions(String message) {
        super(message);
    }

    public Exceptions(Throwable t) {
        super(t);
    }

    protected Exceptions() {
    }
}
