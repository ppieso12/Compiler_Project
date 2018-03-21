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
        boolean ifFirstIsChar = false;  // at least one valid occurrence of chars
        int loop_counter = 0;

        while (end < string.length()) {

            if(ifFirstIsChar){  //if first is a char then second can be figure or char
                if (((int) string.charAt(end) >= 48) && ((int) string.charAt(end) <= 57)) {
                    end++;
                    continue;
                }
            }

            if ((((int) string.charAt(end) >= 65) && ((int) string.charAt(end) <= 90))||        //is a char
                    (((int) string.charAt(end) >= 97) && ((int) string.charAt(end) <= 122))){

                end++;

                if(loop_counter == 0){
                    ifFirstIsChar = true;
                }
            } else {
                break;
            }
            loop_counter++;
        }

        if (ifFirstIsChar) {
            return new ReturnedTuple(end, this.id_code);
        }else{
            return null;
        }
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
