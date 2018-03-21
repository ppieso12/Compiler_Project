package project.scanner.tokens;

import project.scanner.ReturnedTuple;
import project.scanner.tokens.Token;
import project.scanner.tokens.TokenDigit;

import java.util.ArrayList;

public class TokenId implements Token {

    private int number;
    private String id_code;

    public TokenId(int number, String id_code) {
        this.number = number;
        this.id_code = id_code;
    }

    @Override
    public ReturnedTuple match(int begin, String string) {

        int end = begin;
        boolean isSetOfChars = false; // at least one valid occurrence of chars
        boolean afterFirstExecLoop = false;

        while (end < string.length()) {

           /* if(afterFirstExecLoop){  //if first is a char then second can be number or char
                if (((int) string.charAt(end) >= 48) && ((int) string.charAt(end) <= 57)) {
                    end++;
                }
            }*/
            if ((((int) string.charAt(end) >= 65) && ((int) string.charAt(end) <= 90))||
                    (((int) string.charAt(end) >= 97) && ((int) string.charAt(end) <= 122))){

                end++;
                isSetOfChars = true;
            } else {
                break;
            }
            afterFirstExecLoop = true;
        }
        if (isSetOfChars) {
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
