package project.scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        TokenDB tokenDB = new TokenDB();

        ArrayList<String> stringsFromFile = new ArrayList<>();

        ArrayList<TokenOutput> tokenOutputs = new ArrayList<>();

        int index;

        String strToAdd;

        try (BufferedReader br = new BufferedReader(new FileReader(".\\resources\\example.c"))) {

            String line;

            while ((line = br.readLine()) != null) {

                index=0;

                strToAdd = "";

                while(index<line.length()-1){

                    if((int)line.charAt(index) == 32){    //is a space

                        index++;
                        if(strToAdd.length()!=0){
                            stringsFromFile.add(strToAdd);
                            strToAdd = "";
                        }
                        continue;
                    }
                    if((int)line.charAt(index) == 34){    //is a "

                        if(line.indexOf("\"",index+1)>-1){

                            strToAdd = line.substring(index,line.indexOf("\"",index+1)+1);

                            stringsFromFile.add(strToAdd);
                            strToAdd = "";

                            index = line.indexOf("\"",index+1)+1;

                            continue;
                        }else{
                            index++;
                        }
                    }
                    strToAdd = strToAdd + line.charAt(index);

                    index++;
                }
                if(index==line.length()-1){
                    strToAdd = strToAdd + line.charAt(index);
                   if(strToAdd.length()!=0){
                      stringsFromFile.add(strToAdd);
                   }
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        /*
        for(String ready : stringsFromFile){
            System.out.println(ready);
        }
        */
        for(String str : stringsFromFile){
            tokenOutputs.addAll(tokenDB.match(str));
        }

        for(TokenOutput ready : tokenOutputs){
            System.out.println("TOKEN--ID "+ready.getId_code()+"--DESC "+ready.getDescription());
        }
    }
}
