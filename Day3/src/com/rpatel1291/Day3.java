package com.rpatel1291;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {

    private static final String SAMPLE_FILE = "src/com/rpatel1291/resources/sample.txt";
    private static final String INPUT_FILE = "src/com/rpatel1291/resources/input.txt";
    private static ArrayList<String[]> data;
    private static final String TREE = "#";
    private static final String OPEN_SQUARE = ".";
    private static final String CHECKED_OPEN = "O";
    private static final String CHECKED_TREE = "X";


    public static void main(String[] args) {

        data = importData(INPUT_FILE);

        int resultForPart1 = numberOfTreeEncountered(data,3,1);

        System.out.println("Result for part 1: " + resultForPart1);

        int[] rightSlopes = new int[]{1,3,5,7,1};
        int[] downSlopes = new int[]{1,1,1,1,2};
        long resultForPart2 = 1L;

        for(int i = 0 ; i < rightSlopes.length; i++){
            resultForPart2 *= numberOfTreeEncounteredPart2(importData(INPUT_FILE),rightSlopes[i], downSlopes[i]);
        }

        System.out.println("Result for part 2: " + resultForPart2);

    }


    private static ArrayList<String[]> importData(final String file){
        ArrayList<String[]> data = null;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            data = new ArrayList<>();
            while((line = bufferedReader.readLine())!=null){
               data.add(line.split(""));
            }
            return data;
        } catch (FileNotFoundException e) {
            System.out.println(String.format("Error while getting file: {}. Reason: {}",file, e.getMessage()));
        } catch (IOException e) {
            System.out.println(String.format("Error while reading file: {}. Reason: {}",file, e.getMessage()));
        }
        return data;
    }

    private static int numberOfTreeEncountered(ArrayList<String[]> data, int right, int down){

        int col = right;

        for(int row = down; row < data.size(); row += down){
            String[] line = data.get(row);
            if(line[col].equals(OPEN_SQUARE)) {
                line[col] = CHECKED_OPEN;
            }
            else{
                if(line[col].equals(TREE)){
                    line[col] = CHECKED_TREE;
                }
            }
            if (col > 0) {
                col = (col + right) % line.length;
            }
            else{
                col += right;
            }
        }

        int countTree = 0;

        for(String[] i : data){
            for(String j : i){
                if(j.equals(CHECKED_TREE)) countTree++;
//                System.out.print(j);
            }
//            System.out.println();
        }

        return countTree;
    }

    private static int numberOfTreeEncounteredPart2(ArrayList<String[]> data, int right, int down){

        int col = 0;

        for(int row = 0; row < data.size(); row += down){
            String[] line = data.get(row);
            if(line[col].equals(OPEN_SQUARE)) {
                line[col] = CHECKED_OPEN;
            }
            else{
                if(line[col].equals(TREE)){
                    line[col] = CHECKED_TREE;
                }
            }
            if (col > 0) {
                col = (col + right) % line.length;
            }
            else{
                col += right;
            }
        }

        int countTree = 0;

        for(String[] i : data){
            for(String j : i){
                if(j.equals(CHECKED_TREE)) countTree++;
            }
        }

        return countTree;
    }
}
