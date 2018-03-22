package project.scanner.tokens;

import project.scanner.ReturnedTuple;

public class TokenDigitFloat implements Token {

    private int number;
    private String id_code;

    public TokenDigitFloat(int number, String id_code) {
        this.number = number;
        this.id_code = id_code;
    }

    @Override
    public ReturnedTuple match(int begin, String string) {

        int indexOfDot = this.indexOfCorrectDigitsToDot(begin,string);
        int indexAfterDot;

        if(indexOfDot!=-1){
            indexAfterDot = this.indexOfCorrectDigitsAfterDot(indexOfDot+1,string);

            if(indexAfterDot!=-1){

                return new ReturnedTuple(indexAfterDot,this.id_code);
            }
        }
        return null;
    }

    private int indexOfCorrectDigitsToDot(int begin, String string){

        int end = begin;

        int firstChar = (int) string.charAt(end);

        int loopCounter = 0;

        if((firstChar == 48)&&(string.length() - 1 != end)){   //e. g. 01 - then its error
            if((int) string.charAt(end+1) != 46) {
                return -1;
            } else{
                return ++end;
            }
        }

        while (end < string.length()) {

            if((loopCounter!=0)&&((int)string.charAt(end) == 46)){
                return ++end;
            }

            if (((int) string.charAt(end) >= 48) && ((int) string.charAt(end) <= 57)) {

                end++;

            } else {
                if ((((int) string.charAt(end) >= 65) && ((int) string.charAt(end) <= 90))||        //if true then there is a char a-z / A-Z with digits - error
                        (((int) string.charAt(end) >= 97) && ((int) string.charAt(end) <= 122))) {
                }
                break;  // any other char, e. g. * == etc. which can be approved
            }
            loopCounter++;
        }
        return -1;
    }
    private int indexOfCorrectDigitsAfterDot(int begin, String string){

        int end = begin;
        boolean isDigit = false; // at least one valid occurrence of digit

        while (end < string.length()) {

            if((int)string.charAt(end) == 46){
                return -1;
            }

            if (((int) string.charAt(end) >= 48) && ((int) string.charAt(end) <= 57)) {

                end++;
                isDigit = true;

            } else {
                if ((((int) string.charAt(end) >= 65) && ((int) string.charAt(end) <= 90))||        //if true then there is a char a-z / A-Z with digits - error
                        (((int) string.charAt(end) >= 97) && ((int) string.charAt(end) <= 122))) {
                    isDigit = false;
                }
                break;  // any other char, e. g. * == etc. which can be approved
            }
        }
        if (isDigit) {
            return end;
        }
        return -1;   // for example useful for erros etc.
    }
}
