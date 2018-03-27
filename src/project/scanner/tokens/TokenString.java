package project.scanner.tokens;

import project.scanner.ReturnedTuple;

public class TokenString implements Token{
    int number;
    String id_code;


    public TokenString(int number, String id_code) {
        this.number = number;
        this.id_code = id_code;
    }

    @Override
    public ReturnedTuple match(int begin, String string) {
        //System.out.println("aa");
        if ((int) string.charAt(begin) == 34) {
            ///System.out.println("aa");
            if (string.indexOf("\"", begin + 1) > -1) {

                return new ReturnedTuple(string.indexOf("\"", begin + 1) + 1, this.id_code);
            }
        }
        return null;
    }
}
