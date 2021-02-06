package com.rpatel1291;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1 {

    /**
     *  Day 1: Part 1
     *
     *
     */


    private static Map<Integer,Integer> inputData;
    private static List<Integer> inputList;
    private static final String SAMPLE_FILE_LOCATION = "src/com/rpatel1291/resources/sample.txt" ;
    private static final String INPUT_FILE_LOCATION = "src/com/rpatel1291/resources/input.txt" ;
    private static final int TARGET_SUM = 2020;

    public static void main(String[] args) {
        importData();
        int resultForPart1 = findMaxWithTwoEntries();
        int resultForPart2 = findMaxWithThreeEntries();
        System.out.println("Part1: " + resultForPart1);
        System.out.println("Part2: " + resultForPart2);
    }

    /**
     * ImportData method reads in file and loads it into a HashMap for quick search
     */
    private static void importData() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE_LOCATION))){
            String line = bufferedReader.readLine();
            inputData = new HashMap<>();
            inputList = new ArrayList<>();
            while(line != null){
                inputData.put(Integer.valueOf(line),1);
                inputList.add(Integer.valueOf(line));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FindMaxWithTwoEntries method finds the largest product of two numbers that sum to 2020
     * @return max
     */
    private static int findMaxWithTwoEntries(){
        int max = 0;
        for(int i : inputList){
            if(inputData.containsKey(TARGET_SUM-i)){
                int product = i * (TARGET_SUM-i);
                max = Math.max(max, product);
            }
        }
        return max;
    }

    /**
     * FindMaxWithThreeEntries method finds the largest product of three numbers that sum to 2020
     * @return max
     */
    private static int findMaxWithThreeEntries(){
       int max = 0;
       for(int i = 0; i < inputList.size(); i++){
           for(int j = 1; j < inputList.size(); j++){
               if(inputData.containsKey(TARGET_SUM-inputList.get(i)-inputList.get(j))){
                   int product = inputList.get(i) * inputList.get(j) * (TARGET_SUM-inputList.get(i)-inputList.get(j));
                   max = Math.max(max, product);
               }
           }
       }
        return max;
    }


}
