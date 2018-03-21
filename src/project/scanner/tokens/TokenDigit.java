package project.scanner.tokens;

import project.scanner.ReturnedTuple;
import project.scanner.tokens.Token;
import project.scanner.tokens.TokenBasic;

import java.util.ArrayList;

public class TokenDigit implements Token {

    private int number;
    private String id_code;

    public TokenDigit(int number, String id_code) {
        this.number = number;
        this.id_code = id_code;
    }

    @Override
    public ReturnedTuple match(int begin, String string) {

        int end = begin;
        boolean isDigit = false; // at least one valid occurrence of digit

        while (end < string.length()) {

            if (((int) string.charAt(end) >= 48) && ((int) string.charAt(end) <= 57)) {
                end++;
                isDigit = true;
            } else {
                break;
            }
        }
        if (isDigit) {
            return new ReturnedTuple(end, this.id_code);
        }

        return null;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getId_code() {
        return id_code;
    }

    public void setId_code(String id_code) {
        this.id_code = id_code;
    }
}
