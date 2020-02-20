package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import resolvers.ProblemResolver;

public class ReadUtils {

    public static void readFile(String fileIn, ProblemResolver resolver, String fileOut){
        File problemFile = new File(fileIn);
        ArrayList<String> lines = readAllFileLines(problemFile);
        resolver.setUpData(lines,fileOut);
    }
    private static ArrayList<String> readAllFileLines(File file){
        ArrayList<String> lines = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
        }
        return lines;
    }
    public static int[] readLine(String line, int numberOfElements){
        Scanner sce = new Scanner(line);
        int [] data = new int [numberOfElements];
        for(int i = 0; i < numberOfElements; i++){
            data[i] = sce.nextInt();
        }
        return data;
    }

    public static int[][] readLines(ArrayList<String> lines){
        return null;
    }

    public static void printSolution(ArrayList<String> lines,String fileName){
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            System.out.println(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for(String line: lines){
            printWriter.println(line);
        }
        printWriter.close();
    }
    public static String transformArray(ArrayList<Integer> list){
      String sr = "";
      for (Integer val: list){
          sr+= " " + val;
      }
      return sr.substring(1);
    }
}
