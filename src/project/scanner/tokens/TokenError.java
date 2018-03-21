package project.scanner.tokens;

import project.scanner.ReturnedTuple;

public class TokenError implements Token {    //Any errors holder

    int number;
    String id_code;

    public TokenError(int number, String id_code) {
        this.number = number;
        this.id_code = id_code;
    }

    @Override
    public ReturnedTuple match(int begin, String string) {

        if (begin!=string.length()){
            return new ReturnedTuple(string.length(),this.id_code);
        }else{
            return null;
        }
    }
}
