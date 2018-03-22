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

        try (BufferedReader br = new BufferedReader(new FileReader(".\\resources\\fczytajmnie.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {

                for( String str : line.split(" ")){
                    stringsFromFile.add(str);
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }

        for(String str : stringsFromFile){
            tokenOutputs.addAll(tokenDB.match(str));
        }

        for(TokenOutput ready : tokenOutputs){
            System.out.println("TOKEN--ID "+ready.getId_code()+"--DESC "+ready.getDescription());
        }
    }
}
