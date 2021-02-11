package com.rpatel1291;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {

    private static final String SAMPLE_FILE =  "src/com/rpatel1291/resources/sample.txt";
    private static final String INPUT_FILE = "src/com/rpatel1291/resources/input.txt";

    public static void main(String[] args) {
        try{
            ArrayList<List<String>> inputList1 = importData(INPUT_FILE);
            System.out.println("Result for Part 1: " + processDataForPart1(inputList1));

            ArrayList<List<String>> inputList2 = importData(INPUT_FILE);
            System.out.println("Result for Part 2: " + processDataForPart2(inputList2));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static ArrayList<List<String>> importData(String file) throws IOException{
        ArrayList<List<String>> data = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        while(line != null){
            List<String> lineList = Arrays.asList(line.replace("-"," ").replace(":","").split(" "));
            data.add(lineList);
            line = bufferedReader.readLine();
        }
        return data;
    }

    /**
     * processDataForPart1
     *
     * @param data
     * @return
     */
    private static int processDataForPart1(ArrayList<List<String>> data){
        int result = 0;
        for(List<String> line : data){
            int min = Integer.parseInt(line.get(0));
            int max = Integer.parseInt(line.get(1));
            String s = line.get(2);
            int counter = 0;
            for(char letter : line.get(3).toCharArray()){
                if(s.equals(String.valueOf(letter))) counter++;
            }
            if( min <=  counter && counter<= max) result++ ;

        }
        return result;
    }

    /**
     * processDataForPart2
     *
     * @param data
     * @return
     */
    private static int processDataForPart2(ArrayList<List<String>> data) {
        int result = 0;
        for(List<String> line : data){
            int e1 = Integer.parseInt(line.get(0)) - 1;
            int e2 = Integer.parseInt(line.get(1)) - 1;

            String s = line.get(2);

            char[] charArray = line.get(3).toCharArray();

            boolean check1 = s.equals(String.valueOf(charArray[e1]));
            boolean check2 = s.equals(String.valueOf(charArray[e2]));

            if (check1 && check2) result+=0;
            else if(check1 || check2) result++;
        }
        return result;
    }
}

