package org.example;
import java.util.Scanner;

public class TemperatureAnalyzer {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String dayOneTempString;
        String dayTwoTempString;
        String dayThreeTempString;


        System.out.println("=== 🌧️Daily Temperature Tracker & Analyzer 🌦️ ===");
        System.out.println();

        // input from user
        System.out.println("Input daily temperature in Celsius (e.g. 20.3)");
        System.out.print("1. Enter Day 1 High Temperature: ");
        dayOneTempString = scanner.nextLine();

        System.out.print("2. Enter Day 2 High Temperature: ");
        dayTwoTempString = scanner.nextLine();

        System.out.print("3. Enter Day 3 High Temperature: ");
        dayThreeTempString = scanner.nextLine();
        System.out.println();

        // parsing into primitive type

        double dayOneTempPrimitive = 0.0;
        double dayTwoTempPrimitive = 0.0;
        double dayThreeTempPrimitive = 0.0;

        try{
            dayOneTempPrimitive = Double.parseDouble(dayOneTempString);
        }catch (NumberFormatException e){
            System.out.println("[> ERR: Invalid Input for Day 1(" + dayOneTempString + ") | Using Default Value: 0.0");
        }

        try{
            dayTwoTempPrimitive = Double.parseDouble(dayTwoTempString);
        }catch (NumberFormatException e){
            System.out.println("[> ERR: Invalid Input for Day 2 (" + dayTwoTempString + ") | Using Default Value: 0.0");
        }

        try{
            dayThreeTempPrimitive = Double.parseDouble(dayThreeTempString);
        }catch (NumberFormatException e){
            System.out.println("[> ERR: Invalid Input for Day 3 (" + dayThreeTempString + ") | Using Default Value: 0.0]");
        }


        System.out.println("=== 🌡️ Temperature Analysis ===");

        System.out.println("Day 1 Temperature (Parsed to Primitive Double): " + dayOneTempPrimitive);
        System.out.println("Day 2 Temperature (Parsed to Primitive Double): " + dayTwoTempPrimitive);
        System.out.println("Day 3 Temperature (Parsed to Primitive Double): " + dayThreeTempPrimitive);

        // converting primitives to wrappers
        Double dayOneTempWrapper = Double.valueOf(dayOneTempPrimitive);
        Double dayTwoTempWrapper = Double.valueOf(dayTwoTempPrimitive);
        Double dayThreeTempWrapper = Double.valueOf(dayThreeTempPrimitive);

        // comparison
        int comparisonResult1 = dayOneTempWrapper.compareTo(dayTwoTempWrapper);

        System.out.println();
        if (comparisonResult1 > 0){
            System.out.println("[📊ANALYSIS] Day 1 (" + dayOneTempWrapper + "C) was warmer than Day 2 (" + dayTwoTempWrapper + "C).");
        }else if (comparisonResult1 < 0) {
            System.out.println("[📊ANALYSIS] Day 1 (" + dayOneTempWrapper +"C) was colder than Day 2 (" + dayTwoTempWrapper + "C).");
        }else{
            System.out.println("[📊ANALYSIS] Day 1 (" + dayOneTempWrapper +"C) was the same temperature as  Day 2 (" + dayTwoTempWrapper + "C).");
        }

        // primitive extraction
        float dayOneTempFloat = dayOneTempWrapper.floatValue();
        int dayTwoTempInt = dayTwoTempWrapper.intValue();

        System.out.println();
        System.out.println("Extracted Day 1 Temperature (Primitive Float from Double Wrapper): " + dayOneTempFloat);
        System.out.println("Extracted Day 2 Temperature (Primitive Int from Double Wrapper): " + dayTwoTempInt);
        System.out.println("Note: Decimal part is truncated when converting double into int.");
        System.out.println();


        // extension
        Double maxTemp = dayOneTempWrapper;
        int maxTempDay = 1;

        if(dayTwoTempWrapper.compareTo(maxTemp) > 0){
            maxTemp = dayTwoTempWrapper;
            maxTempDay = 2;
        }

        if(dayThreeTempWrapper.compareTo(maxTemp) > 0){
            maxTemp = dayThreeTempWrapper;
            maxTempDay = 3;
        }

        System.out.println("☀️ Day " + maxTempDay + " recorded the highest temperature with " + maxTemp +"C.");
        System.out.println("\n=== Analysis Complete ===");
    }



}
