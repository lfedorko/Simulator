package src;

public class ValidException extends Exception {

public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_YELLOW = "\u001B[33m";

public ValidException(String message) {
         super(ANSI_YELLOW + message + ANSI_RESET);
    }
 }