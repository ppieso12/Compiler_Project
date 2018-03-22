package project.scanner;

import project.scanner.tokens.*;

import java.util.ArrayList;

public class TokenDB {


    private ArrayList<Token> mainDataBase;
    private ArrayList<Token> mainComplexDataBase;
    private static int orderNumber = 0;

    public TokenDB() {
        this.mainDataBase = new ArrayList<>();
        this.mainComplexDataBase = new ArrayList<>();

        this.mainDataBase.add(new TokenDigitFloat(orderNumber++, "NUM_FLOAT"));
        this.mainDataBase.add(new TokenDigit(orderNumber++,"NUM_INT"));   //order of adding tokens has a meaning
        this.mainDataBase.add((new TokenString(orderNumber++,"STRING")));

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

        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_INT","int"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_DOUBLE","double"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_FLOAT","float"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_CHAR","char"));

        this.mainDataBase.add(new TokenId(orderNumber++,"CHARS_ID"));
        this.mainDataBase.add(new TokenError(orderNumber++,"FATAL_ERROR"));

        this.mainComplexDataBase.add(new TokenId(orderNumber++,"CHARS_ID"));   //at now only one element...

    }
    public ArrayList<TokenOutput> match(String str){

        ArrayList<TokenOutput> outputList = new ArrayList<>();
        ReturnedTuple returnedFromMatcher;
        ReturnedTuple returnedFromComplexMatcher = null;

        int stringLength = str.length();
        int current_position = 0;

        while(current_position != stringLength){

            for(Token complexToken: this.mainComplexDataBase){

                returnedFromComplexMatcher = complexToken.match(current_position,str);

            }

            for(Token token : this.mainDataBase){

                returnedFromMatcher = token.match(current_position,str);

                if(returnedFromMatcher == null){
                    continue;

                }else {
                    if(returnedFromComplexMatcher!=null){

                        if(returnedFromComplexMatcher.getNext_position() > returnedFromMatcher.getNext_position()){ // adding that longer string

                            outputList.add(new TokenOutput(returnedFromComplexMatcher.getId_code(), str.substring(current_position, returnedFromComplexMatcher.getNext_position())));

                            current_position = returnedFromComplexMatcher.getNext_position();  //index update

                            break;

                        }else{  //adding that shorter or equal string

                            outputList.add(new TokenOutput(returnedFromMatcher.getId_code(), str.substring(current_position, returnedFromMatcher.getNext_position())));

                            current_position = returnedFromMatcher.getNext_position();   //index update

                            break;
                        }

                    }else{  // when complex is null( I mean a typical chars sequence a-z A-Z without any KEYS etc. )

                        outputList.add(new TokenOutput(returnedFromMatcher.getId_code(), str.substring(current_position, returnedFromMatcher.getNext_position())));

                        current_position = returnedFromMatcher.getNext_position();

                        break;
                    }
                }
            }
        }
        return outputList;
    }
}
























