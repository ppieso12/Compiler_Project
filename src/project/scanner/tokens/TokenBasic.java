package project.scanner.tokens;

import project.scanner.ReturnedTuple;
import project.scanner.tokens.Token;

public class TokenBasic implements Token {

    int number;
    String id_code;
    private String description;

    public TokenBasic(int number, String id_code, String description) {
        this.number = number;
        this.id_code = id_code;
        this.description = description;
    }

    @Override
    public ReturnedTuple match(int begin, String string) {

        //System.out.println("from " + this.description.length() + " "+this.description);
       // System.out.println("from substring "+string.substring(begin,begin+this.description.length()));

        if(begin+this.description.length() > string.length()) {
            return null;
        }

        if(this.description.equals(string.substring(begin,begin+this.description.length()))){
            //System.out.println("Dupiaatatastsad");

            return new ReturnedTuple(begin+this.description.length(),this.id_code);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
