package project.scanner.tokens;

import project.scanner.ReturnedTuple;

public class TokenLineComment implements Token{

    int number;
    String id_code;
    private String description;

    public TokenLineComment(int number, String id_code) {
        this.number = number;
        this.id_code = id_code;
        this.description = "//";
    }

    @Override
    public ReturnedTuple match(int begin, String string) {

        if(begin+this.description.length() > string.length()) {
            return null;
        }

        if(this.description.equals(string.substring(begin,begin+this.description.length()))){

            return new ReturnedTuple(string.length(),this.id_code);
        }else{

            return null;
        }
    }
}
