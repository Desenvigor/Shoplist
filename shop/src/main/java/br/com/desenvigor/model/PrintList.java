package br.com.desenvigor.model;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

public class PrintList {

    public static void printFile(List<String> text){
        try {
            PrintStream ps = new PrintStream("Shoplist.txt");
            for (String line : text){
                ps.println(line);
            }
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
