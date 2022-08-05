package edu.school21.app;

public class IllegalParametersException extends Exception {

    public String toString(){
        String s = getClass().getName();
        String message = "Can't locate all objects";
        return s + ": " + message;
    }
}
