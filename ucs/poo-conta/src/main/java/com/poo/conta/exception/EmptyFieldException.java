/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.conta.exception;

/**
 *
 * @author lps10
 */
public class EmptyFieldException extends RuntimeException {

    public EmptyFieldException(String message) {
        super(message);
    }

    public EmptyFieldException(String message, Throwable cause) {
        super(message, cause);
    }


}
