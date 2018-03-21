package project.scanner;

import project.scanner.tokens.Token;
import project.scanner.tokens.TokenBasic;
import project.scanner.tokens.TokenDigit;
import project.scanner.tokens.TokenId;

import java.util.ArrayList;

public class TokenDB {


    private ArrayList<Token> mainDataBase;
    private ArrayList<Token> mainComplexDataBase;
    public static int orderNumber = 0;

    public TokenDB() {
        this.mainDataBase = new ArrayList<>();
        this.mainComplexDataBase = new ArrayList<>();
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_EQ","=="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_NOT_EQ","!="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_SUB_EQ","-="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_ADD_EQ","+="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_DIV_EQ","/="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_MUL_EQ","*="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_ASSIGN","="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_ADD","+"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_SUB","-"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_MUL","*"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_DIV","/"));


        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_IF","if"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_CASE","case"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_SWITCH","switch"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_WHILE","while"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_RETURN","return"));


        this.mainDataBase.add(new TokenDigit(orderNumber++,"DIGIT"));

        this.mainComplexDataBase.add(new TokenId(orderNumber++,"CHARS"));

    }
    public ArrayList<TokenOutput> match(String str){

        ArrayList<TokenOutput> outputList = new ArrayList<>();
        ReturnedTuple returnedFromMatcher;
        ReturnedTuple returnedFromComplexMatcher = null;

        int stringLength = str.length();
        int current_positionFromComplex = 0;
        int current_position = 0;
        boolean isMoreThanChars = false;

        //System.out.println(str);
        while(current_position != stringLength){


            for(Token complexToken: this.mainComplexDataBase){

                returnedFromComplexMatcher = complexToken.match(current_position,str);


                    //System.out.println(returnedFromMatcher.getId_code());
                    //outputList.add(new TokenOutput(returnedFromMatcher.getId_code(),
                    //        str.substring(current_position, returnedFromMatcher.getNext_position())));

                    //current_positionFromComplex = returnedFromComplexMatcher.getNext_position();

            }

            for(Token token : this.mainDataBase){
                returnedFromMatcher = token.match(current_position,str);

                if(returnedFromMatcher == null){
                    continue;
                }
                else
                {
                    if(returnedFromComplexMatcher!=null){

                        if(returnedFromComplexMatcher.getNext_position() > returnedFromMatcher.getNext_position()){ //zwrot tego dluzszego stringa

                            outputList.add(new TokenOutput(returnedFromComplexMatcher.getId_code(),
                                    str.substring(current_position, returnedFromComplexMatcher.getNext_position())));

                            current_position = returnedFromComplexMatcher.getNext_position();

                        }else{
                            outputList.add(new TokenOutput(returnedFromMatcher.getId_code(),
                                    str.substring(current_position, returnedFromMatcher.getNext_position())));

                            current_position = returnedFromMatcher.getNext_position();
                        }

                    }else{
                        outputList.add(new TokenOutput(returnedFromMatcher.getId_code(),
                                str.substring(current_position, returnedFromMatcher.getNext_position())));

                        current_position = returnedFromMatcher.getNext_position();
                    }
                }
            }
        }
        return outputList;
    }
}
























