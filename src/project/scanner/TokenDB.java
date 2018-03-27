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

        this.mainDataBase.add(new TokenLineComment(orderNumber++, "COMMENT_LINE"));

        this.mainDataBase.add(new TokenDigitFloat(orderNumber++, "NUM_FLOAT"));
        this.mainDataBase.add(new TokenDigit(orderNumber++,"NUM_INT"));   //order of adding tokens has a meaning
        this.mainDataBase.add((new TokenString(orderNumber++,"STRING")));

        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_EQ","=="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_NOT_EQ","!="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_LESS_THANE","<="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_GREATER_THANE",">="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_SUB_EQ","-="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_ADD_EQ","+="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_DIV_EQ","/="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_MUL_EQ","*="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_ASSIGN","="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_INC","++"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_DEC","--"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_ADD","+"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_SUB","-"));
        //this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_MUL","*"));  defined as pointer
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_DIV","/"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_MOD","%"));

        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_LOG_AND","&&"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_LOG_OR","||"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_LOG_NOT","!"));

        //this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_AND","&"));  defined as address
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_OR","|"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_XOR","^"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_LEFT_SHIFT","<<"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_RIGHT_SHIFT",">>"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_NOT","~"));


        this.mainDataBase.add(new TokenBasic(orderNumber++,"BRACKET_ROUND_LEFT","("));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"BRACKET_ROUND_RIGHT",")"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"BRACKET_CURLY_LEFT","{"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"BRACKET_CURLY_RIGHT","}"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"BRACKET_SQUARE_LEFT","["));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"BRACKET_SQUARE_RIGHT","]"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"BRACKET_ANGLE_LEFT","<"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"BRACKET_ANGLE_RIGHT",">"));

        this.mainDataBase.add(new TokenBasic(orderNumber++,"SEMICOLON",";"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"COMMA",","));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"ADDRESS","&"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"POINTER","*"));

        this.mainDataBase.add(new TokenBasic(orderNumber++,"ARROW","->"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"COLON",":"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"QUESTION_MARK","?"));

        this.mainDataBase.add(new TokenBasic(orderNumber++,"PREPROCESSOR_COMMAND_DEF","#define"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"PREPROCESSOR_COMMAND_INC","#include"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"PREPROCESSOR_COMMAND_UNDEF","#undef"));
        //https://www.tutorialspoint.com/cprogramming/c_preprocessors.htm there can be much more

        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_IF","if"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_DO","do"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_CASE","case"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_SWITCH","switch"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_WHILE","while"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_RETURN","return"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_AUTO","auto"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_ELSE","else"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_BREAK","break"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_ENUM","enum"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_REGISTER","register"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_TYPEDEF","typedef"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_EXTERN","extern"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_UNION","union"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_CONTINUE","continue"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_GOTO","goto"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_SIZEOF","sizeof"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_VOLATILE","volatile"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_DEFAULT","default"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_STATIC","static"));

        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_INT","int"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_DOUBLE","double"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_FLOAT","float"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_CHAR","char"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_SHORT","short"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_UNSIGNED","unsigned"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_CONST","const"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_SIGNED","signed"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_VOID","void"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_STRUCT","struct"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_LONG","long"));

        this.mainDataBase.add(new TokenId(orderNumber++,"CHARS_IDENTIFIER"));
        this.mainDataBase.add(new TokenError(orderNumber++,"FATAL_ERROR"));

        this.mainComplexDataBase.add(new TokenId(orderNumber++,"CHARS_ID"));   //at now only one element...
/* ADDED - this section is to delete
* brackets () {} <> []
* preprocessor commands
* comment in one line ---
* semicolon
* ,
* this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_DO","do"));
*         this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_AUTO","auto"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_ELSE","else"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_LONG","long"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_BREAK","break"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_ENUM","enum"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_REGISTER","register"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_TYPEDEF","typedef"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_EXTERN","extern"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_UNION","union"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_CONTINUE","continue"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_GOTO","goto"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_SIZEOF","sizeof"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_VOLATILE","volatile"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_DEFAULT","default"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"KEY_STATIC","static"));

*       this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_CHAR","char"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_SHORT","short"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_UNSIGNED","unsigned"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_CONST","const"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_SIGNED","signed"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_VOID","void"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"TYPE_STRUCT","struct"));

        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_MOD","%"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_INC","++"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_DEC","--"));

                this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_LESS_THANE","<="));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_GREATER_THANE",">="));

                this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_LOG_AND","&&"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_LOG_OR","||"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_LOG_NOT","!"));

         this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_AND","&"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_OR","|"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_XOR","^"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_LEFT_SHIFT","<<"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_RIGHT_SHIFT",">>"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"OP_BIT_NOT","~"));

                this.mainDataBase.add(new TokenBasic(orderNumber++,"ADDRESS","&"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"POINTER","*"));

             this.mainDataBase.add(new TokenBasic(orderNumber++,"DOT","."));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"ARROW","->"));

              this.mainDataBase.add(new TokenBasic(orderNumber++,"COLON",":"));
        this.mainDataBase.add(new TokenBasic(orderNumber++,"QUESTION_MARK","?"));

*
*
* TO DO - comments in multiple lines - not trivial
*  'x' for chars
*  other types for integer literals like octal, hexadecimal etc
*  preprocessor macros presented there https://www.tutorialspoint.com/cprogramming/c_preprocessors.htm
*
* */
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
























