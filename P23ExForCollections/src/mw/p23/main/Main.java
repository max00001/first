package mw.p23.main;

import java.io.BufferedReader;
import java.io.File;
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

    private static final int MAX_LINES_TO_OUT = 1000;
    private static final int AV_LINE_LENGTH = 25; // to calculate lines number
    
    public static void main(String[] args) {
        if (!checkArgs(args)) {
            return;
        }
        Path filename = Paths.get(args[0]).toAbsolutePath();
        if (!Files.exists(filename)) {            
            System.out.printf("file %s does't exist.\n", filename);
            printUsage();
            return;
        }
        
        File file = filename.toFile();
        double tmpLinesInFile = Math.ceil(file.length()/AV_LINE_LENGTH);
        System.out.println("Lines in the file (approx.): " + tmpLinesInFile);
        if (tmpLinesInFile > Integer.MAX_VALUE) {
            System.out.println("The file is huge. "
                    + "It cannot be processed"); //TODO - remove the limit
            return;
        } 
        int linesInFile = (int)tmpLinesInFile; //safe thanks to the previous check
        
        int linesTotalToOut = Integer.parseInt(args[1]);
        if (linesTotalToOut > MAX_LINES_TO_OUT) {
            System.out.printf("there is a limit to print no more than %d lines.\n", MAX_LINES_TO_OUT);
            linesTotalToOut = MAX_LINES_TO_OUT;
        } else if (linesTotalToOut < 1) {
            System.out.println("the second argument is less than 1. Let's try to print one line.\n");
            linesTotalToOut = 1;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename.toString()
                ))) {
              
            List<String> strList = new ArrayList<String>(linesInFile);
            String aLine;
            while (!((aLine=br.readLine()) == null)) {
                strList.add(aLine);
            }
            if (linesTotalToOut > strList.size()) {
                linesTotalToOut = strList.size();
            }
            Collections.shuffle(strList);
            for (String string : strList.subList(0, linesTotalToOut)) {
                System.out.println(string);
            }
        } 
//        FileNotFoundException will be processed as IOException
//        catch (FileNotFoundException e) {
//            // TODO: handle exception
//            System.out.println(e.getMessage());
//            return;
//        }
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
