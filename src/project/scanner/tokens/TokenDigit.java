package project.scanner.tokens;

import project.scanner.ReturnedTuple;


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
        int firstChar = (int) string.charAt(end);

        if((firstChar == 48)&&(string.length() - 1 != end)){   //e. g. 01 - then its error
            //System.out.println(string + " " + string.length()+"  " +end);
            return null;
        }

        while (end < string.length()) {

            if (((int) string.charAt(end) >= 48) && ((int) string.charAt(end) <= 57)) {

                end++;
                isDigit = true;

            } else {
                if ((((int) string.charAt(end) >= 65) && ((int) string.charAt(end) <= 90))||        //if true then there is a char a-z / A-Z with digits - error
                        (((int) string.charAt(end) >= 97) && ((int) string.charAt(end) <= 122))||((int) string.charAt(end) == 46)) {
                    isDigit = false;
                }
                break;  // any other char, e. g. * == etc. which can be approved
            }
        }
        if (isDigit) {
            return new ReturnedTuple(end, this.id_code);
        }

        return null;   // for example useful for erros etc.
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
