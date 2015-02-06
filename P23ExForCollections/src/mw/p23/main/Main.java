package mw.p23.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    private static final int MAX_LINES = 1000;
    
    public static void main(String[] args) {
        if (!checkArgs(args)) {
            return;
        }
        Path filename = Paths.get(args[0]);
        if (!Files.exists(filename)) {
            System.out.printf("file %s does't exist.\n", filename);
            printUsage();
            return;
        } else {
            System.out.println(filename);
        }
        
        int linesTotal = Integer.parseInt(args[1]);
        if (linesTotal > MAX_LINES) {
            System.out.printf("there is a limit to print no more than %d lines.\n", MAX_LINES);
            linesTotal = MAX_LINES;
        } else if (linesTotal < 1) {
            System.out.println("the second argument is less than 1. Let's try to print one line.\n");
            linesTotal = 1;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename.toString()
                ))) {
            int lineCounter = 0;
  
            List<String> strList = new ArrayList<String>(linesTotal);
            String aLine;
            while ((lineCounter++ < linesTotal) && !((aLine=br.readLine()) == null)) {
                strList.add(aLine);
            }
            Collections.shuffle(strList);
            for (String string : strList) {
                System.out.println(string);
            }
        } 
        catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return;
        }
        catch (IOException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return;
        }


    }
    
    private static boolean checkArgs(String[] args) {
        if (!(args.length == 2)) {
            printUsage();
            return false;
        }
        return true;
    }
    
    private static void printUsage() {
        System.out.println("2 arguments are expected: 1st is a filename, 2nd - number of lines to process.");
        return;
    }

}
