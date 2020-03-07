package com.console;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
    public String calculate(String expression){
        String[] args = expression.split(" ");
        if(args.length != 3){
            try {
                throw new Exception("Incorrect number of args. Need 3.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.exit(-1);
        }
        boolean isRoman = checkExpression(args);
        if(isRoman){
            args[0] = romanToArab(args[0]).toString();
            args[2] = romanToArab(args[2]).toString();
        }
        Integer result = 0;
        switch (args[1]){
            case "+":
                result = Operations.addition(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
                break;
            case "-":
                result = Operations.subtraction(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
                break;
            case "*":
                result = Operations.multiplication(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
                break;
            case "/":
                result = Operations.divison(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
                break;

        }
        String resultString = expression;
        if(isRoman){
            resultString += " = " + arabToRoman(result);
        }
        else {
            resultString += " = " + result.toString();
        }
        return resultString;
    }

    private boolean checkExpression(String[] args){
        ArrayList<String> operations = new ArrayList<String>(Arrays.asList("+", "-", "*", "/"));
        if(args[1].length() != 1 || !operations.contains(args[1])){
            try {
                throw new Exception("Incorrect operation!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.exit(-1);
        }

        boolean isRoman = false;
        int arabCount = 0;
        int romanCount = 0;

        for(int i = 0; i <= 2; i += 2) {
            int number;
            if (isInteger(args[i])){
                number = Integer.parseInt(args[i]);
                arabCount++;
            } else {
                number = romanToArab(args[i]);
                romanCount++;
                isRoman = true;
            }
            if(number < 1 || number > 10){
                try {
                    throw new Exception("Incorrect number. Need in interval 1-10.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.exit(-1);
            }
        }

        if(arabCount != 2 && romanCount != 2){
            try {
                throw new Exception("Incorrect number format. Need roman or arabic only.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.exit(-1);
        }
        return isRoman;
    }

    private Integer romanToArab(String arab){
        switch (arab.toUpperCase()){
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return -1;
        }
    }

    private String arabToRoman(Integer arab){
        String result = "";
        if(arab / 10 == 2) return "XX";
        if(arab / 10 == 1){
            result += "X";
        }
        switch (arab % 10){
            case 1:
                result += "I";
                break;
            case 2:
                result += "II";
                break;
            case 3:
                result += "III";
                break;
            case 4:
                result += "IV";
                break;
            case 5:
                result += "V";
                break;
            case 6:
                result += "VI";
                break;
            case 7:
                result += "VII";
                break;
            case 8:
                result += "VIII";
                break;
            case 9:
                result += "IX";
                break;
        }
        return result;
    }

    public boolean isInteger(String strNum){
        try{
            Integer.parseInt(strNum);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
