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
        int right = 3;
        int down = 1;
        int col = 3;
//        System.out.println(data.size());
//        System.out.println(data.get(0).size());
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
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println("Result for part 1: " + countTree);
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
}
