package com.ecommerceback.Service.Exceptions;

import java.util.NoSuchElementException;

public class ObjectNotFoundException extends NoSuchElementException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException() {
    }


}
